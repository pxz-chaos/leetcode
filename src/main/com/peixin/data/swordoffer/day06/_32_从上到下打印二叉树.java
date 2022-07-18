package com.peixin.data.swordoffer.day06;

import java.util.*;

/**
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *
 * @ClassName _32_从上到下打印二叉树
 * @Author pxz_chaos
 * @Date 2022/7/18 20:52
 */
public class _32_从上到下打印二叉树 {
    /**
     * 层序遍历
     *
     * @param root 给定一棵树的根节点
     * @return 根左右 数组的方式返回结果
     */
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        ArrayList<Integer> list = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            //根
            TreeNode node = queue.poll();
            list.add(node.val);

            //左
            if (node.left != null) {
                queue.add(node.left);
            }
            //右
            if (node.right != null) {
                queue.add(node.right);
            }

        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }

        return res;

    }

    /**
     * 层序遍历
     *
     * @param root 给定一棵树的根节点
     * @return 根左右 集合的方式返回结果
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();

            //注意这里的size一定要单独提出来
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                //根
                TreeNode node = queue.poll();
                level.add(node.val);

                //左
                if (node.left != null) {
                    queue.offer(node.left);
                }
                //右
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            //一层遍历完了以后，就将level添加至list集合中
            res.add(level);

        }


        return res;
    }

    /**
     * 层序遍历
     * 根右左
     *
     * @param root 给定一棵树的根节点
     * @return 根右左 集合的方式返回结果
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new LinkedList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean isLeftOrder = true;
        while (!queue.isEmpty()) {
            Deque<Integer> level = new LinkedList<Integer>();

            //注意这里的size一定要单独提出来
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                //根
                TreeNode node = queue.poll();
                if (isLeftOrder) {
                    //顺序插入
                    level.offerFirst(node.val);
                } else {
                    //倒着插入
                    level.offerLast(node.val);
                }

                //右
                if (node.right != null) {
                    queue.offer(node.right);
                }
                //左
                if (node.left != null) {
                    queue.offer(node.left);
                }
            }

            //一层遍历完了以后，就将level添加至list集合中
            res.add(new LinkedList<>(level));
            //取反
            isLeftOrder = !isLeftOrder;

        }


        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
