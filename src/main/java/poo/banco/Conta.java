package poo.banco;

import java.util.UUID;

public class Conta {

    private String id = UUID.randomUUID().toString();
    protected double saldo = 0;

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
        }
    }

    /* 
    * realiza um saque da conta do usuario
     * restrito ao saldo da conta e nao permite
     * valores negativos
     */
    public void sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            this.saldo -= valor;
        }
    } 

    public String getId() {
        return id;
    }

    public double getSaldo() {
        return saldo;
    }

    /*
     * https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html
     */
    @Override
    public String toString() {
        return "[" + this.id + "]: " + this.saldo;
    }

}
