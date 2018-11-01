package io.github.slawomirr.producer_consumer_synchronized_demo;

public class Main {

    public static void main(String[] args) {
        MyBufferOne myBufferOne = new MyBufferOne();
        MyProducerOne p = new MyProducerOne(myBufferOne);
        MyConsumerOne c = new MyConsumerOne(myBufferOne);

        Thread pt = new Thread(p);
        Thread ct = new Thread(c);
        ct.start();
        pt.start();
    }
}
