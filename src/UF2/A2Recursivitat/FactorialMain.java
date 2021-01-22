package UF2.A2Recursivitat;

import java.util.concurrent.ForkJoinPool;

public class FactorialMain {
    public static int f(int n){
        if (n==0){
            return 0;
        }else {
            System.out.printf("Calculando f(%d)\n",n);
            return f(n-1)+1;
        }
    }

    public static void main(String[] args) {
        ForkJoinPool executor = new ForkJoinPool();
        RecursiveTask recursiveTask = new RecursiveTask(12);
        executor.execute(recursiveTask);
        Long r = recursiveTask.join();

        System.out.println("Resultat: "+r);
    }
}
