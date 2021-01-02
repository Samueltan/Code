package com.sample.algrithm.datastructure;

public class MyLink {
    Node head = null;

    class Node {
        Node next = null;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    public void addNode(int d) {
        Node newNode = new Node(d);
        if (head == null) {
            head = newNode;
            return;
        }

        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = newNode;
    }

    public boolean deleteNode(int index) {
        if (index < 0 || index >= length()) {
            return false;
        }

        if (index == 0) {
            head = head.next;
            return true;
        }

        int i = 1;
        Node preNode = head;
        Node curNode = preNode.next;

        while (i < index) {
            preNode = curNode;
            curNode = curNode.next;
            ++i;
        }
        preNode.next = curNode.next;
        return true;
    }

    public int length() {
        if (head == null) return 0;

        int len = 1;

        Node cur = head;
        while (cur.next != null) {
            ++len;
            cur = cur.next;
        }

        return len;
    }

    public void printList() {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            if(cur.next != null) {
                System.out.print("-> ");
            }
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyLink list = new MyLink();
        list.addNode(5);
        list.addNode(3);
        list.addNode(1);
        list.addNode(2);
        list.addNode(55);
        list.addNode(36);

        System.out.println("linkLength:" + list.length());
//        System.out.println("head.data:" + list.head.data);
        list.printList();

        int i = 3;
        System.out.println("delete node at: " + i);
        list.deleteNode(i);
        list.printList();
    }
}
