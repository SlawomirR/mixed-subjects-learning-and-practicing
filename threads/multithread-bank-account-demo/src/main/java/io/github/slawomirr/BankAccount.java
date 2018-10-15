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
        try {
            if (lock.tryLock(1_000, TimeUnit.MILLISECONDS)) {
                try {
                    balance += amount;
                } finally {
                    lock.unlock();
                }
            }
        } catch (InterruptedException e) {
            System.out.println(Main.ANSI_RED + "Could not get the lock! (deposit)");
        }
    }

    public void withdraw(double amount) {
        try {
            if (lock.tryLock(1_000, TimeUnit.MILLISECONDS)) {
                try {
                    balance -= amount;
                } finally {
                    lock.unlock();
                }
            }
        } catch (InterruptedException e) {
            System.out.println(Main.ANSI_RED + "Could not get the lock! (withdraw)");
        }
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