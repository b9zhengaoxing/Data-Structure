
public class SolutionInner {

    private interface Stack<E> {

        public void push(E e);
        public E pop();
        public int getSize();
        public E peek();
        public boolean isEmpty();
    }
    private class DynamicArray<E> {/*泛型类*/

        private E[] data;
        private int size;

        //    构造函数，是一种特殊的方法。 主要用来在创建对象时初始化对象， 即为对象成员变量赋初始值，总与new运算符一起使用在创建对象的语句中。 特别的一个类可以有多个构造函数，可根据其参数个数的不同或参数类型的不同来区分它们即构造函数的重载。
        //    作 用： 为对象成员变量赋初始值
        //    外文名： constructor
        //    语 句： new运算符一起使用
        public DynamicArray(int capacity) {
            data = (E[]) new Object[capacity];
            size = 0;
        }

        //constructor overload
        public DynamicArray() {
            this(10);
        }

        //获取当前大小
        public int getSize() {
            return size;
        }

        //获取最大空间
        public int getCapacity() {
            return data.length;
        }

        //是否为空
        public boolean isEmpty() {
            return size == 0;
        }

        //队尾插入 直接插入
        public void addLast(E aData) {
            this.add(size, aData);
        }

        //复用
        public void addFirst(E aData) {
            this.add(0, aData);
        }

        //队中插入 依次向前
        public void add(int index, E aData) {
            if (size == data.length)
                throw new IllegalArgumentException("Add failed! The array is full.");

            if (index > size && index < 0)
                throw new IllegalArgumentException("index > size && index < 0");

            for (int i = size - 1; i >= index; i--)
                data[i + 1] = data[i];

            data[index] = aData;
            size++;

            //伸缩
            if (size == data.length)
                this.resizing(2 * size);
        }

        protected void resizing(int capacity) {
            if (capacity <= 0)
                throw new IllegalArgumentException("Resizing Failed ! capacity <= 0 ");

            E[] newData = (E[]) new Object[capacity];
            for (int i = 0; i < size; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }

        public E remove(int index) {
            if (index > size - 1 || index < 0)
                throw new IllegalArgumentException(String.format("index > size - 1 || index < 0 index:%d", index));

            E res = data[index];
            for (int i = index; i < size - 1; i++) {
                data[i] = data[i + 1];
            }
            data[size - 1] = null;
            size--;
            if (size == data.length/4)
                this.resizing(data.length/2);
            return res;
        }

        public E removeFirst() {
            return remove(0);
        }

        public E removeLast() {
            return remove(size - 1);
        }

        public E getFirst() {
            return this.get(0);
        }

        public E getLast() {
            return this.get(size - 1);
        }

        //set/get + private 存取访问控制
        public E get(int index) {
            //访问控制！非法监测，无法访问 没有的元素
            if (index < 0 || index >= size)
                throw new IllegalArgumentException("Get failed,index<0 || index>=size");

            return data[index];
        }

        public int getIndex(E e) {//O(n)
            //访问控制！非法监测，无法访问 没有的元素
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    if (data[i].equals(e)) {
                        return i;
                    }
                }
            }
            return -1;
        }

        public void set(int index, E aData) {
            if (index < 0 || index >= size)
                throw new IllegalArgumentException(String.format("set failed, index < 0 || index >= size"));

            data[index] = aData;
        }

        @Override
        public String toString() {
            StringBuilder res = new StringBuilder();
            res.append(String.format("Size:%d Capacity:%d\n", size, data.length));
            res.append("[ ");
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    res.append(data[i] + " ");
                }
            }
            res.append("]\n");
            return res.toString();
        }
    }
    private class ArrayStack<E> implements Stack<E> {

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
    }

    public boolean isValid(String s) {
        ArrayStack<Character> stack = new ArrayStack<>();
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            if (character == '(' || character == '[' || character == '{') {
                stack.push(character);
            } else {
                if (stack.isEmpty())
                    return false;
                char top = stack.pop();
                if (character == ')' && top != '(') {
                    return false;
                } else if (character == ']' && top != '[') {
                    return false;
                } else if (character == '}' && top != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty() == true;
    }

    public static void main(String[] args) {

        SolutionInner solution = new SolutionInner();

        String test_string1 = "(])";
        String test_string2 = "()[]{}";
        String test_string3 = "(]";

        System.out.println(test_string1 + solution.isValid(test_string1));
        System.out.println(test_string2 + solution.isValid(test_string2));
        System.out.println(test_string3 + solution.isValid(test_string3));
    }
}
