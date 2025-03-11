package poo.banco;

public class PessoaJuridica extends Cliente {

    private String cnpj;

    public PessoaJuridica(String name, String cnpj) {
        super(name);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }
    
}
