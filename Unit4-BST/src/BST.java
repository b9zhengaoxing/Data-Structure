import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class BST<E extends Comparable> {

    // private 内部结构 Node 封装，给出外部操作
    //
    private class Node {
        public E data;
        public Node left, right; //同一类型写在一起

        public Node(E e) {
            data = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    /*contructor 构造函数*/
    public BST() {
        root = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    public int getSize() {
        return size;
    }

    //递归：问题分解思想
    public void add(E e) {

        if (root == null) {
            root = new Node(e);
            size++;
        } else {
            this.add(root, e);
        }
    }

    // Overload:函数重载，
    private void add(Node node, E e) {

        //相等是重要的终止条件
        if (node.data == e)
            return;

        //递归： 先写返回条件
        if (node == null) {
            return;
        } else if (e.compareTo(node.data) < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
            return;
        } else if (e.compareTo(node.data) > 0 && node.right == null) {
            node.right = new Node(e);
            size++;
            return;
        }

        if (e.compareTo(node.data) < 0 && node.left != null) {
            this.add(node.left, e);
        }

        if (e.compareTo(node.data) > 0 && node.right != null) {
            this.add(node.right, e);
        }
    }

    public void add_fix(E e) {
        // null 也是 二叉树 递归到下一层
        root = this.add_fix(root, e);
    }

    // Overload 函数重载
    //
    private Node add_fix(Node node, E e) {

        //设置返回条件
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.data) < 0) {
            node.left = add_fix(node.left, e);
        } else if (e.compareTo(node.data) > 0) {
            node.right = add_fix(node.right, e);
        }

        //相等时候直接返回，考虑在其中了
        return node;
    }

    public boolean contain(E e) {
        return this.contain(root, e);
    }

    private boolean contain(Node node, E e) {

        if (node.data.equals(e)) {
            return true;
        }
//        if (node == null)
//            return false;

//        if (node.data.compareTo(e) < 0) {
//            this.contain(node.left, e);
//        } else if (node.data.compareTo(e) < 0) {
//            this.contain(node.right, e);
//        }
//
//        return false;

        //if else 写完整 —— 可以避免遗漏
        if (node.data.compareTo(e) < 0) {
            return this.contain(node.left, e);
        } else if (node.data.compareTo(e) < 0) {
            return this.contain(node.right, e);
        } else
            return false;
    }

    // Depth-First-Search，DFS
    public void preOrder() {
        this.preOrder(root);
    }

    //中顺遍历 —— 天然排序
    public void inOrder() {
        this.inOrder(root);
    }

    public void postOrder() {
        this.postOrder(root);
    }

    //前序遍历
    private void preOrder(Node node) {
        if (node == null)
            return;

        System.out.println(node.data);
        this.preOrder(node.left);
        this.preOrder(node.right);
    }

    private void inOrder(Node node) {
        if (node == null)
            return;

        this.inOrder(node.left);
        System.out.println(node.data);
        this.inOrder(node.right);
    }

    private void postOrder(Node node) {
        if (node == null)
            return;

        this.postOrder(node.left);
        this.postOrder(node.right);
        System.out.println(node.data);
    }

    public void preOrderNR() {
        if (root == null)
            return;

        //系统Stack 使用，import java.util.stack就可以
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        Node cur;
        //使用stack，入stack 出stack的不同实现
        while (!stack.isEmpty()) {
            cur = stack.pop();
            System.out.println(cur.data);
            if (cur.right != null) {
                stack.push(cur.right);
            }

            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    public void inOrderNR() {
        if (root == null)
            return;

        //系统Stack 使用，import java.util.stack就可以
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        Node cur = root;
        //使用stack 后进先出 —— 调整顺序
        while (!stack.isEmpty()) {

            if (cur.left != null) {
                stack.push(cur.left);
                cur = cur.left;
            } else {
                cur = stack.pop();
                System.out.println(cur.data);

                if (cur.right != null) {
                    stack.push(cur.right);
                    cur = cur.right;
                }
            }
        }
    }

    //留白
    public void postOrderNR() {

    }

    //广度优先
    public void levelOrder(){
        if(root == null)
            return;

        //一个问题 为什么Queue是接口，但是Stack 却是实现了的类？
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        Node cur;

        //使用Queue，按层次进入
        while (!queue.isEmpty()){
            cur = queue.remove();
            System.out.println(cur.data);
            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
        }
    }


    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res = this.generatePreOrderBST(root, 0, res);
        return res.toString();
    }

    private StringBuilder generatePreOrderBST(Node node, int deep, StringBuilder str) {

        if (node == null)
            return str;

        String level_str = "--";
        int level_int = 0;
        for (int i = 0; i < deep; i++) {
            str.append(level_str);
        }

        deep++; // ++

        str.append(node.data.toString());
        str.append("\n");
        str = this.generatePreOrderBST(node.left, deep, str);
        str = this.generatePreOrderBST(node.right, deep, str);

        return str;
    }

    public static void main(String[] args) {
        int[] array = {5, 3, 6, 8, 4, 1, 2};
        BST<Integer> binaryTree = new BST();  //泛型，非基础类型，要使用对象实现
        System.out.println("Empty：" + binaryTree.isEmpty());
        for (int i : array) {
            binaryTree.add_fix(i);
        }

        System.out.println("Empty：" + binaryTree.isEmpty());
        System.out.println("Size：" + binaryTree.getSize());

//        binaryTree.preOrder();
//        binaryTree.preOrderNR();
//        binaryTree.inOrder();
//        binaryTree.inOrderNR();
//        binaryTree.postOrder();
        binaryTree.levelOrder();

        System.out.println(binaryTree.toString());
    }
}