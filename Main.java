package com.example.ads;

import java.util.*;

public class Main {

    // ===== recursion (оставил твое) =====

    public static int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    // ===== BANK SYSTEM STRUCTURES =====

    static LinkedList<BankAccount> accounts = new LinkedList<>();
    static Stack<String> history = new Stack<>();
    static Queue<String> billQueue = new LinkedList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== BANK MENU =====");
            System.out.println("1 Add Account");
            System.out.println("2 Show Accounts");
            System.out.println("3 Deposit");
            System.out.println("4 Withdraw");
            System.out.println("5 Add Bill");
            System.out.println("6 Process Bill");
            System.out.println("7 Show History");
            System.out.println("8 Recursion (factorial)");
            System.out.println("0 Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1 -> {
                    System.out.print("Account number: ");
                    int id = sc.nextInt();

                    System.out.print("Username: ");
                    String name = sc.next();

                    System.out.print("Balance: ");
                    double bal = sc.nextDouble();

                    accounts.add(new BankAccount(id, name, bal));
                }

                case 2 -> {
                    for (BankAccount a : accounts) {
                        a.display();
                    }
                }

                case 3 -> {
                    System.out.print("Username: ");
                    String name = sc.next();

                    System.out.print("Deposit: ");
                    double amount = sc.nextDouble();

                    for (BankAccount a : accounts) {
                        if (a.username.equals(name)) {
                            a.deposit(amount);
                            history.push("Deposit " + amount + " to " + name);
                        }
                    }
                }

                case 4 -> {
                    System.out.print("Username: ");
                    String name = sc.next();

                    System.out.print("Withdraw: ");
                    double amount = sc.nextDouble();

                    for (BankAccount a : accounts) {
                        if (a.username.equals(name)) {
                            a.withdraw(amount);
                            history.push("Withdraw " + amount + " from " + name);
                        }
                    }
                }

                case 5 -> {
                    System.out.print("Bill name: ");
                    String bill = sc.next();
                    billQueue.add(bill);
                }

                case 6 -> {
                    System.out.println("Processed: " + billQueue.poll());
                }

                case 7 -> {
                    System.out.println(history);
                }

                case 8 -> {
                    System.out.print("Enter number: ");
                    int n = sc.nextInt();
                    System.out.println(factorial(n));
                }

                case 0 -> {
                    System.out.println("Bye!");
                    return;
                }
            }
        }
    }
}