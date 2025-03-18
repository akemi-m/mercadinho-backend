package poo.aula05;

import poo.banco.Conta;
import poo.banco.ContaCorrente;

public class ExemploSaque {

    public static void main(String[] args) {
        Conta c1 = new ContaCorrente(1000);
        c1.depositar(90);
        c1.sacar(70);
        c1.sacar(200);
//        c1.depositar(1000);
        System.out.println(c1.getSaldo());
    }

    
}
