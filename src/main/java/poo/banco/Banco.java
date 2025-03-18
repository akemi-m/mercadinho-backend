package poo.banco;

import java.util.ArrayList;
import java.util.List;

public final class Banco {

    private final String name;
    private final List<Cliente> clientes;

    public Banco(String name) {
        this.name = name;
        this.clientes = new ArrayList<>();
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public String getName() {
        return name;
    }
    
}
