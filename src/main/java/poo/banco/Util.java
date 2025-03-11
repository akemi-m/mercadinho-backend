package poo.banco;

public final class Util {

    private Util() {}

    public static final boolean isCpf(String cpf) {
        if (cpf == null) return false;
        cpf = cpf.replace("/[^0-9]/", "");
        System.out.println(cpf);
        // TODO: verificar o digito validador
        return cpf.length() == 11;
    }
    
}
