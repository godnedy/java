package com.company;

import java.util.Random;

public class ReadingRoom {


    private int numReadersWaiting;
    private int numWritersWaiting;
    private int numReadersInside;
    private int numWritersInside;
    private boolean writersTurn;

    public static Random random;


    public ReadingRoom(){
        this.numReadersWaiting = 0;
        this.numWritersWaiting = 0;
        this.writersTurn = false;  // assuming there is more readers than writers it is better to start from readers
        this.random = new Random();
     }

    public synchronized void prepareToRead() throws InterruptedException {
        this.numReadersWaiting++;
        while(this.numWritersInside > 0 || this.numWritersWaiting > 0 && this.writersTurn){
            System.out.println("Thread nr " + Thread.currentThread().getName() + " waits");

            wait();
        }
        this.numReadersWaiting--;
        this.numReadersInside++;
        this.writersTurn = true;
    }

    public synchronized void endReading(){
        this.numReadersInside--;
        System.out.println("Thread nr " + Thread.currentThread().getName() + " ended reading");

        notifyAll();

    }

    public synchronized void prepareToWrite() throws InterruptedException {
        this.numWritersWaiting++;
        while(this.numReadersInside > 0 || this.numWritersInside > 0){
            System.out.println("Thread nr " + Thread.currentThread().getName() + " waits");

            wait();
        }
        this.numWritersWaiting--;
        this.numWritersInside++;
    }

    public synchronized void endWriting(){
        this.numWritersInside--;
        System.out.println("Thread nr " + Thread.currentThread().getName() + " ended writing");

        notifyAll();
        this.writersTurn = false;
    }


    public static void main(String[] args) {

        ReadingRoom rr = new ReadingRoom();
        int n = 100; // number of threads
        for (int i = 0; i < n; i++) {
            int randomNumber = rr.random.nextInt(6);
            if(randomNumber%6 == 0) {  // approximately 1/6 of threads should be writers
                Thread t = new Thread(new Writer(rr), Integer.toString(i) + " (Writer)");
                t.start();
            }
            else{
                Thread t = new Thread(new Reader(rr), Integer.toString(i)+ " (Reader)");
                t.start();
            }

        }

    }
}
