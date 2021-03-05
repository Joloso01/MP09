package UF2.A3.Filosofos;

public class MainFilosofos {
    public static void main(String[] args) {
        Cubierto c0 = new Cubierto();
        Cubierto c1 = new Cubierto();
        Cubierto c2 = new Cubierto();
        Cubierto c3 = new Cubierto();

        Filosofo f0 = new Filosofo("Aris" ,c3,c0);
        Filosofo f1 = new Filosofo("Copernico" ,c0,c1);
        Filosofo f2 = new Filosofo("Descartes" ,c1,c2);
        Filosofo f3 = new Filosofo("Parme" ,c2,c3);

        for (int i = 0; i < 10; i++) {
            f0.start();
            f1.start();
            f2.start();
            f3.start();
        }
    }
}
