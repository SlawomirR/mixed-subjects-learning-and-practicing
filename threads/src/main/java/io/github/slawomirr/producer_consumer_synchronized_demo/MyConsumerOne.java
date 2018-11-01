package io.github.slawomirr.producer_consumer_synchronized_demo;

class MyConsumerOne implements Runnable {

    private final MyBufferOne myBufferOne;

    MyConsumerOne(MyBufferOne myBufferOne) {
        this.myBufferOne = myBufferOne;
    }

    @Override
    public void run() {
        while (true) {
            myBufferOne.consume();
        }
    }
}
