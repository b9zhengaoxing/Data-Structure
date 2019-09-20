public class LinkedListQueue<E> implements Queue<E> {

    private class Node /*使用内部类，用户没有必要看到链表节点的定义*/ {
        //设定为Public，因为在内部类中，可以随意访问
        public E e;
        public Node next;

        public Node (E e, Node next) {
            this.e = e;/*变量名重名，所以用要this.代表节点的e*/
            this.next = next;
        }

        public Node (E e) {
            this(e, null);
        }

        public Node () {
            this(null, null);
        }

        @Override
        public String toString () {
            return e.toString();
        }
    }

    private Node head, tail;
    private int size;

    public LinkedListQueue () {
        head = null;
        tail = null;
        size = 0;

    }

    @Override
    public int getSize () {
        return size;
    }

    @Override
    public boolean isEmpty () {
        return (size == 0);
    }

    @Override
    public void enqueue (E e) {
        //单链表队尾无法删除，所以这里从tail,入队，当做队尾
        Node inNode = new Node(e);
        if (tail == null) {
            tail = inNode;
            head = tail;
        } else {
            tail.next = inNode;
            tail = inNode;
        }

        size++; /*总是忘记维护size！*/
    }

    @Override
    public E dequeue () {
        if (head == null) {
            throw new IllegalArgumentException("dequeue failed,queue is empty!");
        }

        Node res = head;
        head = head.next;
        res.next = null;

        if (head == null) {/*当head为空时候，tail 也该为空！*/
            tail = null;
        }

        size--;

        return res.e;
    }

    @Override
    public E getFront () {
        if (head == null) {
            throw new IllegalArgumentException("getFront failed,queue is empty!");
        }

        return head.e;
    }

    @Override
    public String toString () {
        StringBuilder res = new StringBuilder("Front: head:");
        Node cur_Node = head;
        while (cur_Node != null) {
            res.append(cur_Node.e + "->");
            cur_Node = cur_Node.next;
        }
        res.append("NULL tail");
        return res.toString();
    }

    public static void main (String[] args) {

        LinkedListQueue<Integer> LinkedListQueue = new LinkedListQueue();
        for (int i = 0; i < 10; i++) {
            LinkedListQueue.enqueue(i);
            System.out.println(LinkedListQueue);

            if (i % 3 == 2) {
                LinkedListQueue.dequeue();
                System.out.println(LinkedListQueue);
            }
        }
    }
}