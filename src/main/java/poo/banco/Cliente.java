package poo.banco;

import java.util.UUID;

public abstract class Cliente {

    private final String id;
    private final String name;

    public Cliente(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public Cliente(String id, String name) {
        this.id = id;
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

    @Override
    public int hashCode() {
        return id.hashCode();
    }
    
}
