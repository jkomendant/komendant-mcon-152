package komendant.projectile;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Projectile {

    public static final double EARTH_GRAVITY = 9.8;

    private final double angle;
    private final double velocity;
    private double time;

    public Projectile(double angle, double velocity) {
        this.angle = Math.toRadians(angle);
        this.velocity = velocity;
    }

    public double getX(){
        return velocity * cos(angle) * time;
    }

    public double getY(){
        return velocity * sin(angle) * time - EARTH_GRAVITY * time * time;
    }

    public void increaseTime(double delta){
        time += delta;
    }

    @Override
    public String toString() {
        return "time " + time + ": (" + String.format("%.4f", getX()) + ", "+ String.format("%.4f", getY()) + ")";
    }
}