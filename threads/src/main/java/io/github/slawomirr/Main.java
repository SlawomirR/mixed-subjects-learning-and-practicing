package io.github.slawomirr;

import static io.github.slawomirr.ThreadColorIntellijConsole.ANSI_RED;

public class Main {

    public static void main(String[] args) {
        System.out.println(ThreadColorIntellijConsole.ANSI_PURPLE + "Hello from the main thread.");

        Thread anotherThread = new AnotherThread();
        anotherThread.setName("== Another Thread ==");
        anotherThread.start();

        new Thread(() -> System.out.println(ThreadColorIntellijConsole.ANSI_GREEN + "Hello from the anonymous class thread."))
                .start();

        Thread myRunnableThread = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println(ANSI_RED + "Hello form the anonymous class's implementation of run().");
                try {
//                    anotherThread.join();
//                    System.out.println(ANSI_RED + "AnotherThread terminated, so I'm running again.");
                    anotherThread.join(2_000);
                    System.out.println(ANSI_RED + "AnotherThread terminated, or 2s timed out, so I'm running again.");
                } catch (InterruptedException e) {
                    System.out.println(ANSI_RED + "I couldn't wait after all. I was interrupted.");
                }
            }
        });
        myRunnableThread.start();
//        anotherThread.interrupt();

        System.out.println(ThreadColorIntellijConsole.ANSI_PURPLE + "Hello again from the main thread.");
    }
}
