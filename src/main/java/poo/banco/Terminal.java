package poo.banco;

import java.util.Scanner;

public class Terminal {

    private Scanner scanner;
    private Banco banco;

    public void run() {
        try {
            this.scanner = new Scanner(System.in);
            this.banco = new Banco("Mogi International Bank");
            System.out.println();
            System.out.println(banco.getName());
            System.out.println();
            Cliente atualCliente = null;
            while (true) {

                try {

                    String prompt = "";
                    prompt +=
                        atualCliente == null
                        ? ""
                        : atualCliente.getName();

                    System.out.print(prompt + "> ");
                    String line = scanner.nextLine().trim();
                    if (line.equals("exit")) {
                        break;
                    } else if (line.equals("help")) {
                        printHelp();
                    } else if (line.equals("1")) {
                        // cria cliente
                        atualCliente = createCustomer();
                        banco.getClientes().add(atualCliente);
                    } else if (line.equals("2")) {
                        listCustomers();
                    } else if (line.equals("3")) {
                        Conta conta = createAccount(atualCliente);
                    } else if (line.length() == 0) {

                    } else {
                        throw new UnsupportedOperationException("invalid command");
                    }
                } catch (UnsupportedOperationException e) {
                    System.err.println(e.getMessage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
            System.out.println("bye bye!");    
        }
    }

    private void listCustomers() {
        // for (Cliente c: banco.getClientes()) {
        //     System.out.println(c);
        // }
        banco.getClientes().stream().forEach(c -> {
            System.out.println(c);
        });
    }

    private Cliente createCustomer() {

        Cliente cliente;

        System.out.print("Nome: ");
        String name = scanner.nextLine().trim();

        System.out.print("Tipo Fisica|Juridica [f|j]: ");
        String tipo = scanner.nextLine().trim();
        if (tipo.trim().toLowerCase().equals("f")) {
            String cpf = null;
            while (true) {
                System.out.print("CPF: ");
                cpf = scanner.nextLine().trim();
                if (Util.isCpf(cpf)) break;
                System.out.println("CPF invalido");
            }
            cliente = new PessoaFisica(name, cpf);
        } else {
            System.out.print("CNPJ: ");
            String cnpj = scanner.nextLine().trim();
            cliente = new PessoaJuridica(name, cnpj);
        }

        // nao eh possivel, pois a classe cliente
        // eh abstrata
        // Cliente cliente = new Cliente(name);

        return cliente;
    }
    
    private void printHelp() {
        String help = "";
        help += "\n  1. criar cliente";
        help += "\n  2. listar clientes";
        help += "\n  3. criar conta";
        System.out.println(help);
    }

    private Conta createAccount(Cliente cliente) {
        if (cliente == null) {
            throw new RuntimeException("Cliente nao definido");
        }
        Conta conta;
        System.out.print("Tipo [(P)oupanca|(C)orrente]: ");
        String tipo = scanner.nextLine().trim().toLowerCase();

        if (tipo.equals("p")) {
            conta = new ContaPoupanca(cliente);
        } else {
            conta = new ContaCorrente(cliente);
        }

        return conta;
    }

}
