package com.peixin.data.offer.day01;

import java.util.Stack;


public class _9_用两个栈实现队列 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public _9_用两个栈实现队列() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }


    /**
     * 注意：在执行删除之前一定要判断栈2是不是空的，空的返回-1，不是空的判断栈1是否有新添加的元素，有的话，全部挪到栈2中
     */
    public int deleteHead() {
        if (!stack2.isEmpty()) {
            //栈2有元素
            return stack2.pop();
        } else {//栈2已经空了
            //看栈1有没有新添加进来的元素

            while (!stack1.isEmpty()) {
                //有新添加的元素
                //所有元素往栈2里面搬
                stack2.push(stack1.pop());
            }
            return stack2.isEmpty() ? -1 : stack2.pop();
        }
    }

}
