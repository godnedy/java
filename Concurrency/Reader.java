package com.company;

/**
 * Created by Student3 on 2017-04-06.
 */
public class Reader implements Runnable {



    private ReadingRoom rr;


    public Reader(ReadingRoom rr){
        this.rr = rr;
    }


    @Override
    public void run() {
        try {
            this.rr.prepareToRead();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("I'am the thread nr " + Thread.currentThread().getName() + " and I am READING inside the ReadingRoom");
        try {
            Thread.sleep(rr.random.nextInt(20));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.rr.endReading();
    }
}
