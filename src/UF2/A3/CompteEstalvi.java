package UF2.A3;

public class CompteEstalvi{
    private int saldo;

    public CompteEstalvi(int saldo) {
        this.saldo = saldo;
    }



    public synchronized int getSaldo() {
        return saldo;
    }

    public synchronized void setSaldo(int saldo) {
        this.saldo = saldo;
    }



    Runnable procesIngresar = () -> saldo = saldo+100;
    Runnable procesSacar = () -> saldo = saldo-50;

}
