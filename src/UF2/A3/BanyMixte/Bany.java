package UF2.A3.BanyMixte;

public class Bany {
    private boolean homeDins=false;
    private boolean donaDins=false;
    private final int maimxPersones = 10;
    private int personesDins=0;

    public synchronized void entrar(String nom,String genere) {
        if (genere.equals("M")) {
            while (donaDins) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            personesDins++;
            homeDins=true;
            notifyAll();
            System.out.println(nom + " te ganas de anar al bany.");


        } else if (genere.equals("F")) {
            while (homeDins) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            donaDins=true;
            personesDins++;
            notifyAll();
            System.out.println(nom + " te ganas de anar al bany.");
        }

    }


    public synchronized void treballar(String nom, String genere) {

        personesDins--;
        if (personesDins == 0 && genere.equals("F")){
            donaDins=false;
        }else if (personesDins ==0 && genere.equals("M")){
            homeDins=false;
        }
        notifyAll();
        System.out.println(nom + " torna al treball.");
    }
}
