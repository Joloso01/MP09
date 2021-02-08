package UF2.A3.Comandament;

//Monitor
public class Comandament {
    private boolean lliure;

    public Comandament() {
        lliure = true;
    }

    public synchronized void agafar() {
        while (!lliure){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lliure = false;
    }

    public synchronized void deixar() {
        lliure = true;
        notifyAll();
    }
}
