package Main;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("NOTShellshockLive");

        Values values = new Values();
        GameDisplay display = new GameDisplay(values);
        window.add(display);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
        values.setVisible(true);

        display.startGameThread();
    }
}
