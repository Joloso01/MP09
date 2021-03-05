package UF2.A3.PotGaletas;

public class Pot {
    private int galletas=0;
    private boolean lliure=true;


    public int getGalletas() {
        return galletas;
    }

    public void setGalletas(int galletas) {
        this.galletas = galletas;
    }

    public synchronized void posarGaletas(){

        while (!lliure || galletas != 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        galletas = 10;
        lliure = false;
        notifyAll();
        System.out.println("han omplert el pot de galetes.");
        System.out.println("quedan "+galletas+" galetas.");
    }

    public synchronized void AgafarGaletas(){

        while (!lliure || galletas == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            galletas--;
            lliure=false;
            notifyAll();
            System.out.println("han agafat una galeta");
            System.out.println("quedan "+galletas+" galetas.");
        }

    public synchronized void deixarPot(){
        lliure=true;
        notifyAll();
    }
}
