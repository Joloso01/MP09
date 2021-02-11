package UF2.A3.CarreraRelevos;

public class Testigo {
    private String nombre;
    double tiempo;
    boolean libre;

    public Testigo(String nombre) {
        this.nombre = nombre;
        libre=true;
    }

    public synchronized void CojerTestigo() {
        while (!libre){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        libre = false;
    }

    public synchronized void dejarTestigo() {
        tiempo += Math.random()*10+1;
        System.out.println("El equipo "+nombre+" lleva: " +tiempo+" segundos. ");
        libre = true;
        notifyAll();
    }

}
