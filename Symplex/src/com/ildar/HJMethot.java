package com.ildar;

public class HJMethot {

    double a, b, c, d, e, f;
    double x1, x2;
    double l;
    double eps;
    String minmax;
    Dot previusDot, newDot;

    public HJMethot(double a, double b, double c, double d, double e, double f, double x1, double x2, double l, double eps, String minmax) {
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
        previusDot = new Dot(x1, x2);
        do {

            if (minmax.equals("MAX")) {

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

    public double calculateF (Dot x) {
        return a * x.getX1() * x.getX1() + b * x.getX1() * x.getX2() + c * x.getX2() * x.getX2() + d * x.getX1() + e * x.getX2() + f;
    }


}
