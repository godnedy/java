package com.company;
import java.util.concurrent.Semaphore;
import java.util.Random;

public class Main {

    private static final int MAX = 100;
    public static final Semaphore emptyPlaces = new Semaphore(MAX, true);
    public static final Semaphore criticalSection = new Semaphore(1, true);
    public static final Semaphore availableProducts = new Semaphore(0, true);

    public static int[] bufor = new int[100];
    public static int size = 0;
    private static Random random = new Random();
    private static Thread[] consumers;
    private static Thread[] producers;


    public static void produce( Thread t) throws InterruptedException {
        emptyPlaces.acquire();
        criticalSection.acquire();
        //what happens inside critical section
        t.start();
        size ++ ;
        criticalSection.release();
        availableProducts.release();

    }

    public static void createProducersAndConsumers() throws InterruptedException {
        consumers = new Thread[100];
        producers = new Thread[100];

        for (int i= 0; i<100; i++){
            consumers[i] = new Thread(new Consumer(i, random.nextInt(200)));
            producers[i] = new Thread(new Producer(i, random.nextInt(200)));
        }
        for (int i= 0; i<100; i++){
            consumers[i].start();
            producers[i].start();
        }

    }


    public static void main(String[] args) throws InterruptedException {

    createProducersAndConsumers();

	// write your code here
    }
}
