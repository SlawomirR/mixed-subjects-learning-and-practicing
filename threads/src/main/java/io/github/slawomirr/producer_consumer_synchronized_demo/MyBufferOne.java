package io.github.slawomirr.producer_consumer_synchronized_demo;

class MyBufferOne {

    private int data;
    private boolean empty;
    private int stopCounter;

    MyBufferOne() {
        this.empty = true;
    }

    synchronized void produce(int newData) {
        while (!empty) {
            try {
                this.wait();
            } catch (InterruptedException e) {
//                e.printStackTrace();
            }
        }
        data = newData;
        System.out.println("produced: " + data);
        empty = false;
        this.notifyAll();
    }

    synchronized int consume() {
        while (empty) {
            try {
                this.wait();
            } catch (InterruptedException e) {
//                e.printStackTrace();
            }
        }
        System.out.println("consume: " + data);
        empty = true;
        this.notifyAll();
        stopCounter++;
        if (stopCounter == 100) {
            System.exit(0);
        }
        return data;
    }
}
