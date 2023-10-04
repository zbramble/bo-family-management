package com.example.backend.model;

public class Third extends Derived{
    private int i;

    private static int j;

    public Third() {
        System.out.println("third constructor start");
        i++;
        j++;
        System.out.println("third constructor called, i: " + i + ", j: " + j);
        new Inner();
        new Static();
        System.out.println("third constructor end");
    }

    static
    {
        j = 3;
        System.out.println("third static block called, j: " + j);
    }

    {
        i = 30;
        System.out.println("third non-static block called, i: " + i);
    }

    private class Inner {
        private int i;

        private static int j;

        public Inner() {
            i++;
            j++;
            System.out.println("third inner class constructor called, i: " + i + ", j: " + j);
        }

        static
        {
            j = 300;
            System.out.println("third inner class static block called, j: " + j);
        }

        {
            i = 3000;
            System.out.println("third inner class non-static block called, i: " + i);
        }
    }

    public static class Static {
        private int i;

        private static int j;

        public Static() {
            i++;
            j++;
            System.out.println("third static class constructor called, i: " + i + ", j: " + j);
        }

        static
        {
            j = 30000;
            System.out.println("third static class static block called, j: " + j);
        }

        {
            i = 300000;
            System.out.println("third static class non-static block called, i: " + i);
        }
    }
}
