package com.example.backend.model;

public class Base {
    private int i;

    private static int j;

    public Base() {
        System.out.println("base constructor start");
        i++;
        j++;
        System.out.println("base constructor called, i: " + i + ", j: " + j);
        new Inner();
        new Static();
        System.out.println("base constructor end");
    }

    static
    {
        j = 1;
        System.out.println("base static block called, j: " + j);
    }

    {
        i = 10;
        System.out.println("base non-static block called, i: " + i);
    }

    private class Inner {
        private int i;

        private static int j;

        public Inner() {
            i++;
            j++;
            System.out.println("base inner class constructor called, i: " + i + ", j: " + j);
        }

        static
        {
            j = 100;
            System.out.println("base inner class static block called, j: " + j);
        }

        {
            i = 1000;
            System.out.println("base inner class non-static block called, i: " + i);
        }
    }

    public static class Static {
        private int i;

        private static int j;

        public Static() {
            i++;
            j++;
            System.out.println("base static class constructor called, i: " + i + ", j: " + j);
        }

        static
        {
            j = 10000;
            System.out.println("base static class static block called, j: " + j);
        }

        {
            i = 100000;
            System.out.println("base static class non-static block called, i: " + i);
        }
    }
}
