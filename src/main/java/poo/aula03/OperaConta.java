package poo.aula03;

import poo.banco.Conta;
import poo.banco.ContaPoupanca;

public class OperaConta {

    public static void main(String[] args) {

        Conta c1 = new ContaPoupanca();
        System.out.println(c1);

        Conta c2 = new ContaPoupanca();
        System.out.println(c2);
        
    }
    
}
