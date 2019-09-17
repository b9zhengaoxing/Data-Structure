public class LinkedList<E> {

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

    private Node dummyHead;//虚拟头节点
    private int size; /*private,只能内部修改*/

    public LinkedList () {
        dummyHead = new Node(null, null);
        size = 0;
    }

    /**
     * 获取链表中元素个数
     *
     * @return
     */
    public int getSize () {
        return size;
    }

    /**
     * 链表是否为空
     *
     * @return
     */
    public boolean isEmpty () {
        return size == 0;
    }

    /**
     * 在链表头部增加元素
     *
     * @param e
     */
    public void addFirst (E e) {

        this.add(0, e);
    }


    /**
     * 在链表的index（0-based）位置添加新元素e
     * 并非链表常规操作，练习用
     *
     * @param index
     * @param e
     */
    public void add (int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        /*链表的循环，遍历index前一个位置*/
        Node prev = this.dummyHead;
        for (int i = 0; i < index/*找到之前的*/; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;

    }

    /**
     * 向链表尾部增加一个元素
     *
     * @param e
     */
    public void addLast (E e) {/*这里size 比index上限大一所以可以添加*/
        add(size - 1, e);
    }

    /**
     * 获得链表第index（0 - Based）个位置第元素
     *
     * @param index 不常用用来做练习
     * @return
     */
    public E get (int index) {
        if (index < 0 || index >= size/**/) {
            throw new IllegalArgumentException("Get Failed. Illegal index.");
        }

        Node cur = dummyHead.next/*从第一个元素开始遍历*/;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * 获取链表第一个元素
     *
     * @return
     */
    public E getFirst () {
        return get(0);
    }

    /**
     * 获取链表最后一个元素
     *
     * @return
     */
    public E getLast () {
        return get(size - 1);
    }

    /**
     * 修改链表index位置的元素，（0——base)个位置的元素为e,非常规操作，练习用
     * @param index
     * @param e
     */
    public void set(int index,E e){

        if (index < 0 || index >= size/**/) {
            throw new IllegalArgumentException("Set Failed. Illegal index.");
        }

        /*反馈：我要遍历到index，是一个终点*/
//        Node cur = dummyHead;
//        for (int i = 0; i <= index; i++) {
//            cur = cur.next;
//            if (i == index) cur.e = e;
//        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 查找链表中是否存在元素 e
     * @return
     */
    public boolean contains (E e) {

        /*反馈：要对每一个状态进行遍历*/
        Node cur = dummyHead.next;

//        for (int i = 0; i < size - 1 ; i++) {
//            if (cur.e.equals(e)) {
//                return true;
//            }
//            cur = cur.next;
//        }

        //写法2
        while (cur.next != null){

            if (cur.equals(e)){
                return true;
            }
            cur = cur.next;
        }

        return false;
    }

    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();

        //写法2
//        Node cur = dummyHead.next;
//        while (cur.next != null){
//
//            res.append(cur + "->");
//            cur = cur.next;
//        }

        //  for循环顺序， for（1，2，4）{3}
        for (Node cur = dummyHead.next ; cur.next != null ; cur = cur.next) {
            res.append(cur + "->");
        }

        res.append("NULL");

        return res.toString();
    }
}
