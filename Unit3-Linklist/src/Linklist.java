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

    private Node dummyHead;
    private int size;

    public Linklist() {

        dummyHead = new Node();// 忘记初始化方案了 泛型 是Data 而Node 和Linklist是结构
        size = 0;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add error,Index illegal,index : " + index);
        }

        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }

//        Node node = new Node(e);
//        node.next = pre.next;
//        pre.next = node;

        pre.next = new Node(e,pre.next);
        size++;
    }

    public void addFirst(E e) {
        this.add(0, e);
    }

    public void addLast(E e) {
        this.add(size, e);
    }

    public E remove(int index) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("delete Error,index < 0 || index > size, index = " + index);
        }

        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }

        Node delNode = null;
        if (pre.next != null){
            delNode = pre.next;
            pre.next = delNode.next;
            delNode.next = null;
        }

        size--;
        return delNode.e;
    }

    public E removeFirst() {
        return this.remove(0);
    }

    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("get Error,index < 0 || index > size, index = " + index);
        }

        if (this.isEmpty()) {
            throw new IllegalArgumentException("get Error, Linklist is empty");
        }

        Node res = dummyHead.next;
        for (int i = 0; i < index; i++) {
            res = res.next;
        }
        return res.e;
    }

    public E getFirst() {
        return this.get(0);
    }

    public E getLast() {
        return this.get(size - 1);
    }

    public E set(int index, E e) {
        if (index < 0 || index > size - 1)
            throw new IllegalArgumentException("set Error: index < 0 || index > size - 1");
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        E res = cur.e;
        cur.e = e;
        return res;
    }

    public E setFirst(E e) {
        return this.set(0, e);
    }

    public E setLast(E e) {
        return this.set(size - 1, e);
    }

    public boolean contain(E e) {
        Node cur = dummyHead;
        while (!cur.next.equals(null)) {
            cur = cur.next;
            if (cur.e.equals(e))
                return true;
        }
        return false;
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
        Node pre_node = dummyHead;
        while (pre_node.next != null) {//Linklist 没有 index 概念，此处使用,while 进行遍历
            pre_node = pre_node.next;
            res.append(pre_node.toString() + " -> ");

            // ToString 打印类的描述，toString里面调用了toString 出现
            // Exception in thread "main" java.lang.NullPointerException
        }
        res.append("NULL Tail");
        return res.toString();
    }

    public static void main(String[] args) {

        Linklist list = new Linklist<Integer>();
        for(int i = 0 ; i < 10 ; i ++){
            list.add(i,i);
//            list.addFirst(i);
        }
        System.out.println(list.toString());
        list.add(3,100);
        System.out.println(list.toString());

        list.remove(10);
        System.out.println(list.toString());
        list.removeFirst();
        System.out.println(list.toString());


        list.set(8,-99);
        System.out.println(list.toString());

        list.setLast(21);
        list.setFirst(81);
        System.out.println(list.toString());

        System.out.println(list.contain(81) + " " + list.toString());


        System.out.println(list.get(5));
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
    }

}
