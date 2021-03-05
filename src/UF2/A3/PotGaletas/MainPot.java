package UF2.A3.PotGaletas;

public class MainPot {
    public static void main(String[] args) {
        Pot pot = new Pot();
        Fills fill = new Fills("Joan",pot);
        Fills filla = new Fills("Alexia", pot);
        Pares pare = new Pares("Antonio",pot);
        Pares mare = new Pares("Cristina",pot);


        for (int i = 0; i < 100; i++) {
            fill.start();
            filla.start();
            pare.start();
            mare.start();
        }
    }

}
