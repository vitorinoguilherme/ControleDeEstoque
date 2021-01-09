package models;

public class SubCategoria {
    private Integer codigo;
    private String nome;
    private Categoria categoria;

    public SubCategoria(Integer codigo, String nome, Integer codigoCategoria) {
        this.setCodigo(codigo);
        this.setNome(nome);
        this.categoria = new Categoria(codigoCategoria);
    }

    public SubCategoria(Integer codigo, String nome) {
        this.setCodigo(codigo);
        this.setNome(nome);
        this.categoria = new Categoria();
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCategoria(Integer codigoCategoria, String nomeCategoria) {
        this.categoria = new Categoria(codigoCategoria, nomeCategoria, this);
    }
}
