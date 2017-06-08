package com.company;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Stack;

class Graph {

    public static Scanner input;
    private int noOfNodes;
    private int noOfEdges;
    private LinkedList[] edgesList;

    public Graph(int noOfNodes, int noOfEdges) {
        this.noOfNodes = noOfNodes;
        this.noOfEdges = noOfEdges;
        System.out.println("No of nodes: " + this.noOfNodes);
        System.out.println("No of edges: " + this.noOfEdges);
    }

    private void addEdge(int n1, int n2) {
        LinkedListNode temp = this.edgesList[n1 - 1].addLast(null);
        LinkedListNode temp2 = this.edgesList[n2 - 1].addLast(null);
        Edge e1 = new Edge(n2, temp2);
        Edge e2 = new Edge(n1, temp);
        temp.setValue(e1);
        temp2.setValue(e2);
    }

    private Edge removeFirstEdge(int node) {
        Edge temp = (Edge) this.edgesList[node - 1].removeFirst();
        this.edgesList[temp.endNode - 1].removeNode(temp.correspondingNode);
        return temp;
    }

    private void createListOfEdges() {
        this.edgesList = new LinkedList[this.noOfNodes];
        for (int i = 0; i < this.noOfNodes; i++) {
            this.edgesList[i] = new LinkedList();
        }
        for (int i = 0; i < this.noOfEdges; i++) {
            int start = input.nextInt();
            int end = input.nextInt();
            this.addEdge(start, end);
        }
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
        for (LinkedList l : this.edgesList) {
            l.print();
        }

    }

    // method prints Eulerian Cycle from a graph assuming a graph is an Euler graph
    public void findEulerianCycle(int v) {
        LinkedList eulerianCycle = new LinkedList();
        Stack<Integer> lifo = new Stack<Integer>();
        int start = v;
        eulerianCycle.addLast(v);
        boolean b = true;
        Edge w = null;
        do {
            while (!edgesList[v - 1].isEmpty()) {
                w = this.removeFirstEdge(v); // remove first edge of v
                lifo.add(v);   // add new node to stack
                v = w.endNode;
            }
            if (!lifo.isEmpty()) {
                v = lifo.pop();
                eulerianCycle.addLast(v);
            }
        } while (!lifo.isEmpty());

        System.out.println("Eulerian Cycle:");
        while (!eulerianCycle.isEmpty()) {
            System.out.print(eulerianCycle.removeFirst() + " ");
        }
    }

    public void testGraphAddingAndRemovingEdges(){
        this.removeFirstEdge(1);
        this.printEdges();
        this.addEdge(1, 2);
        this.printEdges();
        this.removeFirstEdge(4);
        this.printEdges();
        this.removeFirstEdge(4);
        this.printEdges();
        this.addEdge(2, 4);
        this.addEdge(3, 4);
        this.printEdges();
    }

  public static void main(String[] args) {

        int[] basicData = Graph.readFirstLine("t2.in"); // provide file name here
        Graph g = new Graph(basicData[0], basicData[1]);
        g.createListOfEdges();
        g.printEdges();
        g.findEulerianCycle(1);
    }
}
