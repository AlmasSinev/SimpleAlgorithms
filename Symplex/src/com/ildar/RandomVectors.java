package com.ildar;

import java.util.Random;

public class RandomVectors {

    double a, b, c, d, e, f;
    double x1, x2;
    double l;
    double eps;
    String minmax;
    Dot[] vectors;
    Dot maxmin;
    Random random = new Random();
    int count = 0;

    public RandomVectors(double a, double b, double c, double d, double e, double f, double x1, double x2, double l, double eps, String minmax) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.x1 = x1;
        this.x2 = x2;
        this.l = l;
        this.eps = eps;
        this.minmax = minmax;
    }

    void go () {
        maxmin = new Dot(x1, x2);
        while (count < 5000) {
            if (minmax.equals("MAX")) {
                vectors = new Dot[10];
                for (int i = 0; i < 10; i++)
                    vectors[i] = new Dot(maxmin.getX1() + new Random().nextDouble(), maxmin.getX2() + new Random().nextDouble());
                for ( int i = 0; i < 10; i++) {
                    if (calculateF(vectors[i]) > calculateF(maxmin))
                        maxmin = vectors[i];
                }
                System.out.println("------------------");
                System.out.println("F : " + calculateF(maxmin));
                System.out.println("x1 : " + maxmin.getX1() + "   x2 : " + maxmin.getX2());
                System.out.println("------------------");
            } else {
                vectors = new Dot[10];
                for (int i = 0; i < 10; i++)
                    vectors[i] = new Dot(maxmin.getX1() + random.nextDouble(), maxmin.getX2() + random.nextDouble());
                for ( int i = 0; i < 10; i++) {
                    if (calculateF(vectors[i]) < calculateF(maxmin))
                        maxmin = vectors[i];
                }
                System.out.println("------------------");
                System.out.println("F : " + calculateF(maxmin));
                System.out.println("x1 : " + maxmin.getX1() + "   x2 : " + maxmin.getX2());
                System.out.println("------------------");
            }
            count++;
        }
    }

    public double calculateF (Dot x) {
        return a * x.getX1() * x.getX1() + b * x.getX1() * x.getX2() + c * x.getX2() * x.getX2() + d * x.getX1() + e * x.getX2() + f;
    }
}
