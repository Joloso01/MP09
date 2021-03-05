package UF2.A3.Filosofos;

public class Cubierto {

    /*
    Metode agafar
    Metode deixar
     */
    private boolean lliure=true;

    public synchronized void agafar(){
        while (!lliure) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lliure=false;
        notifyAll();

    }

    public synchronized void deixar(){
        lliure=true;
        notifyAll();
    }
}
