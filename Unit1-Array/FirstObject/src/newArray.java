import com.sun.org.apache.xpath.internal.operations.Bool;

public class newArray {

    //成员变量设计 private 避免外部访问，造成数据不一致情况
    private int[] data;
    private int size;

    //    构造函数，是一种特殊的方法。 主要用来在创建对象时初始化对象， 即为对象成员变量赋初始值，总与new运算符一起使用在创建对象的语句中。 特别的一个类可以有多个构造函数，可根据其参数个数的不同或参数类型的不同来区分它们即构造函数的重载。
    //    作 用： 为对象成员变量赋初始值
    //    外文名： constructor
    //    语 句： new运算符一起使用
    public newArray(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    //constructor overload
    public newArray() {
        this(10);
    }

    public void arrayGrammar() {
        //声明数组 + 变量名 int[] double[] String[]
        //分配内存，初始化 new
        //初始化时候需要指定数组大小  = new int[10];
        //直接初始化{}
        int[] arr = new int[10];
        int[] scores = new int[]{100, 99, 59};

        //数组遍历：使用索引 遍历
        //不要使用硬编码—— 索引遍历
        for (int i = 0; i < 10; i++) {
            arr[i] = i;
//            System.out.println(arr[i]);
        }
        //不用硬编码
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 100;
            System.out.println(arr[i]);
        }
        //foreach 语法： for(元素：数组)
        for (int score : scores) {
            System.out.println(score);
        }
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
    public void addLast(int aData) {
        this.add(size, aData);
    }

    //复用
    public void addFirst(int aData) {
        this.add(0, aData);
    }

    //队中插入 依次向前
    public void add(int index, int aData) {
        if (size >= data.length - 1) {
            throw new IllegalArgumentException(String.format("add failed, size >= data.length - 1 index:%d  data:%d",index,aData));
        }

        if (index >= data.length || index < 0) {
            throw new IllegalArgumentException(String.format("add failed, index > capacity || index < 0 index:%d data:%d",index,aData));
        }

        if (index > size) {
            throw new IllegalArgumentException("add failed, index > size");
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = aData;
        size++;
    }
}

