package UF2.A3.PotGaletas;

public class Pares extends Thread{
    private Pot pot;

    public Pares(String nom,Pot pot) {
        super(nom);
        this.pot = pot;
    }

    @Override
    public void run() {
        super.run();
        for (;;){
            pot.posarGaletas();
            pot.deixarPot();
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
