package com.ildar;

public class Symplex {

    double a, b, c, d, e, f;
    double x1, x2;
    double l;
    double eps;
    String minmax;
    int count = 0;

    Triangle s;

    public Symplex(double a, double b, double c, double d, double e, double f, double x1, double x2, double l, double eps, String minmax) {
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

    public void createTriangle () {
        Dot x, y, z;
        x = new Dot(x1, x2);
        y = new Dot(x1 + l, x2);
        z = new Dot(x1 + (l / 2), x2 + Math.abs(Math.pow(l, 2) - Math.pow(l / 2, 2)));

        s = new Triangle(x, y, z);
    }

    public double calculateF (Dot x) {
        return a * x.getX1() * x.getX1() + b * x.getX1() * x.getX2() + c * x.getX2() * x.getX2() + d * x.getX1() + e * x.getX2() + f;
    }

    public void findX() {
        if (minmax == "MIN") {
            if (calculateF(s.getX1()) > calculateF(s.getX2())){
                if (calculateF(s.getX3()) > calculateF(s.getX1()))
                    s.getX3().setMin(true);
                else s.getX1().setMin(true);
            }
            else {
                if (calculateF(s.getX3()) > calculateF(s.getX2()))
                    s.getX3().setMin(true);
                else s.getX2().setMin(true);
            }
        } else {
            if (calculateF(s.getX1()) < calculateF(s.getX2())){
                if (calculateF(s.getX3()) < calculateF(s.getX1()))
                    s.getX3().setMin(true);
                else s.getX1().setMin(true);
            }
            else {
                if (calculateF(s.getX3()) < calculateF(s.getX2()))
                    s.getX3().setMin(true);
                else s.getX2().setMin(true);
            }
        }
    }

    void go () {
        createTriangle();
        System.out.println("---------------\n" + s.getX1().getX1() + " " + s.getX1().getX2() + "\n "
                + s.getX2().getX1() + " " + s.getX2().getX2() + " \n" + s.getX3().getX1() + " " + s.getX3().getX2() + " \n----------------" );

        while (count < 2000) {
            count++;
            findX();
            if (s.getX1().min)
                 System.out.print("---------------\n" + "F: " + calculateF(s.getX1()) + " \n");
            if (s.getX2().min)
                System.out.print("---------------\n" + "F: " + calculateF(s.getX2()) + " \n");
            if (s.getX3().min)
                System.out.print("---------------\n" + "F: " + calculateF(s.getX3()) + " \n");
            check();
            System.out.println(s.getX1().getX1() + " " + s.getX1().getX2() + "\n "
                    + s.getX2().getX1() + " " + s.getX2().getX2() + " \n" + s.getX3().getX1() + " " + s.getX3().getX2() + " \n----------------" );
        }
    }

    void check () {
        if ((s.getX1().getX2() == s.getX2().getX2()) || (s.getX1().getX2() == s.getX3().getX2()) || (s.getX3().getX2() == s.getX2().getX2()) ) {
            if      (s.getX1().min) {
                System.out.println("X1");
                if (s.getX1().getX2() != s.getX2().getX2() && s.getX1().getX2() != s.getX3().getX2()) {
                    if (s.getX1().getX2() > s.getX2().getX2()) {
                        s.getX1().setX2(s.getX1().getX2() - 2 * (Math.abs(Math.pow(l, 2) - Math.pow(l / 2, 2))));
                    } else {
                        s.getX1().setX2(s.getX1().getX2() + 2 * (Math.abs(Math.pow(l, 2) - Math.pow(l / 2, 2))));
                    }
                } else {
                    if (s.getX1().getX2() == s.getX2().getX2()) {
                        s.getX1().setX2(s.getX3().getX2());
                        if (s.getX1().getX1() < s.getX2().getX1()) {
                            s.getX1().setX1(s.getX1().getX1() + 1.5 * l);
                        } else {
                            s.getX1().setX1(s.getX1().getX1() - 1.5 * l);
                        }
                    } else {
                        s.getX1().setX2(s.getX2().getX2());
                        if (s.getX1().getX1() < s.getX3().getX1()) {
                            s.getX1().setX1(s.getX1().getX1() + 1.5 * l);
                        } else {
                            s.getX1().setX1(s.getX1().getX1() - 1.5 * l);
                        }
                    }
                }
            }
            else if (s.getX2().min) {
                System.out.println("X2");
                if (s.getX2().getX2() != s.getX1().getX2() && s.getX2().getX2() != s.getX3().getX2()) {
                    if (s.getX2().getX2() > s.getX1().getX2()) {
                        s.getX2().setX2(s.getX2().getX2() + 2 * (Math.abs(Math.pow(l, 2) - Math.pow(l / 2, 2))));
                    } else {
                        s.getX2().setX2(s.getX2().getX2() + 2 * (Math.abs(Math.pow(l, 2) - Math.pow(l / 2, 2))));
                    }
                } else {
                    if (s.getX2().getX2() == s.getX1().getX2()) {
                        s.getX2().setX2(s.getX3().getX2());
                        if (s.getX2().getX1() < s.getX1().getX1()) {
                            s.getX2().setX1(s.getX2().getX1() + 1.5 * l);
                        } else {
                            s.getX2().setX1(s.getX2().getX1() - 1.5 * l);
                        }
                    } else {
                        s.getX2().setX2(s.getX1().getX2());
                        if (s.getX2().getX1() < s.getX3().getX1()) {
                            s.getX2().setX1(s.getX2().getX1() + 1.5 * l);
                        } else {
                            s.getX2().setX1(s.getX2().getX1() - 1.5 * l);
                        }
                    }
                }
            }
            else if (s.getX3().min) {
                System.out.println("X3");
                if (s.getX3().getX2() != s.getX1().getX2() && s.getX3().getX2() != s.getX2().getX2()) {
                    if (s.getX3().getX2() > s.getX2().getX2()) {
                        s.getX3().setX2(s.getX3().getX2() + 2 * (Math.abs(Math.pow(l, 2) - Math.pow(l / 2, 2))));
                    } else {
                        s.getX3().setX2(s.getX3().getX2() + 2 * (Math.abs(Math.pow(l, 2) - Math.pow(l / 2, 2))));
                    }
                } else {
                    if (s.getX3().getX2() == s.getX2().getX2()) {
                        s.getX3().setX2(s.getX1().getX2());
                        if (s.getX3().getX1() < s.getX2().getX1()) {
                            s.getX3().setX1(s.getX3().getX1() + 1.5 * l);
                        } else {
                            s.getX3().setX1(s.getX3().getX1() - 1.5 * l);
                        }
                    } else {
                        s.getX3().setX2(s.getX2().getX2());
                        if (s.getX3().getX1() < s.getX1().getX1()) {
                            s.getX3().setX1(s.getX3().getX1() + 1.5 * l);
                        } else {
                            s.getX3().setX1(s.getX3().getX1() - 1.5 * l);
                        }
                    }
                }
            }
        }
        s.getX1().setMin(false);
        s.getX2().setMin(false);
        s.getX3().setMin(false);
    }






}
