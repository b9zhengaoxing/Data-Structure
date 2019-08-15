public class LinkedList<E> {

    private class Node /*使用内部类，用户没有必要看到链表节点的定义*/ {
        //设定为Public，因为在内部类中，可以随意访问
        public E e;
        public Node next;

        public Node(E e,Node next){
            this.e = e;/*变量名重名，所以用要this.代表节点的e*/
            this.next = next;
        }

        public Node(E e){
            this(e,null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }
}
