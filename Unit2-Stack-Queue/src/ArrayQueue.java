public class ArrayQueue<E> implements Queue<E>{

    private DynamicArray<E> array;

    public ArrayQueue(int capacity){
        array = new DynamicArray<>(capacity);
    }

    public ArrayQueue(){
        array = new DynamicArray<>();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue size:%d ", this.getSize()));
        res.append("Front [ ");
        if (!array.isEmpty()) {
            for (int i = 0; i < array.getSize(); i++) {
                res.append(array.get(i) + " ");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue();

        for (int i = 0; i <= 12; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 1){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
