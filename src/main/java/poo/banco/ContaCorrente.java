package poo.banco;

public class ContaCorrente extends Conta {

    private double limite = 0;

    public ContaCorrente() {
        this(10);
    }

    public ContaCorrente(double limite) {
        this.limite = limite;
    }

    /* 
     * realiza um saque da conta do usuario
     * restrito ao saldo da conta e nao permite
     * valores negativos
     */
    @Override
    public void sacar(double valor) {
        if (valor < 0) {
            throw new RuntimeException("Saque negativo");
        }
        if (valor <= (saldo + limite)) {
            this.saldo -= valor;
        } else {
            throw new RuntimeException("Limite excedido");
        }
    }

    
}
