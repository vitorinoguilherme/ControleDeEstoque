package models;

import java.util.concurrent.atomic.AtomicInteger;

public class Fornecedor {
    //private static final AtomicInteger count = new AtomicInteger(0);
    private Integer codigo;
    private String razaoSocial;
    private String cnpj;
    private Email email;
    private Telefone telefone;
    private CEP cep;

    public Fornecedor(Integer codigo, String razaoSocial, String cnpj, String email, String telefone, String cep) {
        this.setCodigo(codigo);
        this.setRazaoSocial(razaoSocial);
        this.setCnpj(cnpj);
        this.email = new Email(email);
        this.telefone = new Telefone(telefone);
        this.cep = new CEP(cep);
    }

    public Fornecedor(Integer codigo, String cnpj) {
        this.setCodigo(codigo);
        this.setCnpj(cnpj);
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    @Override
    public String toString() {
        return "\n CODIGO: "+this.getCodigo()+"" +
                "\n RAZAO SOCIAL: "+this.getRazaoSocial()+"" +
                "\n CNPJ: "+this.getCnpj()+"" +
                "\n E-MAIL: "+this.email.getEmail()+"" +
                "\n TELEFONE: "+this.telefone.getNumero()+"" +
                "\n CEP: "+this.cep.getCep()+"";
    }



}
