package models;

import java.util.Date;

/**
 * Produto model class.
 * @version 1.0
 */
public class Produto {
    private Integer codigo;
    private String nome;
    private Integer quantidadeMinima;
    private Date validade;
    private String descricao;
    private Double peso;
    private String cor;
    private Double altura;
    private Double largura;
    private Fornecedor fornecedor;
    private Categoria categoria;

    public Produto(Integer codigo, String nome, Integer quantidadeMinima, Date validade, String descricao,
                   Double peso, String cor, Double altura, Double largura, Integer codigoFornecedor,
                   String cnpjFornecedor, Integer codigoCategoria) {
        this.setCodigo(codigo);
        this.setNome(nome);
        this.setQuantidadeMinima(quantidadeMinima);
        this.setValidade(validade);
        this.setDescricao(descricao);
        this.setPeso(peso);
        this.setCor(cor);
        this.setAltura(altura);
        this.setLargura(largura);
        this.fornecedor = new Fornecedor(codigoFornecedor, cnpjFornecedor);
        this.categoria = new Categoria(codigoCategoria);
    }

    public Produto(Integer codigo, String nome, Integer quantidadeMinima, Date validade, String descricao,
    Double peso, String cor, Double altura, Double largura) {
        this.setCodigo(codigo);
        this.setNome(nome);
        this.setQuantidadeMinima(quantidadeMinima);
        this.setValidade(validade);
        this.setDescricao(descricao);
        this.setPeso(peso);
        this.setCor(cor);
        this.setAltura(altura);
        this.setLargura(largura);
    }

    public Produto() {

    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setQuantidadeMinima(Integer quantidadeMinima) {
        this.quantidadeMinima = quantidadeMinima;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public void setLargura(Double largura) {
        this.largura = largura;
    }
}
