import java.util.Random;

public class Main {

    private static double testQueue (Queue<Integer> q, int opCount) {

        long startTime = System.nanoTime();

        Random radom = new Random();
        for (int i = 0; i < opCount; i++) {
            q.enqueue(radom.nextInt(Integer.MAX_VALUE));/*从0到最大*/
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) /1000000000.0;
    }

    public static void main (String[] args) {
        // write your code here
        int opCount = 100000;

        /*时间复杂度是O (N2)，主要在removeFirst for ,循环*/
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue is " + time1 + " s");

        /*时间复杂度是O（n）， N * 均摊复杂度 O（1）*/
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue is " + time2 + " s");

        /*时间复杂度是O（n）， resize*/
        LinkedListQueue<Integer> linkedQueue = new LinkedListQueue<>();
        double time3 = testQueue(linkedQueue, opCount);
        System.out.println("linkedQueue is " + time3 + " s");
    }
}
