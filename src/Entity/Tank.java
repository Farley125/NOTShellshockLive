package Entity;
import Main.GameDisplay;
import Main.KeyHandler;
import Main.Values;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Tank extends Entity{

    GameDisplay display;
    KeyHandler keyH;
    Values values;
    private int power, angle;

    public Tank(GameDisplay display, KeyHandler keyH, Values values) {
        this.display = display;
        this.keyH = keyH;
        this.values = values;
        setDefaultValues();
        getImages();
    }

    public void setDefaultValues() {
        x = 130;
        y = 760;
        x2 = 1700;
        y2 = 760;
        power = 100;
        angle = 90;
        speed = .25;
    }

    public void getImages() {
        try {
            System.out.println("test");
            playerOne = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Images/greenTank.png"));
            playerTwo = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Images/blueTank.png"));
            background = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Images/background.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void update() {
        if (keyH.upPressed) {
            power += 1;
            values.updatePower(power);
        } else if (keyH.downPressed) {
            power -= 1;
            //values.updatePower(power);
        } else if (keyH.leftPressed) {
            angle -= 1;
            //values.updateAngle(angle);
        } else if (keyH.rightPressed) {
            angle += 1;
            values.updateAngle(angle);
        } else if (keyH.aPressed && x > 4) {
            x -= 5;
        } else if (keyH.dPressed && x < x2 - 64) {
            x += 5;
        } else if (keyH.gPressed && x2 > x + 64) {
            x2 -= 5;
        } else if (keyH.jPressed && x2 < 1854) {
            x2 += 5;
        } else if (keyH.spacePressed) {
            if (display.currentProjectile == false) {

            }
        }
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(background, 0, 0, 1940, 1040, null);
        g2.drawImage(playerOne, x, y, 60, 30, null);
        g2.drawImage(playerTwo, x2, y2, 60, 30, null);
    }
}
