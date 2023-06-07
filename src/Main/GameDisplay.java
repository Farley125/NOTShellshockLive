package Main;
import javax.swing.*;
import java.awt.*;

import Entity.Projectile;
import Entity.Tank;

public class GameDisplay extends JPanel implements Runnable{
    Thread gameThread;
    KeyHandler keyH = new KeyHandler();
    Values values;
    Tank player1 = new Tank(this, keyH, values);
    Projectile proj;
    public boolean currentProjectile;
    int currentFlightTime = 0;
    final int FPS = 60;
    public GameDisplay(Values values) {
        this.values = values;
        this.setPreferredSize(new Dimension(1940, 1040));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (gameThread != null) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                if (currentProjectile) {
                    proj.calculateX(currentFlightTime);
                    proj.calculateY(currentFlightTime);
                }
                delta--;
                drawCount++;
            }

            if (timer >= 1000000000) {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update() {
        player1.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.white);
        player1.draw(g2);
        g2.dispose();
    }

    public void newProjectile() {
        //proj = new Projectile(player1.x, player1.angle);
    }
}
