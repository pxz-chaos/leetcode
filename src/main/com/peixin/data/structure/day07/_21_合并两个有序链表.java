package com.peixin.data.structure.day07;

import org.junit.Test;

/**
 * @ClassName _21_合并两个有序链表
 * @Author pxz_chaos
 * @Date 2022/7/18 16:14
 */
public class _21_合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }


        ListNode first = list1, second = list2;

        ListNode head = new ListNode(-1);
        ListNode cur = head;

        while (first != null && second != null) {

            if (first.val <= second.val) {
                //让cur的next指向first
                cur.next = first;
                //让first后移
                first = first.next;

            } else {
                cur.next = second;
                second = second.next;
            }
            //让cur后移
            cur = cur.next;
        }

        cur.next = first == null ? second : first;

        return head.next;
    }


    @Test
    public void test() {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        System.out.println(mergeTwoLists(list1, list2));
//        System.out.println(list1);


    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
