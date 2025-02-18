package poo.banco;

import java.util.UUID;

public class Cliente {

    private String id = UUID.randomUUID().toString();
    private final String name;

    public Cliente(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "[" + id + "]: " + name;
    }
    
}
