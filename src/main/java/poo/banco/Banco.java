package poo.banco;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Banco {

    private final String name;
    private final Map<String, Cliente> clientesById;

    public Banco(String name) {
        this.name = name;
        this.clientesById = new HashMap<>();
    }

    public List<Cliente> getClientes() {
        return new ArrayList<>(clientesById.values());
    }

    public Cliente getCliente(String id) {
        return clientesById.get(id);
    }

    public String getName() {
        return name;
    }
    
}
