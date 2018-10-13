package io.github.slawomirr.counter_demo;

import static io.github.slawomirr.ThreadColorIntellijConsole.*;

public class Main {

    public static final String THREAD_ONE = "Thread 1";
    public static final String THREAD_TWO = "Thread 2";

    public static void main(String[] args) {
        Countdown countdown = new Countdown();

        CountdownThread t1 = new CountdownThread(countdown);
        t1.setName(THREAD_ONE);
        CountdownThread t2 = new CountdownThread(countdown);
        t2.setName(THREAD_TWO);

        t1.start();
        t2.start();
    }
}

class Countdown {

    private int i;

    public /*synchronized*/ void doCountdown() {
        String color;

        switch (Thread.currentThread().getName()) {
            case Main.THREAD_ONE:
                color = ANSI_CYAN;
                break;
            case Main.THREAD_TWO:
                color = ANSI_PURPLE;
                break;
            default:
                color = ANSI_GREEN;
        }

        synchronized (this) {
//        for (int i = 10; i > 0; i--) {
            for (i = 10; i > 0; i--) {
                System.out.println(color + Thread.currentThread().getName() + ": i = " + i);
            }
        }
    }
}

class CountdownThread extends Thread {

    private Countdown threadCountdown;

    public CountdownThread(Countdown countdown) {
        threadCountdown = countdown;
    }

    public void run() {
        threadCountdown.doCountdown();
    }
}
