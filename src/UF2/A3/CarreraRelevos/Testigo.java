package UF2.A3.CarreraRelevos;

public class Testigo {
    private String nombre;
    double tiempo;
    boolean libre;
    int corredores=0;

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
        libre = true;
        corredores++;
        notifyAll();
    }

    public synchronized void tiempoFinal(){
        if (corredores == 4){
            System.out.println("El equipo "+getNombre()+" ha finalizado la carrera con un tiempo de: "+tiempo+" segundos.");

        }
    }

    public String getNombre() {
        return nombre;
    }
}
