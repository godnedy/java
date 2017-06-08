package com.company;
import java.util.Stack;
/**
 * Created by Student3 on 2017-03-29.
 */
public class DFSGraph extends Graph {

    private int[] DFSnumbers;
    private int[] low;
    private int[] parent;
    private boolean[] visited;
    private int dfsnum;
    private Stack<Integer> lifo;
    private Stack<Integer> lifoLow;


    public DFSGraph(int noOfNodes, int noOfEdges) {
        super(noOfNodes, noOfEdges);
        this.DFSnumbers = new int[noOfNodes];
        this.low = new int[noOfNodes];
        this.parent = new int[noOfNodes];
        this.visited = new boolean[noOfNodes];
        this.dfsnum = 0;
        this.lifoLow = new Stack<Integer>();
        this.lifo = new Stack<Integer>();
    }

   public void DFSplusR(int node, int parent){
        lifo.push(node);
       int x=1;
        while(!this.lifo.isEmpty()){
            int nodeLow = node;
            lifoLow.push(node);
            this.dfsnum ++;
            this.DFSnumbers[node - 1] = this.dfsnum;
            this.visited[node -1] = true;
            this.low[node - 1] = this.dfsnum;

            for (int neighbour: super.edgesList[node - 1]){
                if(this.visited[neighbour - 1] == true){
                    if (this.DFSnumbers[neighbour - 1] < this.low[node - 1] && neighbour != parent){
                        this.low[node - 1] = this.DFSnumbers[neighbour - 1];
                    }
                }
                else {
                    this.DFSplusR(neighbour, node);
                    if (this.low[neighbour - 1] < this.low[node - 1]){
                        this.low[node - 1] = this.low[neighbour -1];
                    }
                    if (this.low[node -1] == this.DFSnumbers[node - 1]){
                        System.out.println("Critical node: " + node);
                    }

                }
            }
            if(!lifo.isEmpty()) {
                node = this.lifo.pop();
                System.out.println("DFS number of node " + node + " is equal to " + this.DFSnumbers[node-1]);
                System.out.println("Low of node " + node + " is equal to " + this.low[node-1]);
            }
        }
    }

    public void DFSplusplus(int node, int parent) {
        int neighbourLow = 0;
        boolean test;
        this.dfsnum++;
        this.DFSnumbers[node - 1] = this.dfsnum;
        this.low[node - 1] = this.dfsnum;
        test = false;
        System.out.println("node equals" + node);
        for (int neighbour : super.edgesList[node - 1]) {
            System.out.println("Neighbour equals" + neighbour);
            if (neighbour != parent) {
                if (!this.visited[neighbour - 1]) { // if neighbour not visited
                    this.DFSplusplus(neighbour, node);
                    if (this.low[neighbour - 1] < this.low[node - 1]) {
                        this.low[node] = this.low[neighbour - 1];
                    }
                    if (this.low[node - 1] <= this.low[neighbour - 1]) { // testing if node is a critical node
                        test = true;
                    }
                } else if (this.low[node - 1] >= this.DFSnumbers[neighbour - 1]) { // if neighbour visited and its dfs number smaller than current low for this node
                    this.low[node - 1] = this.DFSnumbers[neighbour - 1];
                }
            }
        }
        if (test) {
            this.lifo.add(node);
        }
    }

    public void DFSplusPrint(int node){
            this.DFSplusplus(node, -1);

            while(!this.lifo.isEmpty()){
                System.out.println("Critical point:" + this.lifo.pop());
            }
    }

    public void DFSplus(int node) {
        lifo = new Stack();
        lifoLow = new Stack();
        lifo.push(node);
        while (!lifo.isEmpty()) {
            lifoLow.push(node);
            this.dfsnum++;
            this.DFSnumbers[node - 1] = this.dfsnum;
            this.visited[node - 1] = true;
            this.low[node - 1] = this.dfsnum;

            for (int neighbour : super.edgesList[node - 1]) {
                if (this.visited[neighbour - 1] == true) {
                   // if (this.DFSnumbers[neighbour - 1] < this.low[node - 1] && neighbour != this.parent[node - 1]) {
                    //    this.low[node - 1] = this.DFSnumbers[neighbour - 1];
                   // }
                } else {
                    lifo.push(neighbour);
                    lifoLow.push(neighbour);
                    System.out.println(neighbour + "goes on stack");
                }
            }

            int parent = node;
            node = this.lifo.pop();
            System.out.println(node + "comes from stack");
            if (this.parent[node - 1] == -1) {
                this.parent[node - 1] = parent;
            }
        }
        while (!this.lifoLow.isEmpty()) {
            node = this.lifoLow.pop();
            System.out.println(node + "comes from LIFOstack");
            for (int neighbour : super.edgesList[node - 1]) {
                if (this.DFSnumbers[neighbour - 1] < this.low[node - 1] && neighbour != this.parent[node - 1]) {
                    this.low[node - 1] = this.DFSnumbers[neighbour - 1];
                }
                System.out.println("Low["+node+"]" + this.low[node-1]);
            }
            if (this.low[node - 1] == this.DFSnumbers[node - 1]) {
                System.out.println("Critical node, " + node);
            }
        }

    }
}