package io.github.slawomirr;

import java.util.concurrent.atomic.AtomicBoolean;

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {

        double initialDeposit = 1_000.0;
        final BankAccount account = new BankAccount("12345-678", initialDeposit);

        double personOneDeposit = 300;
        double personOneWithdraw = 50;
        double personTwoDeposit = 203.75;
        double personTwoWithdraw = 100;

        System.out.println("Initial deposit: " + account.getBalance());

        Thread t1 = new Thread() {
            @Override
            public void run() {
                System.out.print(ANSI_GREEN + "P1_D: " + "start balance: " + account.getBalance());
                account.deposit(personOneDeposit);
                System.out.println(ANSI_GREEN + " D1=> " + personOneDeposit + " end balance: " + account.getBalance());

                System.out.print(ANSI_GREEN + "P1_W: " + "start balance: " + account.getBalance());
                account.withdraw(personOneWithdraw);
                System.out.println(ANSI_GREEN + " W1<= " + personOneWithdraw + " end balance: " + account.getBalance());
            }
        };
        t1.setName("Thread of person One");

        Thread t2 = new Thread() {
            @Override
            public void run() {
                System.out.print(ANSI_PURPLE + "P2_D: " + "start balance: " + account.getBalance());
                account.deposit(personTwoDeposit);
                System.out.println(ANSI_PURPLE + " D2=>: " + personTwoDeposit + " end balance: " + account.getBalance());

                System.out.print(ANSI_PURPLE + "P2_W: " + "start balance: " + account.getBalance());
                account.withdraw(personTwoWithdraw);
                System.out.println(ANSI_PURPLE + " W2<= " + personTwoWithdraw + " end balance: " + account.getBalance());
            }
        };
        t2.setName("Thread of person Two");

        t1.start();
        t2.start();

        AtomicBoolean finished = new AtomicBoolean(false);
        while (!finished.get()) {
            if (t1.isAlive() || t2.isAlive()) {
                try {
                    System.out.println(ANSI_RESET + "As the MAIN Thread I'm sleeping now");
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("Why exception? This thread should sleep :-)");
                }
            } else {
                System.out.println(ANSI_RESET + "Current balance: " + account.getBalance() + " when ==>"
                        + " t1 is: " + (t1.isAlive() ? "alive" : "stopped")
                        + " and t2 is: " + (t2.isAlive() ? "alive" : "stopped")
                );
                finished.set(true);
            }
        }
    }
}
