public class BST<E extends Comparable> {

    // private 内部结构 Node 封装，给出外部操作
    //
    private class Node {
        public E data;
        public Node leftLeaf;
        public Node rightLeaf;

        public Node(E e) {
            data = e;
            leftLeaf = null;
            rightLeaf = null;
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
        return true ? false : size == 0;
    }

    public int getSize() {
        return size;
    }

    //递归：问题分解思想
    public void add(E e) {

        if (this.isEmpty()) {
            root = new Node(e);
        } else {
            this.add(root, e);
        }
    }

    // Overload:函数重载，
    private void add(Node node, E e) {

        //递归： 返回条件
        if (node == null) {
            return;
        } else if (e.compareTo(node.data) < 0 && node.leftLeaf == null) {
            node.leftLeaf = new Node(e);
            return;
        } else if (e.compareTo(node.data) > 0 && node.rightLeaf == null) {
            node.rightLeaf = new Node(e);
            return;
        }

        if (e.compareTo(node.data) < 0 && node.leftLeaf != null) {
            this.add(node.leftLeaf, e);
        }

        if (e.compareTo(node.data) > 0 && node.rightLeaf != null) {
            this.add(node.rightLeaf, e);
        }
    }

    public void add_fix(E e) {
        // null 也是 二叉树
        root = this.add_fix(root, e);
    }

    // Overload 函数重载
    //
    private Node add_fix(Node node, E e) {

        //设置返回条件
        if (node == null) {
            return new Node(e);
        } else if (e.compareTo(node.data) < 0 ) {
            return add_fix(node.leftLeaf,e);
        } else if (e.compareTo(node.data) > 0 ) {
            return add_fix(node.rightLeaf,e);
        }

        return null;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}