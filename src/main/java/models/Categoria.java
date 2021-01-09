package models;

import java.util.List;
import java.util.ArrayList;

/**
 * Categoria model class.
 * This class describes a category of a product.
 * @version 1.0
 */
public class Categoria {
    private Integer codigo;
    private String nome;
    private List<SubCategoria> subCategorias;

    public Categoria(Integer codigo, String nome, SubCategoria subCategoria) {
        this.setCodigo(codigo);
        this.setNome(nome);
        this.subCategorias.add(subCategoria);
    }

    public Categoria(Integer codigo, String nome, List subCategorias) {
        this.setCodigo(codigo);
        this.setNome(nome);
        this.subCategorias = new ArrayList<>();
    }

    public Categoria(Integer codigo, String nome) {
        this.setCodigo(codigo);
        this.setNome(nome);
    }

    public Categoria (Integer codigo) {
        this.setCodigo(codigo);
    }

    public Categoria () {

    }

    public void addSubCategoria(SubCategoria subcategoria) {
        this.subCategorias.add(subcategoria);
    }

    public List<SubCategoria> getSubCategorias() {
        return subCategorias;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
