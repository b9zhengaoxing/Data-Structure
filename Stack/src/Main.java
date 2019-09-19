import java.util.Random;

public class Main {

    private static double testStatck (Stack<Integer> stack, int opCount) {
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }

        long endTime = System.nanoTime();

        return (endTime -startTime)/1000000000.0;
    }

    public static void main (String[] args) {
        // write your code here
//        ArrayStack<Integer> stack = new ArrayStack<>();
//        for (int i = 0; i < 5; i++) {
//            stack.push(i);
//            System.out.println(stack);
//        }
//
//        stack.pop();
//        System.out.println(stack);
//        System.out.println(stack.peek());

//        LinkedListStack<Integer> stack = new LinkedListStack<>();
//        for (int i = 0; i < 5; i++) {
//            stack.push(i);
//            System.out.println(stack);
//        }
//
//        stack.pop();
//        System.out.println(stack);

        int opCount = 100000;

        //需要分配静态数据，比较耗时
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time1 = testStatck(arrayStack,opCount);
        System.out.println("ArrayStatck, Time :" + time1 + "s");

        /*需要经常New，比较耗时*/
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double time2 = testStatck(linkedListStack,opCount);
        System.out.println("linkedListStack, Time :" + time2 + "s");
    }
}
