package com.brest.senlainc;

import java.util.Scanner;

public class Task3IntersectionSegments {

    public static void main(String[] args) {
        System.out.println("Enter segment 1");
        System.out.println("\tEnter point 1");
        System.out.print("\t\tEnter coordinate x: ");
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        System.out.print("\t\tEnter coordinate y: ");
        int y1 = in.nextInt();
        System.out.println("\tEnter point 2");
        System.out.print("\t\tEnter coordinate x: ");
        int x2 = in.nextInt();
        System.out.print("\t\tEnter coordinate y: ");
        int y2 = in.nextInt();

        System.out.println("Enter segment 2");
        System.out.println("\tEnter point 1");
        System.out.print("\t\tEnter coordinate x: ");
        int x3 = in.nextInt();
        System.out.print("\t\tEnter coordinate y: ");
        int y3 = in.nextInt();
        System.out.println("\tEnter point 2");
        System.out.print("\t\tEnter coordinate x: ");
        int x4 = in.nextInt();
        System.out.print("\t\tEnter coordinate y: ");
        int y4 = in.nextInt();
        in.close();

        System.out.println("Coordinate segments");
        System.out.println("\tCoordinate segments 1: (" + x1 + ", " + y1 + ") (" + x2 + ", " + y2 + ")");
        System.out.println("\tCoordinate segments 2: (" + x3 + ", " + y3 + ") (" + x4 + ", " + y4 + ")");

        Point p1 = new Point(x1, y1);
        Point p2 = new Point(x2, y2);
        Point p3 = new Point(x3, y3);
        Point p4 = new Point(x4, y4);

        if(Intersection.checkIntersection(p1, p2, p3, p4))
            System.out.println("Segments intersect");
        else
            System.out.println("Segments do not intersect");
    }
}

class Point {
    private int x, y;

    public Point (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

class Intersection {
    static public boolean checkIntersection(Point p1, Point p2, Point p3, Point p4) {
        //упорядочиваем точки, чтобы p1.x <= p2.x и p3.x <= p4.x
        if (p2.getX() < p1.getX()) {
            Point tmp = p1;
            p1 = p2;
            p2 = tmp;
        }

        if (p4.getX() < p3.getX()) {
            Point tmp = p3;
            p3 = p4;
            p4 = tmp;
        }

        //проверяем чтобы крайняя правая точка первого отрезка была правее чем крайняя левая точка второго отрезка
        if (p2.getX() < p3.getX()) {
            //если уловие выполняется, то отрезки не могут иметь общих точек
            return false;
        }

        //если оба отрезка вертикальные
        if ((p1.getX() - p2.getX() == 0) && (p3.getX() - p4.getY() == 0)) {
            //если они лежат на одном X
            if (p1.getX() == p3.getX()) {
                //проверим пересекаются ли они, т.е. есть ли у них общий Y
                //для этого возьмём отрицание от случая, когда они НЕ пересекаются
                return !((Math.max(p1.getY(), p2.getY()) < Math.min(p3.getY(), p4.getY())) ||
                        (Math.min(p1.getY(), p2.getY()) > Math.max(p3.getY(), p4.getY())));
            }
            return false;
        }

        //найдём коэффициенты уравнений, содержащих отрезки
        //A – это тангенс угла между прямой и осью X
        //f1(x) = A1*x + b1 = y
        //f2(x) = A2*x + b2 = y

        //если первый отрезок вертикальный
        if (p1.getX() - p2.getX() == 0) {
            //найдём (x, y) - точка пересечения двух прямых
            int x = p1.getX();
            double A2 = (p3.getY() - p4.getY()) / (p3.getX() - p4.getX());
            double b2 = p3.getY() - A2 * p3.getX();
            double y = A2 * x + b2;
            //т. к. это уравнения прямых, необходимо проверить то что точка пересечения лежит в пределах отрезка
            return p3.getX() <= x && p4.getX() >= x &&
                    Math.min(p1.getY(), p2.getY()) <= y && Math.max(p1.getY(), p2.getY()) >= y;
        }

        //если второй отрезок вертикальный
        if (p3.getX() - p4.getX() == 0) {
            int x = p3.getX();
            double A1 = (p1.getY() - p2.getY()) / (p1.getX() - p2.getX());
            double b1 = p1.getY() - A1 * p1.getX();
            double y = A1 * x + b1;
            return p1.getX() <= x && p2.getX() >= x &&
                    Math.min(p3.getY(), p4.getY()) <= y && Math.max(p3.getY(), p4.getY()) >= y;
        }

        //оба отрезка невертикальные
        double A1 = (p1.getY() - p2.getY()) / (p1.getX() - p2.getX());
        double A2 = (p3.getY() - p4.getY()) / (p3.getX() - p4.getX());
        double b1 = p1.getY() - A1 * p1.getX();
        double b2 = p3.getY() - A2 * p3.getX();

        if (A1 == A2) {
            return false; //отрезки параллельны
        }

        //x - абсцисса точки пересечения двух прямых
        double x = (b2 - b1) / (A1 - A2);

        if ((x < Math.max(p1.getX(), p3.getX())) || (x > Math.min(p2.getX(), p4.getX()))) {
            return false; //точка x находится вне проекций отрезков на ось X
        } else {
            return true;
        }
    }
}