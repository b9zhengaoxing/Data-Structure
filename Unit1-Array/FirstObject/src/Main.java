public class Main {
    public static void main(String[] args) {
        //声明数组 + 变量名 int[] double[] String[]
        //分配内存，初始化 new
        //初始化时候需要指定数组大小  = new int[10];
        //直接初始化{}
        int[] arr = new int[10];
        int[] scores = new int[]{100,99,59};

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
        for(int score:scores){
            System.out.println(score);
        }
    }
}