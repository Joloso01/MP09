package UF2.A3.CarreraRelevos;

public class MainCarreraRelevos {
    public static void main(String[] args) {

        Testigo equipo1 = new Testigo("equipo1");
        Atleta alt1 = new Atleta("Fernando",equipo1);
        Atleta alt2 = new Atleta("Marta",equipo1);
        Atleta alt3 = new Atleta("Samuel",equipo1);
        Atleta alt4 = new Atleta("Cristiano",equipo1);

        Testigo equipo2 = new Testigo("equipo2");
        Atleta alt21 = new Atleta("Alonso",equipo2);
        Atleta alt22 = new Atleta("Pepe",equipo2);
        Atleta alt23 = new Atleta("Anna",equipo2);
        Atleta alt24 = new Atleta("ronaldo",equipo2);

        Testigo equipo3 = new Testigo("equipo3");
        Atleta alt31 = new Atleta("Cristina",equipo3);
        Atleta alt32 = new Atleta("Maria",equipo3);
        Atleta alt33 = new Atleta("Daniel",equipo3);
        Atleta alt34 = new Atleta("Manolo",equipo3);

        Testigo equipo4 = new Testigo("equipo4");
        Atleta alt41 = new Atleta("Gisela",equipo4);
        Atleta alt42 = new Atleta("Neus",equipo4);
        Atleta alt43 = new Atleta("Eric",equipo4);
        Atleta alt44 = new Atleta("Joel",equipo4);

        alt1.start();
        alt2.start();
        alt3.start();
        alt4.start();
        alt21.start();
        alt22.start();
        alt23.start();
        alt24.start();
        alt31.start();
        alt32.start();
        alt33.start();
        alt34.start();
        alt41.start();
        alt42.start();
        alt43.start();
        alt44.start();



    }
}
