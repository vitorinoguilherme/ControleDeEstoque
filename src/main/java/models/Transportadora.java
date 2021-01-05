package models;

/**
 * Transportadora model class.
 */
public class Transportadora {
    private Integer codigo;
    private String cnpj;
    private String razaoSocial;
    private CEP cep;
    private Telefone telefone;
    private Email email;

    /**
     * This constructor is used by class TransportadoraGateway.
     * @param codigo
     * @param cnpj
     * @param razaoSocial
     * @param cep
     * @param telefone
     * @param email
     */
    public Transportadora(Integer codigo, String cnpj, String razaoSocial, String cep, String telefone, String email) {
        this.setCodigo(codigo);
        this.setCnpj(cnpj);
        this.setRazaoSocial(razaoSocial);
        this.email = new Email(email);
        this.telefone = new Telefone(telefone);
        this.cep = new CEP(cep);
    }


    /**
     * This constructor is used by class Pedido.
     * @param codigo
     * @param cnpj
     */
    public Transportadora(Integer codigo, String cnpj) {
        this.setCodigo(codigo);
        this.setCnpj(cnpj);
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setCep(CEP cep) {
        this.cep = cep;
    }

    public CEP getCep() {
        return cep;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Email getEmail() {
        return email;
    }
}
