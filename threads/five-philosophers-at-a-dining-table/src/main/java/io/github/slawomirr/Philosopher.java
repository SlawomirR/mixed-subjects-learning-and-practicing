package io.github.slawomirr;

import java.util.concurrent.locks.Lock;

class Philosopher implements Runnable {

    private final Lock leftFork;
    private final Lock rightFork;
    private final String philosopherName;

    Philosopher(Lock leftFork, Lock rightFork, String philosopherName) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.philosopherName = philosopherName;
    }

    void think(String lastWord) {
        System.out.println(philosopherName + " is thinking " + lastWord);
    }

    void eat() {
        if (leftFork.tryLock()) {
            try {
                if (rightFork.tryLock()) {
                    try {
                        System.out.println(philosopherName + " is eating :-)");
                    } finally {
                        rightFork.unlock();
                    }
                }
            } finally {
                leftFork.unlock();
            }
        }
    }

    @Override
    public void run() {
        this.think("...");
        this.eat();
        this.think("again !!! :-)");
    }
}
