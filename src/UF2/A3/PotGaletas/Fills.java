package UF2.A3.PotGaletas;

public class Fills extends Thread{
    private Pot pot;

    public Fills(String nom,Pot pot) {
        super(nom);
        this.pot = pot;
    }

    @Override
    public void run() {
        super.run();
            for (;;){
                pot.AgafarGaletas();
                pot.deixarPot();
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
}
