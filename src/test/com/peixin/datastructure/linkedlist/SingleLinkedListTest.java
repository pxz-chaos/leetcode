package com.peixin.datastructure.linkedlist;

import junit.framework.TestCase;
import org.junit.Test;

public class SingleLinkedListTest extends TestCase {
    @Test
    public void testAdd() {
        SingleLinkedList list = new SingleLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

//        list.clear();
//        System.out.println(list.get(2));

        System.out.println(list.getFirst());
        System.out.println(list);
    }
}