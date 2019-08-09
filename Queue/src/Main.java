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

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue is " + time1 + " s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue is " + time2 + " s");
    }
}
