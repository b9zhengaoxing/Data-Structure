public class LinklistQueue<E> implements Queue<E> {

    // private： 类内部可以访问，外部类默认可以随意访问内部类的private，这个有点奇怪，没事，语法问题不纠结
    // protected: 继承者们可以访问
    private class Node {//非静态内部类，会自动继承外部类的<E> 泛型声明，如果这里再重新申请一个的话，访问时候会报错
        public E e;
        public Node next;

        public Node() {
            //this.Node(null,null); 报错：符号: 方法 Node(<nulltype>,<nulltype>)
            this(null, null);
        }

        public Node(E e) {
            this(e, null);
        }

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head,tail;
    private int size;

    public LinklistQueue(){
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void enqueue(E e) {
        if (head == null){
            head =  new Node(e);
            tail = head;
        }else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size ++;
    }

    @Override
    public E dequeue() {
        Node delNode;
        if (head != null){
            delNode = head;
            head = head.next;
            delNode.next = null;//释放空指针
            size--;
            return delNode.e;
        }else {
            return null;
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public E getFront() {
        if (head != null){
            return head.e;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue" + " :Front:");
        Node node = head;
        while(node != null){
            res.append(node.e + " ->");
            node = node.next;
        }
        res.append("tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LinklistQueue<Integer> queue = new LinklistQueue<Integer>();
        for (int i = 0; i < 5 ;i++){
            queue.enqueue(i);
            System.out.println(queue + "size:" + queue.getSize() + queue.isEmpty());
        }

        for (int i = 0; i < 3 ;i++){
            queue.dequeue();
            System.out.println(queue + "size:" + queue.getSize() + queue.isEmpty());
        }
    }
}
