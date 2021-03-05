package UF2.A3.Filosofos;

public class Filosofo extends Thread{

    Cubierto c1, c2;

    public Filosofo(String copernico, Cubierto c1, Cubierto c2) {
        super(copernico);
        this.c1 = c1;
        this.c2 = c2;
    }

    @Override
    public void run() {
        super.run();
        for (;;){
            menjar();
            System.out.println("El filosof "+getName()+" ha agafats els coberts");
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            pensar();
            System.out.println("El filosof "+getName()+" ha deixat els coberts");
        }

    }

    private void menjar() {
        c1.agafar();
        c2.agafar();
    }

    private void pensar() {
        c1.deixar();
        c2.deixar();
    }
}
