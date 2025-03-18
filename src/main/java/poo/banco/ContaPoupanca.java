package poo.banco;

public class ContaPoupanca extends Conta {

    @Override
    public void sacar(double valor) {
        if (valor < 0) {
            throw new RuntimeException("Saque negativo");
        } else if (valor <= saldo) {
            this.saldo -= valor;
        } else {
            throw new RuntimeException("Saldo insuficiente");
        }
    }
    
}
