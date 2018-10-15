package io.github.slawomirr.producer_consumer_demo;

import java.util.concurrent.*;

import static io.github.slawomirr.ThreadColorIntellijConsole.*;
import static io.github.slawomirr.producer_consumer_demo.Main.EOF;

public class Main {

    public static final String EOF = "EOF";

    public static void main(String[] args) {
        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<>(6);
        ExecutorService executorService = Executors.newFixedThreadPool(3); // should be 4 to print future.get() immediately
        MyProducer producer = new MyProducer(buffer, ANSI_YELLOW);
        MyConsumer consumer1 = new MyConsumer(buffer, ANSI_PURPLE);
        MyConsumer consumer2 = new MyConsumer(buffer, ANSI_CYAN);

        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() {
                System.out.println(ANSI_WHITE + "I'm being printed from the Callable class.");
                return "This is the callable result.";
            }
        });

        try {
            System.out.println(future.get());
        } catch (ExecutionException e) {
            System.out.println(ANSI_RED + "Something went wrong");
        } catch (InterruptedException e) {
            System.out.println(ANSI_RED + "Thread running the task was interrupted");
        }

        executorService.shutdown();
    }
}

class MyProducer implements Runnable {

    private ArrayBlockingQueue<String> buffer;
    private String color;

    public MyProducer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        String[] nums = {"1", "2", "3", "4", "5"};

        for (String num : nums) {
            try {
                System.out.println(color + "Adding ... " + num);
                buffer.put(num);
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
        }
        System.out.println(color + "Adding EOF and exiting...");
        try {
            buffer.put(EOF);
        } catch (InterruptedException e) {

        }
    }
}

class MyConsumer implements Runnable {

    private ArrayBlockingQueue<String> buffer;
    private String color;

    public MyConsumer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (buffer) {
                try {
                    if (buffer.isEmpty()) {
                        continue;
                    }
                    if (buffer.peek().equals(EOF)) {
                        System.out.println(color + "Exiting");
                        break;
                    } else {
                        System.out.println(color + "Removed: " + buffer.take());
                    }
                } catch (InterruptedException e) {

                }
            }
        }
    }
}
