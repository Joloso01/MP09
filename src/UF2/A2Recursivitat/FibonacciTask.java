package UF2.A2Recursivitat;

public class FibonacciTask extends java.util.concurrent.RecursiveTask<Integer>{

    int n;

    public FibonacciTask(int n) {
        this.n = n;
    }

    public int fibonacciRecurivo(int n){
        System.out.println("fibRecur: "+n);
        if (n <= 1)return n;
        FibonacciTask f1 = new FibonacciTask(n-1);
        FibonacciTask f2 = new FibonacciTask(n-2);
        f1.fork();
        f2.fork();
        return f1.join() + f2.join();


//        if (n <= 1){
//            return n;
//        }
//        return fibonacciRecurivo(n-1)+fibonacciRecurivo(n-2);
    }

    public int fibonacciSeq(int n){
        System.out.println("fibSeq: "+n);
        int prev1 = 1;
        int prev2=1;

        for (int i = 0; i < n; i++) {
            int temp = prev1;
            prev1 = prev2;
            prev2 = temp + prev2;
        }
        return prev1;
    }

    @Override
    protected Integer compute() {
        if (n > 7)return fibonacciRecurivo(n);
        else return fibonacciSeq(n);
    }
}
