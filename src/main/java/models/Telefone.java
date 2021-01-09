package models;

public class Telefone {
    private String numero;

    public Telefone(String numero) {
        this.setNumero(numero);
    }

    public Telefone() {

    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }
}
