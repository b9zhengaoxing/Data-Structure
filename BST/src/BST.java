public class BST<E extends Comparable<E>> {/* 二分搜索树，需要是可以比较*/

    private class Node {
        E e;
        Node left, right;

        public Node (E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST () {
        root = null;
        size = 0;
    }

    public int size () {
        return size;
    }

    public Boolean empty () {
        return size == 0;
    }

    public void add (E e) {
        if (root == nil) {
            root = new Node(e);
            size++; //总是忘了size的
        } else {
            add(root, e);
        }
    }

    /**
     * 向二分搜索树插入新节点
     * @param node 此刻递归的root节点
     * @param e 
     */
    private void add (Node node, E e) {

        if (root.e.equals(e)) {
            return;
        }
        //对象类型不能直接比较
        else if (root.e.compareTo(e) > 0 && root.left == nil) {
            root.left = new Node(e);
            size++;
            return;
        } else if (root.e.compareTo(e) < 0 && root.right == nil) {
            root.right = new Node(e);
            size++;
            return;
        }

        if (root.e.compareTo(e) > 0) {
            this.add(root.left, e);
            return;
        } else if (root.e.compareTo(e) < 0) {
            this.add(root.right, e);
            return;
        }

    }

}
