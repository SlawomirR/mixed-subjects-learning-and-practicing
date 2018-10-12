package io.github.slawomirr;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(ThreadColorIntellijConsole.ANSI_RED + "Hello from MyRunnable's implementation of run().");
    }
}
