//loopQueue 是对单纯ArrayQueue的优化，通过循环的方式实现deQueue 的非删除操作
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int size;
    private int front;
    private int tail;//会浪费一个空间

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
        front = 0;
        tail = 0;//
    }

    public LoopQueue() {
        data = (E[]) new Object[10];
        size = 0;
        front = 0;
        tail = 0;
    }

    @Override
    public void enqueue(E e) {

        if (this.isFull())
            this.reSize();

        data[tail] = e; //因为tail 是空的，所以这里写 = e
        tail = (tail + 1) % data.length;

        size++;
    }

    @Override
    public E dequeue() {
        if (this.isEmpty())
            return null;

        if (size == data.length / 4) {
            this.reSize();
        }

        E tmp = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;

        return tmp;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public E getFront() {
        if (this.isEmpty())
            return null;
        else
            return data[front];
    }

    @Override
    public boolean isEmpty() {
        return (front == tail);
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Size:%d Capacity:%d \n", size, data.length));
        res.append(String.format("Front:%d tail:%d \n", front, tail));
        res.append("[ ");
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                res.append(data[(front + i) % data.length] + " ");
            }
        }
        res.append("]\n");
        return res.toString();
    }

    private boolean isFull() {
        return front == (tail + 1) % data.length;
    }

    private void reSize() {
        E[] data_tmp;
        if (this.isFull()) {
            data_tmp = (E[]) new Object[data.length * 2];
            for (int i = 0; i < size; i++) {
                data_tmp[i] = data[(front + i) % data.length];
            }
            data = data_tmp;
            front = 0;
            tail = size;
        }

        if (size == data.length / 4) {
            data_tmp = (E[]) new Object[data.length / 2];
            for (int i = 0; i < size; i++) {
                data_tmp[i] = data[(front + i) % data.length];
            }
            data = data_tmp;
            front = 0;
            tail = size;
        }
    }

    public static void main(String[] args) {

        LoopQueue<Integer> queue = new LoopQueue();

        for (int i = 0; i <= 102; i++) {
            queue.enqueue(i);
            System.out.println("enqueue " + queue);
            if (i % 3 == 1) {
                queue.dequeue();
                System.out.println("dequeue " + queue);
            }
        }
    }
}
