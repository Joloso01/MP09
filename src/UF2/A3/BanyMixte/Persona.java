package UF2.A3.BanyMixte;

public class Persona extends Thread {
    private Bany bany;
    private String genere;

    public Persona(String nom,String genere,Bany bany) {
        super(nom);
        this.bany = bany;
        this.genere = genere;
    }

    @Override
    public void run() {
        super.run();
        for(;;){
            bany.entrar(getName(),genere);
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            bany.treballar(getName(),genere);
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
