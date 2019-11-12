public class BST<E extends Comparable<E>> {/*可以比较*/

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

    public int size(){
        return size;
    }

    public Boolean empty(){
        return size == 0;
    }
}
