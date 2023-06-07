package Main;

import javax.swing.*;

public class Values extends JFrame {
    private JLabel currentPower;
    private JPanel Values;
    private JLabel currentAngles;

    public Values() {
        setContentPane(Values);
        setTitle("Current Values");
        setSize(250,75);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    }

    public int getPower() {
        return Integer.parseInt(currentPower.getText().substring(15));
    }

    public int getAngle() {
        return Integer.parseInt(currentAngles.getText().substring(15));
    }

    public void updatePower(int power) {
        currentPower.setText("Current Power: " + power);
    }

    public void updateAngle(int angle) {
        currentAngles.setText("Current Angle: " + angle);
    }
}
