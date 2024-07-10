package com.demo.treenode;

import java.util.LinkedList;

/**
 * 116,填充每个节点
 *
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 * 示例 1：
 * 输入：root = [1,2,3,4,5,6,7]
 * 输出：[1,#,2,3,#,4,5,6,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由 next 指针连接，'#' 标志着每一层的结束。
 *
 * 示例 2:
 * 输入：root = []
 * 输出：[]
 * 提示：
 *
 * 树中节点的数量在 [0, 2^12 - 1] 范围内
 * -1000 <= node.val <= 1000
 * 进阶：
 *
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 * Related Topics
 * 树
 * 深度优先搜索
 * 广度优先搜索
 * 链表
 * 二叉树
 */
public class Connect {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        LinkedList<Node> list = new LinkedList<>();
        list.push(root);

        while (!list.isEmpty()) {
            int size = list.size();

            while (size > 0) {
                size --;

                Node node = list.pollLast();
                if (size == 0) {
                    node.next = null;
                } else {
                    node.next = list.peekLast();
                }

                if (node.left != null) {
                    list.push(node.left);
                }
                if (node.right != null) {
                    list.push(node.right);
                }
            }
        }

        return root;
    }

    public static void main(String[] args) {
        Node node = new Node(1,
                new Node(2,
                        new Node(3,
                                new Node(5),
                                new Node(6)),
                        new Node(4,
                                new Node(7),
                                new Node(8))
                ),
                new Node(12,
                        new Node(13,
                                new Node(15),
                                new Node(16)),
                        new Node(14,
                                new Node(17),
                                new Node(18))
                ));

        Connect connect = new Connect();
        connect.connect(node);
    }

}
