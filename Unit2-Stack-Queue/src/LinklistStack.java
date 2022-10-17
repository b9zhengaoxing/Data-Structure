public class LinklistStack<E> implements Stack<E> {
    private Linklist<E> list;

    public LinklistStack() {
        list = new Linklist<E>();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        int size = this.getSize();
        res.append("Stack: Top ");
        res.append(list);
        return res.toString();
    }

    public static void main(String[] args) {
        LinklistStack<Integer> stack = new LinklistStack<Integer>();
        for (int i = 0 ; i < 5; i ++){
            stack.push(i);
            System.out.println(stack + " peek: " + stack.peek());
        }

        for (int i = 0 ; i < 3; i ++){
            stack.pop();
            System.out.println(stack);
        }
    }
}
