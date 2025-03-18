package poo.banco;

import java.util.UUID;

public abstract class Cliente {

    private final String id = UUID.randomUUID().toString();
    private final String name;

    public Cliente(String name) {
        this.name = name;
    }

    public final String getId() {
        return id;
    }

    public final String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "[" + id + "]: " + name;
    }

    @Override
    public boolean equals(Object obj) {
        return 
            (obj != null) &&
            (obj instanceof Cliente) &&
            ((Cliente) obj).getId().equals(id);
    }
    
}
