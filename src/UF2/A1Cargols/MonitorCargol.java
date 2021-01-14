package UF2.A1Cargols;

public class MonitorCargol implements Runnable{
    Cargol cargol;

    public MonitorCargol(Cargol cargol){
        this.cargol=cargol;
    }

    @Override
    public void run() {
        int metres=(int) ((Math.random())*1000);
        cargol.setMetros(metres);
        System.out.println("El cargol "+ cargol.getNom() + " ha recorregut " + metres );
        System.out.println("I porta en total: "+cargol.getMetros()+"m");
    }
}
