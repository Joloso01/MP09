package UF2.A1Cargols;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainCargols {

    public static void main(String[] args) {

        Cargol cargol1 = new Cargol("TreuBañes");
        Cargol cargol2 = new Cargol("Treuvi");

        MonitorCargol monitorCargol1 = new MonitorCargol(cargol1);
        MonitorCargol monitorCargol2 = new MonitorCargol(cargol2);

        ScheduledExecutorService schService = Executors.newScheduledThreadPool(3);
        schService.scheduleWithFixedDelay(monitorCargol1,5,5, TimeUnit.SECONDS);
        schService.scheduleWithFixedDelay(monitorCargol2,5,5,TimeUnit.SECONDS);

        try {
            schService.awaitTermination(15, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        schService.shutdown();

        if (cargol1.getMetros() > cargol2.getMetros()){
            System.out.println("Ha guanyat el Cargol: "+cargol1.getNom()+" amb "+ cargol1.getMetros()+ "metres recorreguts.");
        }else {
            System.out.println("Ha guanyat el Cargol: "+cargol2.getNom()+" amb "+ cargol2.getMetros()+ " metres recorreguts.");
        }

    }
}
