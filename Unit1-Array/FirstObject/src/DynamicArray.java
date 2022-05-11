public class DynamicArray<E> {/*泛型类*/

    private final E[] data;
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
    }

    public E remove(int index) {
        if (index > size - 1 || index < 0)
            throw new IllegalArgumentException(String.format("index > size - 1 || index < 0 index:%d", index));

        E res = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size-1] = null;
        size--;
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

    public static void main(String[] args) {

        //Dynamic 封装验证
//        DynamicArray<Integer> aArr = new DynamicArray<>(30);
//
//        System.out.println(aArr.getCapacity());
//        System.out.println(aArr.isEmpty());
//
//        for (int i = 0; i < 20; i++)
//            aArr.addFirst(i);
//
//        System.out.println(aArr);
//
//        //Set/Get O(1)
//        aArr.set(5,1000);
//        System.out.println(aArr.getFirst());
//        System.out.println(aArr.getLast());
//        System.out.println(aArr.get(3));
//        System.out.println(aArr.toString());
//        System.out.println(aArr.getIndex(1000));
//        aArr.add(-1,24);
//
        //add remove O(n)
//        aArr.add(7,10);
//        System.out.println(aArr);
//
//        System.out.println(aArr.remove(5));
//        System.out.println(aArr);
//
//        System.out.println(aArr.removeLast());
//        System.out.println(aArr);

        DynamicArray<Student> studentArr =  new DynamicArray<>(20);
        studentArr.addLast(new Student("张三",99));
        studentArr.addLast(new Student("李四",87));
        studentArr.addLast(new Student("王五",35));
        studentArr.addLast(new Student("赵六",22));

        System.out.println(studentArr.toString());
    }
}

