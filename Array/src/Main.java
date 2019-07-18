public class Main {

    public static void main(String[] args) {
        /*Java数组的问题*/
        // 1. 索引不表意
        // 2. 空间固定：不足或者浪费

        Array arr = new Array(20);
        for (int i = 0; i < 10; i++) {
            arr.addFirst(i);
        }
        System.out.println(arr);

        arr.add(1,100);
        System.out.println(arr);


        arr.addFirst(-1);
        System.out.println(arr);

        System.out.println(arr.get(6));

    }
}
