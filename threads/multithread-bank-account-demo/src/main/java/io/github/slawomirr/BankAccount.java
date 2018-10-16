package io.github.slawomirr;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount {

    private Lock lock;
    private double balance;
    private String accountNumber;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.lock = new ReentrantLock();
    }

//    public synchronized void deposit(double amount) {
//        balance += amount;
//    }
//
//    public synchronized void withdraw(double amount) {
//        balance -= amount;
//    }

    public void deposit(double amount) {
        boolean status = false;
        try {
            if (lock.tryLock(1_000, TimeUnit.MILLISECONDS)) {
                try {
                    balance += amount;
                    status = true;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println(Main.ANSI_RESET + "Could not get the lock! (deposit)");
            }
        } catch (InterruptedException e) {
            System.out.println(Main.ANSI_RED + "Deposit thread interrupted");
        }
        System.out.println(Main.ANSI_RESET + "Transaction status = " + status);
    }

    public void withdraw(double amount) {
        boolean status = false;
        try {
            if (lock.tryLock(1_000, TimeUnit.MILLISECONDS)) {
                try {
                    balance -= amount;
                    status = true;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Could not get the lock! (withdraw)");
            }
        } catch (InterruptedException e) {
            System.out.println(Main.ANSI_RED + "Withdraw thread interrupted");
        }
        System.out.println(Main.ANSI_RESET + "Transaction status = " + status);
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void printAccountNumber() {
        System.out.println("Account number = " + accountNumber);
    }
}