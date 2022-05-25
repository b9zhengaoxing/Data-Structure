public interface Stack<E> {

    public void push(E e);
    public E pop();
    public int getSize();
    public E peek();
    public boolean isEmpty();
}
