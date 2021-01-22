package UF2.A2Recursivitat;

public class RecursiveTask extends java.util.concurrent.RecursiveTask<Long> {
    int n;
    int fact;

    public RecursiveTask(int n) {
        this.n = n;
    }

    public Long factorialRec(){
        if (n==1) return 1L;
        RecursiveTask recursiveTask = new RecursiveTask(n-1);
        System.out.println("Recursiu: "+n);
        recursiveTask.fork();
        return recursiveTask.join()*n;


    }

    private Long factorialIter() {
        int result=1,i=1;
        while(i<=n){
            result=result*i;
            System.out.println("Iteratiu: "+n);
            i++;
        }

        return (long) result;
    }

    @Override
    protected Long compute() {
        if (n > 8) return factorialRec();
        else return factorialIter();
    }


}
