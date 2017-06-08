package com.company;

public class Main {

    public static void main(String[] args) {

        PriorityQueue q = new PriorityQueue(50);
        int[] table = new int[10];
        table[0] = 1;
        table[1] = 2;
        table[2] = 10;
        table[3] = 5;
        table[4] = 14;
        table[5] = 23;
        table[6] = 16;
        table[7] = 3;
        table[8] = 20;
        table[9] = 6;



        q.buildHeap(table);
       // q.newPrint();
        q.print();
        q.insert(5);
        q.insert(6);
        q.insert(7);
        q.insert(8);
       // q.newPrint();
        q.print();
        q.insert(3);
       // q.newPrint();
        q.print();

    }
}
