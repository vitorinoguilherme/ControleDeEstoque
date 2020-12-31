package models;

import java.util.Date;

/**
 * Cliente model class.
 * @version 1.0
 */
public class Cliente {
    private Integer codigo;
    private String cpf;
    private String nome;
    private Date dataNascimento;
    private Telefone telefone;
    private Email email;
    private CEP cep;

    /**
     * @param codigo the codigo is unique for each client.
     * @param cpf the registration of individuals.
     * @param nome the name of customer.
     * @param dataNascimento the customer's date of birth.
     * @param telefone the telephone of customer.
     * @param email the e-mail of customer.
     * @param cep the cep of customer.
     */
    public Cliente (Integer codigo, String cpf, String nome, Date dataNascimento,
                    String telefone, String email, String cep) {
        this.setCodigo(codigo);
        this.setCpf(cpf);
        this.setNome(nome);
        this.setDataNascimento(dataNascimento);
        this.telefone = new Telefone(telefone);
        this.email = new Email(email);
        this.cep = new CEP(cep);
    }

    public Cliente (Integer codigo, String cpf, String nome, String email, Date dataNascimento, String cep) {

        this.setCodigo(codigo);
        this.setCpf(cpf);
        this.setNome(nome);
        this.setDataNascimento(dataNascimento);

        this.email = new Email(email);
        this.cep = new CEP(cep);

        this.telefone = new Telefone();
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    @Override
    public String toString() {
        return "\n CODIGO: "+this.getCodigo()+"" +
                "\n CPF: "+this.getCpf()+"" +
                "\n NOME: "+this.getNome()+"" +
                "\n DATA NASCIMENTO: "+this.getDataNascimento()+"" +
                "\n E-MAIL: "+this.email.getEmail()+"" +
                "\n TELEFONE: "+this.telefone.getNumero()+"" +
                "\n CEP: "+this.cep.getCep()+"";
    }
}
