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

    private Node head;
    private int size; /*private,只能内部修改*/

    public LinkedList () {
        head = null;
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
     * @param e
     */
    public void addFirst(E e){

//        if (e == null){ /*因为这是数据，所以为空也没关系*/
//            throw new IllegalArgumentException("addFirst error，e is Empty!");
//        }

//        Node node = new Node(e,this.head);
//        this.head = node;
        head = new Node(e, head);
        size ++;
    }


    /**
     * 在链表的index（0-based）位置添加新元素e
     * 并非链表常规操作，练习用
     * @param index
     * @param e
     */
    public void add(int index,E e){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        if (index == 0){
            this.addFirst(e); /*对链表头节点的特殊处理*/
        }else {
            /*链表的循环*/
            Node prev = this.head;
            for (int i = 0; i < index - 1/*找到之前的*/; i++) {
                prev = prev.next;
            }
//        Node node = new Node(e);
//        node.next = prev.next;
//        prev.next = node;

            prev.next = new Node(e,prev.next);
            size ++;
        }
    }

    /**
     * 向链表尾部增加一个元素
     * @param e
     */
    public void addLast(E e){/*这里size 比index上限大一所以可以添加*/
        add(size - 1, e);
    }
}
