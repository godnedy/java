package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;


class Graph {

    public static Scanner input;
    private int noOfNodes;
    private int noOfEdges;
    public LinkedList<Integer>[] edgesList;

    public Graph(int noOfNodes, int noOfEdges) {
        this.noOfNodes = noOfNodes;
        this.noOfEdges = noOfEdges;
        System.out.println("No of nodes: " + this.noOfNodes);
        System.out.println("No of edges: " + this.noOfEdges);
    }

    protected void createListOfEdges() {
        this.edgesList = new LinkedList[this.noOfNodes];
        for (int i = 0; i < this.noOfNodes; i++) {
            this.edgesList[i] = new LinkedList<Integer>();
        }
        for (int i = 0; i < this.noOfEdges; i++) {
            int start = input.nextInt();
            int end = input.nextInt();
            this.addEdge(start, end);
        }
    }

    private void addEdge(int n1, int n2) {
        this.edgesList[n1 - 1].add(n2);
        this.edgesList[n2 - 1].add(n1);
    }

    public static int[] readFirstLine(String fileName) {
        try {
            input = new Scanner(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int[] basicData = new int[2];
        basicData[0] = input.nextInt();
        basicData[1] = input.nextInt();
        return basicData;
    }


    public void printEdges() {
        System.out.println("Printing edges:");
        for (int i=0; i < this.noOfNodes; i++) {
            for(int value: this.edgesList[i]){
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[] basicData = Graph.readFirstLine("test1.in"); // provide file name here
        DFSGraph g = new DFSGraph(basicData[0], basicData[1]);
        g.createListOfEdges();
        g.printEdges();
        //g.DFSplusR(1,-1);
        g.DFSplusPrint(1);
    }
}
