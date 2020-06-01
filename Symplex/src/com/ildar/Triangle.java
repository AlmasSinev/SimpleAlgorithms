package com.ildar;

public class Triangle {

    Dot x1, x2, x3, findX;

    public Triangle (Dot x1, Dot x2, Dot x3) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
    }

    public Dot getX1() {
        return x1;
    }

    public void setX1(Dot x1) {
        this.x1 = x1;
    }

    public Dot getX2() {
        return x2;
    }

    public void setX2(Dot x2) {
        this.x2 = x2;
    }

    public Dot getX3() {
        return x3;
    }

    public void setX3(Dot x3) {
        this.x3 = x3;
    }
}
