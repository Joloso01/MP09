package UF2.A3.Comandament;

public class MembreFamilia extends Thread {
    Comandament c;

    public MembreFamilia(String nom,Comandament c) {
        super(nom);
        this.c = c;
    }

    @Override
    public void run(){
        //intentarà agafar el comandament
        c.agafar();
        //mirara el canal que vol
        try {
            Thread.sleep((long) (Math.random()*500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //deixarà el comandamant
        c.deixar();
        //anirà al lavabo
        try {
            Thread.sleep((long) (Math.random()*1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
