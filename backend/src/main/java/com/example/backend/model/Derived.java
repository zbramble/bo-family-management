package com.example.backend.model;

public class Derived extends Base{
    private int i;

    private static int j;

    public Derived() {
        System.out.println("derived constructor start");
        i++;
        j++;
        System.out.println("derived constructor called, i: " + i + ", j: " + j);
        new Inner();
        new Static();
        System.out.println("derived constructor end");
    }

    static
    {
        j = 2;
        System.out.println("derived static block called, j: " + j);
    }

    {
        i = 20;
        System.out.println("derived non-static block called, i: " + i);
    }

    private class Inner {
        private int i;

        private static int j;

        public Inner() {
            i++;
            j++;
            System.out.println("derived inner class constructor called, i: " + i + ", j: " + j);
        }

        static
        {
            j = 200;
            System.out.println("derived inner class static block called, j: " + j);
        }

        {
            i = 2000;
            System.out.println("derived inner class non-static block called, i: " + i);
        }
    }

    public static class Static {
        private int i;

        private static int j;

        public Static() {
            i++;
            j++;
            System.out.println("derived static class constructor called, i: " + i + ", j: " + j);
        }

        static
        {
            j = 20000;
            System.out.println("derived static class static block called, j: " + j);
        }

        {
            i = 200000;
            System.out.println("derived static class non-static block called, i: " + i);
        }
    }
}
