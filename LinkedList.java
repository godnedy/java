package com.company;

/**
 * Created by Student3 on 2017-03-28.
 */
public class LinkedList {

    public LinkedListNode firstNode;

    // assuming that firsNode.prev does not point on last element,
    // adding this attribute makes addLast faster (no need to go from firsNode until next is equal to null)
    private LinkedListNode lastNode;


    public LinkedList() {
        this.firstNode = null;
        this.lastNode = null;

    }

    public boolean isEmpty() {
        return this.firstNode == null;
    }

    public LinkedListNode addLast(Object value) {
        if (this.isEmpty()) {
            this.firstNode = new LinkedListNode(value);
            this.lastNode = this.firstNode;
        } else {
            LinkedListNode temp = new LinkedListNode(value);
            this.lastNode.next = temp;
            temp.previous = this.lastNode;
            this.lastNode = temp;
        }
        return this.lastNode;
    }

    public Object removeFirst() {
        if (this.isEmpty()) {
            return null;
        }
        Object valueOfFirst = this.firstNode.value;
        if (this.firstNode.equals(this.lastNode)) {
            this.firstNode = null;
            this.lastNode = null;
        } else {
            this.firstNode.next.previous = null;
            this.firstNode = this.firstNode.next;
        }
        return valueOfFirst;
    }

    public void removeNode(LinkedListNode node) {

        if (node.equals(this.firstNode)) {
            this.removeFirst();
        } else {
            if (node.equals(this.lastNode)) {
                this.lastNode = this.lastNode.previous;
                this.lastNode.next = null;
            } else {
                node.next.previous = node.previous;
                node.previous.next = node.next;
            }

        }

    }


    public void print() {
        LinkedListNode node = this.firstNode;
        while (node != null) {
            Edge value = (Edge)node.value;
            System.out.print(value.endNode+ " ");
            node = node.next;
        }
        System.out.println();
    }

    /*
    public void test() {

        LinkedList l = new LinkedList();
        l.addLast(1);
        LinkedListNode a = l.addLast(2);
        l.addLast(3);
        LinkedListNode b =l.addLast(4);
        l.addLast(5);

        LinkedListNode c =l.addLast(6);
        l.addLast(7);

        l.print();
        l.removeFirst();
        l.print();
        l.removeNode(a);
        l.print();
        l.removeNode(b);
        l.print();
        l.removeNode(c);
        l.print();
        l.removeFirst();
        l.print();
        l.removeFirst();
        l.print();
        l.removeFirst();
        l.print();
        l.removeFirst();
        l.print();

        l.addLast(10);
        l.print();
        l.removeFirst();
        l.print();
    }
    */
}