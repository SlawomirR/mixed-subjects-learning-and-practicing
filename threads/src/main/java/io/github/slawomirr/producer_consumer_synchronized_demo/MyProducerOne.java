package io.github.slawomirr.producer_consumer_synchronized_demo;

import java.util.Random;

class MyProducerOne implements Runnable {

    private final MyBufferOne myBufferOne;
    private Random random;

    MyProducerOne(MyBufferOne myBufferOne) {
        this.myBufferOne = myBufferOne;
        random = new Random(Integer.MAX_VALUE);
    }

    @Override
    public void run() {
        while (true) {
            myBufferOne.produce(random.nextInt());
        }
    }
}
