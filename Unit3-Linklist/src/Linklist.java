public class Linklist<E> {

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

    private Node head;
    private int size;

    public Linklist() {

        head = null;// 忘记初始化方案了 泛型 是Data 而Node 和Linklist是结构
        size = 0;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add error,Index illegal,index : " + index);
        }

        Node node = new Node(e);

        if (index == 0) {
            node.next = head;
            head = node;
            size++;
        } else {
            Node pre = head;
            for (int i = 0; i < index - 1; i++) {
                pre = pre.next;
            }

            node.next = pre.next;
            pre.next = node;
            size++;
        }
    }

    public void addFirst(E e) {
        this.add(0, e);
    }

    public E delete(int index) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("delete Error,index < 0 || index > size, index = " + index);
        }

        if (this.isEmpty()) {
            throw new IllegalArgumentException("delete Error, Linklist is empty");
        }

        Node res = null;
        if (index == 0) {
            res = head;
            head = head.next;
        } else {
            Node pre = head;
            for (int i = 0; i < index - 1; i++) {
                pre = pre.next;
            }
            res = pre.next;
            pre.next = res.next;
        }

        size--;
        return res.e;
    }

    public E deleteFirst() {
        return this.delete(0);
    }

    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Find Error,index < 0 || index > size, index = " + index);
        }

        if (this.isEmpty()) {
            throw new IllegalArgumentException("Find Error, Linklist is empty");
        }

        Node res = head;
        for (int i = 0; i < index; i++) {
            res = res.next;
        }
        return res.e;
    }

    public Boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Linklist Size:" + size + " Head:");
        Node pre_node = head;
        for (int i = 0; i < size; i++) {
            res.append(pre_node.toString() + " -> ");
            pre_node = pre_node.next;

            // ToString 打印类的描述，toString里面调用了toString 出现
            // Exception in thread "main" java.lang.NullPointerException
        }
        res.append("NULL Tail");
        return res.toString();
    }
}
