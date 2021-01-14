package UF2.A1Cargols;

public class Cargol {
    private String nom;
    private int metros;

    public Cargol(String nom1){
        nom=nom1;
    }

    public Cargol(String nom1,int metros) {
        this.metros = metros;
    }

    public int getMetros() {
        return metros;
    }

    public void setMetros(int metros) {
        this.metros = metros;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
