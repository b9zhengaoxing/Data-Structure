public class Main {

    public static void main(String[] args) {
        //数组，一队数据排成排
        //索引，0 —— N
        //对于Java语言 ,数组中只能存放同一种类型的数据

        /*声明1:开辟空间，声明大小*/
        int[] arr = new int[10];//new 开辟空间，同时必须声明数组可以装多少个元素
        for(int i = 0 ; i < arr.length/*比使用硬编码容易修改*/ ; i ++){
             arr[i] = i;
        }

        /*声明时有初始值*/
        int[] scores = new int[]{99,100,101};
        for (int i = 0; i < scores.length; i++) {
            System.out.println(scores[i]);
        }

        scores[0] = 19;
        /*Foreach,可遍可迭代*/
        for (int score:scores) {
            System.out.println(score);
        }
    }
}
