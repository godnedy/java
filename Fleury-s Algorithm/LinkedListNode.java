package com.company;

/**
 * Created by Student3 on 2017-03-28.
 */
public class LinkedListNode {

    public LinkedListNode next;
    public LinkedListNode previous;
    public Object value;

    public LinkedListNode(Object value){
        this.value = value;
        this.next = null;
        this.previous = null;
    }

    // needed only for Zadanie2
    public void setValue(Object value) {
        this.value = value;
    }
}
