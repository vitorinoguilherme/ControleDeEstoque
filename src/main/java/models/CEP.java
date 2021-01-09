package models;

public class CEP {
    private String cep;

    public CEP(String cep) {
        this.setCep(cep);
    }

    public CEP() {

    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCep() {
        return cep;
    }
}
