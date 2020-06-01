package com.ildar;

import java.util.Random;

public class HJMethod {

    double a, b, c, d, e, f;
    double x1, x2;
    double l;
    double eps;
    String minmax;
    Dot[] vectors;
    Dot previusDot, newDot;
    Random random = new Random();
    int count = 0;

    public HJMethod(double a, double b, double c, double d, double e, double f, double x1, double x2, double l, double eps, String minmax) {
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

    public double calculateF (Dot x) {
        return a * x.getX1() * x.getX1() + b * x.getX1() * x.getX2() + c * x.getX2() * x.getX2() + d * x.getX1() + e * x.getX2() + f;
    }

    public void go () {
        previusDot = new Dot(x1, x2);

        do {
            newDot = stepX1(previusDot);
            newDot = stepX2(previusDot);

            Dot tmpNew = newDot;
            Dot tmpPrev = previusDot;

            if (minmax.equals("MAX")) {
                if (calculateF(newDot) > calculateF(previusDot)){

                    newDot = new Dot(previusDot.getX1() + ( 2.0 * (newDot.getX1() - previusDot.getX1())),
                                     previusDot.getX2() + ( 2.0 * (newDot.getX2() - previusDot.getX2())));
                    previusDot = tmpNew;

                    if (calculateF(previusDot) >= calculateF(newDot)) {
                        previusDot = tmpPrev;
                        newDot = tmpNew;
                        System.out.println("___________________________________________raspad_");
                    }

                    System.out.println("-------------------------------");
                    System.out.println("F: " + calculateF(newDot));
                    System.out.println("x1 : " + newDot.getX1() + "         x2 : " + newDot.getX2());
                    System.out.println("-------------------------------");

                } else {
                    l = l / 2.0;
                    System.out.println(" ___________________________________________drob");
                }
            } else {
                if (calculateF(newDot) < calculateF(previusDot)) {
                    newDot = new Dot(previusDot.getX1() + ( 2 * (newDot.getX1() - previusDot.getX1())),
                            previusDot.getX2() + ( 2 * (newDot.getX2() - previusDot.getX2())));
                    previusDot = tmpNew;

                    if (calculateF(previusDot) < calculateF(newDot)) {
                        previusDot = tmpPrev;
                        newDot = tmpNew;
                        l = l / 2.0;
                        System.out.println("___________________________________________drob_");
                    }

                    System.out.println("F: " + calculateF(newDot));
                    System.out.println("x1 : " + newDot.getX1() + "         x2 : " + newDot.getX2());
                    System.out.println("-------------------------------");
                } else {
                    l = l / 2.0;
                    System.out.println("___________________________________________drob");
                }
            }
        } while (Math.abs(calculateF(newDot) - calculateF(previusDot)) > eps);
    }

    Dot stepX1 (Dot x) {
        Dot res = x;
        Dot x1 = new Dot(x.getX1() + l, x.getX2());
        Dot x2 = new Dot(x.getX1() - l, x.getX2());

        if (minmax.equals("MAX")) {
            if (calculateF(x) > calculateF(x1)) {
                if (calculateF(x) > calculateF(x2)) {
                    res = x;
                } else {
                    if (calculateF(x1) > calculateF(x2)){
                        res = x1;
                    } else {
                        res = x2;
                    }
                }
            } else {
                if (calculateF(x1) > calculateF(x2)) {
                    res = x1;
                } else {
                    if (calculateF(x2) > calculateF(x)){
                        res = x2;
                    } else {
                        res = x;
                    }
                }
            }
        } else {
            if (calculateF(x) < calculateF(x1)) {
                if (calculateF(x) < calculateF(x2)) {
                    res = x;
                } else {
                    if (calculateF(x1) < calculateF(x2)){
                        res = x1;
                    } else {
                        res = x2;
                    }
                }
            } else {
                if (calculateF(x1) < calculateF(x2)) {
                    res = x1;
                } else {
                    if (calculateF(x2) < calculateF(x)){
                        res = x2;
                    } else {
                        res = x;
                    }
                }
            }
        }
        return res;
    }

    Dot stepX2 (Dot x) {
        Dot res = x;
        Dot x1 = new Dot(x.getX1(), x.getX2() + l);
        Dot x2 = new Dot(x.getX1(), x.getX2() - l);

        if (minmax.equals("MAX")) {
            if (calculateF(x) > calculateF(x1)) {
                if (calculateF(x) > calculateF(x2)) {
                    res = x;
                } else {
                    if (calculateF(x1) > calculateF(x2)){
                        res = x1;
                    } else {
                        res = x2;
                    }
                }
            } else {
                if (calculateF(x1) > calculateF(x2)) {
                    res = x1;
                } else {
                    if (calculateF(x2) > calculateF(x)){
                        res = x2;
                    } else {
                        res = x;
                    }
                }
            }
        } else {
            if (calculateF(x) < calculateF(x1)) {
                if (calculateF(x) < calculateF(x2)) {
                    res = x;
                } else {
                    if (calculateF(x1) < calculateF(x2)){
                        res = x1;
                    } else {
                        res = x2;
                    }
                }
            } else {
                if (calculateF(x1) < calculateF(x2)) {
                    res = x1;
                } else {
                    if (calculateF(x2) < calculateF(x)){
                        res = x2;
                    } else {
                        res = x;
                    }
                }
            }
        }
        return res;
    }

    boolean checkStep (Dot x1, Dot x2) {
        if (x1.getX1() == x2.getX1() && x1.getX2() == x2.getX2())
            return false;
        return true;
    }


}
