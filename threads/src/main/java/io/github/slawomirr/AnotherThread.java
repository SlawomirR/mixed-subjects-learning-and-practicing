package io.github.slawomirr;

public class AnotherThread extends Thread {

    @Override
    public void run() {
        System.out.println(ThreadColorIntellijConsole.ANSI_BLUE + "Hello from another thread.");
    }
}
