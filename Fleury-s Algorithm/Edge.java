package com.company;

/**
 * Created by Student3 on 2017-03-28.
 */
public class Edge {

    public LinkedListNode correspondingNode;
    public int endNode;


    public Edge(int endNode, LinkedListNode correspondingNode) {
        this.endNode = endNode;
        this.correspondingNode = correspondingNode;

    }
}
