package UF2.A2Recursivitat;

import java.util.concurrent.ForkJoinPool;

public class FibonacciMain {
    public static void main(String[] args) {
        ForkJoinPool executor = new ForkJoinPool();
        FibonacciTask fibonacciTask = new FibonacciTask(8);
        executor.execute(fibonacciTask);
        Integer r = fibonacciTask.join();

        System.out.println("Resultat: "+r);
    }
}
