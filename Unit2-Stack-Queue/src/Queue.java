public interface Queue <E>{

    public void enqueue(E e);
    public E dequeue();
    public int getSize();
    public E getFront();
    public boolean isEmpty();
}
