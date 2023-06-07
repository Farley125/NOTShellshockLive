package Entity;

public class Projectile extends Entity{
    int angle, power, startingX;

    public Projectile(int startingX, int ang, int pow) {
        this.startingX = startingX;
        angle = ang;
        power = pow;
    }

    public void calculateX(int time) {
        x = startingX + (int) (power * Math.cos(angle) * time);
    }

    public void calculateY(int time) {
        y = 760 - (int) ((power * Math.sin(angle) * time) - (4.9 * Math.pow(x, 2)));
    }
}
