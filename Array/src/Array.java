public class Array {

    private int[] data;/*设置私有的，为了数据安全，用户只能通过设置的操作进行数据访问*/
    private int size;

    /**
     * 构造函数，传入数组容量capacity构造Array
     * @param capacity
     */
    public Array(int capacity){
        data = new int[capacity];
        size = 0;
    }

    /**
     * 无参数构造函数，默认capacity = 10
     * @param capacity
     */
    public Array(){
        this(10);
    }

    /**
     * 获取数组中元素的个数
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 获取数组的容量
     * @return
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 返回数组是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 向所有元素后增加一个新元素
     * @param e
     */
    public void addLast(int e){
        this.add(size,e);
    }


    /**
     * 向所有元素前增加一个新元素
     * @param e
     */
    public void addFirst(int e){
        this.add(0,e);
    }

    /**
     * 在index元素位置插入一个新元素e
     * @param index
     * @param e
     * @return
     */
    public void add(int index,int e)
    {
        if (size == data.length) {
            throw new IllegalArgumentException("Add failed.Array is full");
        }

        if (index < 0 || index>size){
            throw new IllegalArgumentException("Add failed, Require index >= 0 && index < = size");
        }

        for (int i = size ; i > index ; i--) {
            data[i] = data[i-1];
        }
        data[index] = e;
        size ++;
    }

    /*作业：传入静态数组生成Array类的对象*/
//    public Array(int arr[]){
//        data = arr;
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] != null){
//                size = i + 1;
//            }
//        }
//    }

    /**
     * 取出索引为index的元素 通过Get方法，用户永远无法使用那些没有使用空间
     * @param index
     * @return
     */
    int get(int index){

        if (index < 0 || index>size){
            throw new IllegalArgumentException("Get failed, Require index >= 0 && index < = size");
        }

        return data[index];
    }

    /**
     * 修改index元素为e 并且返回原值
     * @param index
     * @param e
     * @return
     */
    public int set(int index,int e){
        if (index < 0 || index>size){
            throw new IllegalArgumentException("Add failed, Require index >= 0 && index < = size");
        }

        int res = data[index];
        data[index] = e;
        return res;
    }

    /**
     * 查找数组中，是否包含元素e
     * @param e
     * @return
     */
    public boolean contains(int e){
        for (int i = 0; i < size; i++) {
            if (data[i] == e){
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中元素 e 的位置
     * @param e
     * @return 索引
     */
    public int find(int e){
        for (int i = 0; i < size; i++) {
            if (data[i] == e){
                return i;
            }
        }
        return -1;/*无效索引通常定义为-1*/
    }

    /**
     * 从数组中删除index位置的元素
     * @param index
     * @return
     */
    public int remove(int index){
        if (index < 0 || index>size){
            throw new IllegalArgumentException("Remove failed, Require index >= 0 && index < = size");
        }

        int res = data[index];
        for (int i = index ; i < size-1 ; i++) {
            data[i] = data[i+1];
        }
        size--;
        return res;
    }

    /**
     * 从数组中删除第一个位置的元素，返回对应的元素
     * @return
     */
    public int removeFirst(){
        return remove(0);
    }

    /**
     * 从数组中删除最后一个位置的元素，返回对应的元素
     * @return
     */
    public int removeLast(){
        return remove(size-1);
    }

    /**
     *
     * @param e
     */
    public void removeElement(int e){
        int index = find(e);
        if (index != -1){
            remove(index);
        }
    }

    @Override/*覆盖父类方式，提示*/
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("size = %d , capacity = %d\n",size,data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size -1){
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }
}
