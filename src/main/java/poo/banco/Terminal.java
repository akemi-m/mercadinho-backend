package poo.banco;

import java.util.Scanner;

public class Terminal {

    private Scanner scanner;
    private Banco banco;

    public void run() {
        this.scanner = new Scanner(System.in);
        this.banco = new Banco("Mogi International Bank");
        while (true) {

            System.out.print("> ");
            String line = scanner.nextLine().trim();
            if (line.equals("exit")) {
                break;
            } else if (line.equals("help")) {
                printHelp();
            } else if (line.equals("1")) {
                // cria cliente
                Cliente cliente = createCustomer();
                banco.getClientes().add(cliente);
            } else if (line.equals("2")) {
                listCustomers();
            }
        }
        scanner.close();
        System.out.println("bye bye!");
    }

    private void listCustomers() {
        for (Cliente c: banco.getClientes()) {
            System.out.println(c);
        }
    }

    private Cliente createCustomer() {
        System.out.print("Nome: ");
        String name = scanner.nextLine().trim();
        Cliente cliente = new Cliente(name);
        return cliente;
    }
    
    private void printHelp() {
        String help = "";
        help += "\n  1. criar cliente";
        help += "\n  2. listar clientes";
        help += "\n  3. criar conta";
        System.out.println(help);
    }

}
