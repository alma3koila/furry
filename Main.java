package com.example.ads;
import java.util.Scanner;
import java.util.*;

public class Main {

    // рекурсия моя


    public static void printDigits(int n) {
        if (n < 10) {
            System.out.println(n);
            return;
        }
        printDigits(n / 10);
        System.out.println(n % 10);
    }

    public static int sumArray(int[] arr, int index) {
        if (index == arr.length) return 0;
        return arr[index] + sumArray(arr, index + 1);
    }

    public static void fillArray(int[] arr, int index, Scanner sc) {
        if (index == arr.length) return;
        arr[index] = sc.nextInt();
        fillArray(arr, index + 1, sc);
    }

    public static boolean isPrime(int n, int d) {
        if (n < 2) return false;
        if (d * d > n) return true;
        if (n % d == 0) return false;
        return isPrime(n, d + 1);
    }

    public static int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    public static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static long power(int a, int n) {
        if (n == 0) return 1;
        return a * power(a, n - 1);
    }

    public static void reverseNumbers(int n, Scanner sc) {
        if (n == 0) return;
        int x = sc.nextInt();
        reverseNumbers(n - 1, sc);
        System.out.print(x + " ");
    }

    public static boolean onlyDigits(String s, int index) {
        if (index == s.length()) return true;
        if (!Character.isDigit(s.charAt(index))) return false;
        return onlyDigits(s, index + 1);
    }

    public static int countChars(String s) {
        if (s.isEmpty()) return 0;
        return 1 + countChars(s.substring(1));
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // дата стракчур

    static LinkedList<String> list = new LinkedList<>();
    static Stack<String> stack = new Stack<>();
    static Queue<String> queue = new LinkedList<>();

    // линкедлист
    public static void addToList(Scanner sc) {
        System.out.print("Enter value: ");
        String s = sc.next();
        list.add(s);
    }

    public static void showList() {
        for (String s : list) {
            System.out.println(s);
        }
    }

    //STACK
    public static void pushStack(Scanner sc) {
        System.out.print("Enter value: ");
        String s = sc.next();
        stack.push(s);
    }

    public static void popStack() {
        if (!stack.isEmpty()) {
            System.out.println("Popped: " + stack.pop());
        }
    }

    //очередь
    public static void addQueue(Scanner sc) {
        System.out.print("Enter value: ");
        String s = sc.next();
        queue.add(s);
    }

    public static void processQueue() {
        if (!queue.isEmpty()) {
            System.out.println("Processed: " + queue.poll());
        }
    }



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LinkedList<BankAccount> accounts = new LinkedList<>();
        Stack<String> history = new Stack<>();
        Queue<String> billQueue = new LinkedList<>();

        while (true) {

            System.out.println("\n===== MENU =====");
            System.out.println("1 Recursion demo (factorial)");
            System.out.println("2 LinkedList add");
            System.out.println("3 LinkedList show");
            System.out.println("4 Stack push");
            System.out.println("5 Stack pop");
            System.out.println("6 Queue add");
            System.out.println("7 Queue process");
            System.out.println("0 Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1 -> {
                    System.out.print("Enter number: ");
                    int n = sc.nextInt();
                    System.out.println(factorial(n));
                }

                case 2 -> addToList(sc);
                case 3 -> showList();

                case 4 -> pushStack(sc);
                case 5 -> popStack();

                case 6 -> addQueue(sc);
                case 7 -> processQueue();

                case 0 -> {
                    System.out.println("Bye!");
                    return;
                }
            }
        }
    }
}