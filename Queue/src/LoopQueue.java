public class LoopQueue<E> implements Queue<E> {
    private E data[];
    private int front, tail;
    private int size;/*多加一个变量，逻辑更清晰 */
    /*，只用front 和 tail写一下 */

    public LoopQueue (int capacity) {
        data = (E[]) new Object[capacity + 1];/*有意识浪费一个空间，让用户传进来的都能用到*/
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue () {
        this(10);
    }

    public int getCapacity () {
        return data.length - 1;/*有意识都浪费一个*/
    }

    @Override
    public boolean isEmpty () {
        return front == tail;/*为空*/
    }

    @Override
    public int getSize () {
        return size;
    }

    public int getCapactiy () {
        return data.length - 1;
    }

    @Override
    public E getFront () {
        if (isEmpty()){
            throw new IllegalArgumentException("Queue is empty");
        }
        return data[front];
    }

    @Override
    public void enqueue (E e) {
        if ((tail + 1) % data.length == front) {/*队列满,条件，让队列循环起来*/
            reSize(getCapacity() * 2);
        }

        data[tail] = e;
        tail = (tail + 1) % (data.length);
//        if (tail == getCapacity()) {
//            tail = 0;
//        } else {
//            tail++;
//        }

        size++;
    }

    @Override
    public E dequeue () {
        if (isEmpty()) {
            throw new IllegalArgumentException("Dequeue fail,queue is empty!");
        }

        E out = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;

        if (getCapacity() / 2 != 0 && (getSize() == (getCapacity() / 4))) {/*缩容不能==0*/
            reSize(getCapacity() / 2);
        }
        return out;
    }

    void reSize (int capacity) {
        E data_new[] = (E[]) new Object[capacity + 1];
//        for (int i = front; i != tail; i = (i + 1) % (getCapacity() + 1)) { /*遍历循环队列*/
//            data_new[(i - front)] = data[i];
//        }
        for (int i = 0; i < size; i++) {
            data_new[i] = data[(i + front) % data.length];
        }
        data = data_new;
        front = 0;
        tail = getSize();
    }

    @Override
    public String toString () {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d,capacity = %d \n",getCapacity(),getSize()));
        res.append("LoopQueue:");
        res.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            if (i != (tail - 1)) {
                res.append(',');
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main (String[] args) {

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            loopQueue.enqueue(i);
            System.out.println(loopQueue);

            if (i % 3 == 2) {
                loopQueue.dequeue();
                System.out.println(loopQueue);
            }
        }
    }
}