package com.company;

/**
 * Created by Student3 on 2017-04-03.
 */
public class Producer implements Runnable {

    int number;
    int time;

    public Producer(int number, int time) throws InterruptedException {
        this.number = number;
        this.time = time;
    }

    public void run(){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        };
        try {
            Main.emptyPlaces.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Main.criticalSection.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //what happens inside critical section
        Main.size ++ ;
        System.out.println("I am the producer nr " + this.number);
        System.out.println("I've just produced product nr " + Main.size);
        Main.criticalSection.release();
        Main.availableProducts.release();
    }

}
