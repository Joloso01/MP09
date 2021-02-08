package UF2.A3;

public class Persona extends Thread{
    private String name;

    public Persona(String name) {
        setName(name);
    }

    @Override
    public void run() {
        System.out.println("Hola soy el proceso: "+getName());
    }

    public static void main(String[] args) {
        Persona persona = new Persona("Joloso");
        Persona persona2 = new Persona("El oso");

        persona.start();
        persona2.start();
    }
}
