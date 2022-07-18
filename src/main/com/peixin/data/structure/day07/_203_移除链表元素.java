package com.peixin.data.structure.day07;

/**
 * @ClassName _203_移除链表元素
 * @Author pxz_chaos
 * @Date 2022/7/18 17:20
 */
public class _203_移除链表元素 {
    public ListNode removeElements(ListNode head, int val) {

        //搞一个虚拟头节点，方便后面删除val为头节点val
        ListNode newHead = new ListNode(0);
        newHead.next = head;

        //让当前节点指向虚拟头节点
        ListNode cur = newHead;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return newHead.next;

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
    }
}
