package com.company;

/**
 * Created by Student3 on 2017-03-08.
 */
public class PriorityQueue {

    public int[] heap;
    private int heapSize;
    private int maxSize;


    public void downheap(int index) {
        int leftChildIndex = 2 * index;
        int rightChildIndex = 2 * index + 1;
        boolean swap = true;
        while (swap && (leftChildIndex <= this.heapSize)) {     // left Child exists
            if (rightChildIndex <= this.heapSize) {  // rightChild exists
                if (this.heap[leftChildIndex] <= this.heap[rightChildIndex]) {
                    if (this.heap[index] > this.heap[leftChildIndex]) {
                        int temp = this.heap[index];
                        this.heap[index] = this.heap[leftChildIndex];
                        this.heap[leftChildIndex] = temp;
                        index = leftChildIndex;

                    } else {
                        swap = false;
                    }
                } else {
                    if (this.heap[index] > this.heap[rightChildIndex]) {
                        int temp = this.heap[index];
                        this.heap[index] = this.heap[rightChildIndex];
                        this.heap[rightChildIndex] = temp;
                        index = rightChildIndex;
                    } else {
                        swap = false;
                    }
                }
            } else {
                if (this.heap[index] > this.heap[leftChildIndex]) {
                    int temp = this.heap[index];
                    this.heap[index] = this.heap[leftChildIndex];
                    this.heap[leftChildIndex] = temp;
                    index = leftChildIndex;
                } else {
                    swap = false;
                }


            }
            leftChildIndex = 2 * index;
            rightChildIndex = 2 * index + 1;
        }
    }


    public void upheap(int index) {
        int parentIndex = index / 2;
        while (parentIndex > 0 && this.heap[index] < this.heap[parentIndex]) {
            int temp = this.heap[index];
            this.heap[index] = this.heap[parentIndex];
            this.heap[parentIndex] = temp;

            index = parentIndex;
            parentIndex = index / 2;
        }
    }

    public PriorityQueue(int maxSize) {
        this.heap = new int[maxSize + 1]; //heap[0] not used
        this.heapSize = 0;
        this.maxSize = maxSize;
    }

    public int min() {  // returns minimal element
        return this.heap[1];
    }

    public int popMin() { // returns minimal element and removes it from the queue
        if (this.isEmpty()) {
            System.out.println("Heap empty");
            return -1;
        } else {
            int minimal = this.heap[1];
            this.heap[1] = this.heap[heapSize];
            heapSize--;
            this.downheap(1);
            return minimal;

        }
    }

    public void insert(int element) {
        if (this.heapSize == this.maxSize) {
            System.out.println("Queue is full");
        } else {
            heapSize++;
            this.heap[heapSize] = element;
            this.upheap(heapSize);
        }
    }

    public boolean isEmpty() {
        if (this.heapSize == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        return this.heapSize;
    }


    public void buildHeap(int[] table) { // builds heap from a table of ints
        for (int element : table) {
            this.insert(element);
        }
    }


    public void print() // na potrzeby testów

    {

        for (int i = 1; i <= this.heapSize / 2; i++)

        {

            System.out.print(" PARENT : " + this.heap[i] + " LEFT CHILD : " + this.heap[2 * i]

                    + " RIGHT CHILD :" + this.heap[2 * i + 1]);

            System.out.println();

        }

    }


    /*public void newPrint(){
    int a[] = new int[this.maxSize];
        for (int i = 0; i < this.heapSize; i++) {
            a[i] = this.heap[i+1];

        }
    StringBuilder sb = new StringBuilder();
    int max = 0;
    for(int i = 0; i<this.heapSize;i++)

    {
        for (int j = 0; j < Math.pow(2, i) && j + Math.pow(2, i) < this.heapSize; j++) {

            if (j > max) {
                max = j;
            }
        }

    }

    for(int i = 0; i<this.heapSize;i++)

    {
        for (int j = 0; j < Math.pow(2, i) && j + Math.pow(2, i) < this.heapSize; j++) {

            for (int k = 0; (k < max / ((int) Math.pow(2, i))); k++) {
                sb.append(" ");
            }
            sb.append(a[j + (int) Math.pow(2, i) -1] + " ");

        }

        sb.append("\n");

    }



    System.out.println(sb.toString());
}*/
}
