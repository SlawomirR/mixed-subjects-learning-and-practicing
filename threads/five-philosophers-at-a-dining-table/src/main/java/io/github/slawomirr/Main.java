package io.github.slawomirr;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * The problem goes like this: five philosophers spend all of their time either thinking or eating. They sit around
 * a circular table with five chairs and five forks. There are only five forks and all five philosophers need to pick
 * the two nearest (one from his left and one from his right) forks to eat. Once a philosopher finishes eating, he
 * puts down both forks and starts thinking. A philosopher cannot pick up a fork if his neighbor is using it. What
 * happens if each of the five philosophers picks up one fork from his right and waits for his left fork to be
 * released by his neighbor?
 */
public class Main {

    public static void main(String[] args) {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();
        Lock lock3 = new ReentrantLock();
        Lock lock4 = new ReentrantLock();
        Lock lock5 = new ReentrantLock();

        Philosopher philosopher1 = new Philosopher(lock1, lock2, "John");
        Philosopher philosopher2 = new Philosopher(lock2, lock3, "Wallace");
        Philosopher philosopher3 = new Philosopher(lock3, lock4, "Michail");
        Philosopher philosopher4 = new Philosopher(lock4, lock5, "Joana");
        Philosopher philosopher5 = new Philosopher(lock5, lock1, "Michelle");

        Thread t1 = new Thread(philosopher1);
        Thread t2 = new Thread(philosopher2);
        Thread t3 = new Thread(philosopher3);
        Thread t4 = new Thread(philosopher4);
        Thread t5 = new Thread(philosopher5);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
