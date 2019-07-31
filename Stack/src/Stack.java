public interface Stack<E> { /*设计的初衷，用户无法看到Stack里面任意元素的*/
    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
