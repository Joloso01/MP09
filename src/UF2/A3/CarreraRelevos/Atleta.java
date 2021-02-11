package UF2.A3.CarreraRelevos;

public class Atleta extends Thread {
    Testigo t;
    private int Dorsal;

    public Atleta(String nombre, Testigo t) {
        super(nombre);
        this.t = t;
        Dorsal = (int) (Math.random() * 100) +1;
    }


    @Override
    public void run() {
        super.run();
        t.CojerTestigo();
        System.out.println("El corredor "+getName()+" ha cogido el testigo.");
        try {
            Thread.sleep((long) (Math.random()*1000)+1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t.dejarTestigo();
        System.out.println("El corredor "+getName()+" ha dejado el testigo.");
    }
}
