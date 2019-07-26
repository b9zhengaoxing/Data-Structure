public class Main {

    public static void main(String[] args) {
        /*Java数组的问题*/
        // 1. 索引不表意
        // 2. 空间固定：不足或者浪费

        Array<Integer> arr = new Array<>(); /*告诉Java，存放的是Integer类型*/
        for (int i = 0; i < 10; i++) {
            arr.addFirst(i);
        }
        System.out.println(arr);

        arr.add(1,100);
        System.out.println(arr);


        arr.addFirst(-1);
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);

        arr.removeElement(5);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);
    }
}
