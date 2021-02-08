package UF2.A3;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MainBanc {

    public static void main(String[] args) throws InterruptedException {

        CompteEstalvi compteEstalvi = new CompteEstalvi(0);
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        Thread tIngres = null;
        Thread tSacar = null;

        for (int i = 0; i < 1000; i++) {
            tIngres = new Thread(compteEstalvi.procesIngresar);
            tSacar = new Thread(compteEstalvi.procesSacar);
            tIngres.start();
            tSacar.start();
        }

        tIngres.join();
        tSacar.join();

        System.out.println("Saldo final: "+compteEstalvi.getSaldo());

    }
}
