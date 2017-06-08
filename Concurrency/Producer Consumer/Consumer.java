package com.company;

/**
 * Created by Student3 on 2017-04-03.
 */
public class Consumer implements Runnable {

    int number;
    int time;

    public Consumer(int number, int time) throws InterruptedException {
        this.number = number;
        this.time = time;
    }

    public void run(){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Main.availableProducts.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Main.criticalSection.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //what happens inside critical section
        Main.size -- ;
        System.out.println("I am the consumer nr " + this.number);
        System.out.println("I've just consumed product nr " + (Main.size + 1));
        Main.criticalSection.release();

        Main.emptyPlaces.release();

        //
    }


}