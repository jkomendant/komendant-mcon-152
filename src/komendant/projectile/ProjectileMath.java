package komendant.projectile;

import java.util.ArrayList;
import java.util.Random;

public class ProjectileMath {


    public static void main(String[] args) {

        Random rand = new Random();
        final int NUM_PROJECTILES = 5;
        ArrayList<Projectile> projectileList = new ArrayList<>();

        for (int j = 0; j < NUM_PROJECTILES; j++) {
            projectileList.add(new Projectile(rand.nextDouble() * 180, rand.nextDouble() * 100));
        }
        for (Projectile projectile : projectileList) {
            for (int i = 0; i < 12; i++) {
                System.out.println("Projectile " + projectileList.indexOf(projectile) + ": " + projectile.toString());
                projectile.increaseTime(1);
            }
            System.out.println();
        }
    }
}