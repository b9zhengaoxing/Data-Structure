public class ArrayStack<E> implements Stack<E> {

    private DynamicArray<E> array;//声明泛型

    public ArrayStack(int capacity) {
        array = new DynamicArray<>(capacity);
    }

    public ArrayStack() {
        array = new DynamicArray<>();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Stack size:%d Peek:%s ",this.getSize(),this.peek()));
        res.append("[ ");
        if (!array.isEmpty()) {
            for (int i = 0; i < array.getSize(); i++) {
                res.append(array.get(i) + " ");
            }
        }
        res.append("] top");
        return res.toString();
    }

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>(5);
        for (int i = 0; i <= 12; i++) {
            stack.push(i);
            System.out.println(stack);
            if (i % 3 == 1){
                stack.pop();
                System.out.println(stack);
            }
        }
    }
}
