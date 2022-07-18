package com.peixin.data.structure.day07;

import org.junit.Test;

/**
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @ClassName _141_环形链表
 * @Author pxz_chaos
 * @Date 2022/7/18 15:25
 */
public class _141_环形链表 {
    /**
     * 快慢指针
     *
     * @param head 头节点
     * @return 是否有环
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head, fast = head;

        //只需要判断快指针的情况即可
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    @Test
    public void test() {
        ListNode head = new ListNode(0),
                node1 = new ListNode(1),
                node2 = new ListNode(2),
                node3 = new ListNode(3),
                node4 = new ListNode(4);

        head.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node2;


        System.out.println(hasCycle(head));
        //hasCycle(head);
//        System.out.println(head);


    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
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
