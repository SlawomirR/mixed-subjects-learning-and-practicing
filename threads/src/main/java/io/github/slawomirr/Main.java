package io.github.slawomirr;

public class Main {

    public static void main(String[] args) {
        System.out.println(ThreadColorIntellijConsole.ANSI_PURPLE + "Hello from the main thread.");

        Thread anotherThread = new AnotherThread();
        anotherThread.start();

        new Thread() {

            @Override
            public void run() {
                System.out.println(ThreadColorIntellijConsole.ANSI_GREEN + "Hello from the anonymous class thread.");
            }
        }.start();

        System.out.println(ThreadColorIntellijConsole.ANSI_PURPLE + "Hello again from the main thread.");
    }
}
