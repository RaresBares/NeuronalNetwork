package de.nn;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Scanner;

public class NeuronalNetwork {
    static ArrayList<Point2D> pointsinsects = new ArrayList<>();
    static ArrayList<Point2D> pointsworms = new ArrayList<>();
    static Point2D avgworm;
    static Point2D avgins;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("PROOF or LEARN");
        String msg = sc.nextLine();
        if (msg.equalsIgnoreCase("PROOF")) {

        } else {
            if (msg.equalsIgnoreCase("LEARN")) {

                String msg2 = sc.nextLine();

                if (msg2.equalsIgnoreCase("WORM")) {
                    learn(pointsworms);
                } else {
                    if (msg2.equalsIgnoreCase("INSECT")) {
                        learn(pointsinsects);
                    } else {
                        System.exit(1);
                    }
                }
            } else {
                System.exit(1);
            }
        }
    }


    public static void learn(ArrayList<Point2D> points) {
        Scanner sc = new Scanner(System.in);
        boolean t = true;
        while (t) {

            System.out.println("Insert length");
            int length = Integer.parseInt(sc.nextLine());
            System.out.println("Insert wide");
            int wide = Integer.parseInt(sc.nextLine());
            points.add(new Point2D.Double(length, wide));
            String msg = sc.nextLine();

            if (msg.equalsIgnoreCase("proof")) {
                t = false;
                double neww = Integer.parseInt(sc.nextLine());
                double newl = Integer.parseInt(sc.nextLine());

                String type = proof(new Point2D.Double(neww, newl));
            } else {

            }

        }
    }

    public void avg() {
        {
            int amount = 0;
            int tx = 0;
            int ty = 0;
            for (Point2D pointsinsect : pointsinsects) {
                amount++;
                tx += pointsinsect.getX();
                ty += pointsinsect.getY();
            }
            Point2D point2D = new Point2D.Double(tx / amount, ty / amount);
        }
        {
            int amount = 0;
            int tx = 0;
            int ty = 0;
            for (Point2D pointsworm : pointsworms) {
                amount++;
                tx += pointsworm.getX();
                ty += pointsworm.getY();
            }
            Point2D point2D = new Point2D.Double(tx / amount, ty / amount);
        }


    }

    public static String proof(Point2D point2D) {
        double divins = point2D.distance(avgins);
        double divworm = point2D.distance(avgworm);
        String type = "";

        if (divins > divworm) {
            type = "Worm";
        }
        if (divins == divworm) {
            type = "Beides";
        }
        if (divins < divworm) {
            type = "Insect";
        }
        return type;
    }


}
