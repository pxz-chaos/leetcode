package com.peixin.datastructure.linkedlist;



/**
 * @author pxz_chaos
 */
public class SingleLinkedList {


    private Node first;
    private int size;

    public void add(int item) {
        add(first, item);
    }

    public int getSize() {
        return size;
    }

    public Node getFirst() {

        return first;
    }

    public void clear() {
        first = null;
        size = 0;
    }

    public int get(int index) {
        if (index + 1 > size || index < 0) {
            throw new IndexOutOfBoundsException("索引不正常");
        }
        if (size == 0) {
            return 0;
        }

        Node cur = first;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void add(Node node, int item) {
        Node cur = node;

        //添加第一个节点
        if (cur == null) {
            first = new Node(item, null);
            size++;
            return;
        }

        //添加的不为第一个节点
        while (cur.next != null) {
            cur = cur.next;
        }

        //退出循环后，cur.next为null

//        cur.next=new Node(item);
//        cur=cur.next;
        //一步到位
        cur.next = new Node(item, cur.next);

        size++;

    }

    private class Node {
        int val;
        Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "SingleLinkedList{" +
                "first=" + first +
                ", size=" + size +
                '}';
    }
}
