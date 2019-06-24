package com.danasoft.singlylinkedlists;

import org.jetbrains.annotations.Contract;

class SinglyLinkedList {
    private Node head;

    SinglyLinkedList() {
        this.head = null;
    }

    // SLL methods go here. As a starter, we will show you how to add a node to the
    // list.
    void add(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node runner = head;
            while (runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
    }

    void remove() {
        Node node = head;
        Node last = null;
        while (node.next != null) {
            last = node;
            node = node.next;
        }
        if (last == null)
            head = null;
        else
            last.next = null;
    }

    int removeAt(int index) {
        int s = size();
        if (index > s) {
            System.out.printf("You entered %d, but there are only %d nodes in th list!", index, s);
        }
        int i = 0;
        Node node = head;
        Node prev = head;
        while(i++ < index) {
            prev = node;
            node = node.next;
        }
        prev.next = node.next;
        return node.value;
    }

    Node find(int value) {
        Node node = head;
        while (node.next != null) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }

    void printValues() {
        Node n = head;
        while (n != null) {
            System.out.print("\n\t" + n.value);
            n = n.next;
        }
        System.out.print("\n");
    }

    @Contract(pure = true)
    private int size() {
        int count = 0;
        Node node = head;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }
}