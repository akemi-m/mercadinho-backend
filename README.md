# espm.poo25.1

```mermaid
classDiagram
    Conta <|-- ContaCorrente
    Conta <|-- ContaPoupanca
    class Conta{
      +float saldo
      +saque()
      +deposito()
    }
```
