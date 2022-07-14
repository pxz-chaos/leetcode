package com.peixin.data.offer.day01;


import java.util.Stack;

//辅助栈
public class _30_包含min函数的栈 {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;


    public _30_包含min函数的栈() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
        minStack.push(Integer.MAX_VALUE)  ;
    }

    public void push(int x) {
        stack.push(x);
        minStack.push(Math.min(minStack.peek(), x));

    }

    public void pop() {
        stack.pop();
        minStack.pop();

    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }

    public static void main(String[] args) {

        _30_包含min函数的栈 minStack = new _30_包含min函数的栈();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.push(-7);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());

    }
}
