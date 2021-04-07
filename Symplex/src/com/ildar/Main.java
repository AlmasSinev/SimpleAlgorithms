package com.ildar;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        double a, b, c, d, e, f;
        double x1, x2;
        double l;
        double eps;
        
        int[] arr = {123, 1, 64, 3, 675, 54, 23, 66, 647, 4, 0, -76, -9, 0, 88};
        
        Sorting sort = new Sorting();
        
        sort.showArr(arr);
        sort.mergeSort(arr);
        sort.showArr(arr);
        
//        Scanner in = new Scanner(System.in);
//
//        System.out.print("\nВведите a: ");
//        a = in.nextDouble();
//        System.out.print("\nВведите b: ");
//        b = in.nextDouble();
//        System.out.print("\nВведите c: ");
//        c = in.nextDouble();
//        System.out.print("\nВведите d: ");
//        d = in.nextDouble();
//        System.out.print("\nВведите e: ");
//        e = in.nextDouble();
//        System.out.print("\nВведите f: ");
//        f = in.nextDouble();
//        System.out.print("\n=============\nВведите x1: ");
//        x1 = in.nextDouble();
//        System.out.print("\nВведите x2: ");
//        x2 = in.nextDouble();
//        System.out.print("\nВведите l: ");
//        l = in.nextDouble();
//        System.out.print("\nВведите eps: ");
//        eps = in.nextDouble();

        //Math.abs(calculateF(s.getX1()) - calculateF(s.getX2())) < eps &&
        //                Math.abs(calculateF(s.getX1()) - calculateF(s.getX3())) < eps &&
        //                Math.abs(calculateF(s.getX3()) - calculateF(s.getX2())) < eps
        //


        //Symplex symplex = new Symplex(-1, 3, -8, 5, 6, -3, -7, 11,0.1, 0.02, "MAX");
        //symplex.go();

        //RandomVectors randomVectors = new RandomVectors(-1, 3, -8, 5, 6, -3, -7, 11,0.1, 0.02, "MAX");
        ////RandomVectors randomVectors2 = new RandomVectors(5, 1, 3, 4, -7, 2, 5, 4,0.1, 0.02, "MIN");
        //RandomVectors randomVectors3 = new RandomVectors(-3, 4, -4, 6, 4, 0, 9, 4,0.1, 0.02, "MAX");
        //randomVectors.go();


        //HJMethod hj = new HJMethod(-3, 4, -4, 6, 4, 0, 9, 4,1, 0.002, "MAX");
        //HJMethod hj2 = new HJMethod(5, 1, 3, 4, -7, 2, 5, 4,1, 0.002, "MIN");
        //hj.go();

    }
}
