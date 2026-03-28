package com.example.main;

import java.util.Scanner;

public class MainApplication {

    public static void printDigits(int n) {
        if (n < 10) {
            System.out.println(n);
            return;
        }
        printDigits(n / 10);
        System.out.println(n % 10);
    }

    public static int sumArray(int[] arr, int index) {
        if (index == arr.length) {
            return 0;
        }
        return arr[index] + sumArray(arr, index + 1);
    }

    public static void fillArray(int[] arr, int index, Scanner sc) {
        if (index == arr.length) {
            return;
        }
        arr[index] = sc.nextInt();
        fillArray(arr, index + 1, sc);
    }

    public static boolean isPrime(int n, int d) {
        if (n < 2) {
            return false;
        }
        if (d * d > n) {
            return true;
        }
        if (n % d == 0) {
            return false;
        }
        return isPrime(n, d + 1);
    }

    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static long power(int a, int n) {
        if (n == 0) {
            return 1;
        }
        return a * power(a, n - 1);
    }

    public static void reverseNumbers(int n, Scanner sc) {
        if (n == 0) {
            return;
        }
        int x = sc.nextInt();
        reverseNumbers(n - 1, sc);
        System.out.print(x + " ");
    }

    public static boolean onlyDigits(String s, int index) {
        if (index == s.length()) {
            return true;
        }
        if (!Character.isDigit(s.charAt(index))) {
            return false;
        }
        return onlyDigits(s, index + 1);
    }

    public static int countChars(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        return 1 + countChars(s.substring(1));
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Task 1");
        int n1 = sc.nextInt();
        printDigits(n1);

        System.out.println("Task 2");
        int n2 = sc.nextInt();
        int[] arr = new int[n2];
        fillArray(arr, 0, sc);
        int sum = sumArray(arr, 0);
        System.out.println((double) sum / n2);

        System.out.println("Task 3");
        int n3 = sc.nextInt();
        if (isPrime(n3, 2)) {
            System.out.println("Prime");
        } else {
            System.out.println("Composite");
        }

        System.out.println("Task 4");
        int n4 = sc.nextInt();
        System.out.println(factorial(n4));

        System.out.println("Task 5");
        int n5 = sc.nextInt();
        System.out.println(fibonacci(n5));

        System.out.println("Task 6");
        int a = sc.nextInt();
        int n6 = sc.nextInt();
        System.out.println(power(a, n6));

        System.out.println("Task 7");
        int count = sc.nextInt();
        reverseNumbers(count, sc);
        System.out.println();

        System.out.println("Task 8");
        String s1 = sc.next();
        System.out.println(onlyDigits(s1, 0) ? "Yes" : "No");

        System.out.println("Task 9");
        String s2 = sc.next();
        System.out.println(countChars(s2));

        System.out.println("Task 10");
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println(gcd(x, y));

        sc.close();
    }
}