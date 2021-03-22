package controllers;

import data.ProdutoGateway;
import models.Produto;
import views.HomePage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.text.ParseException;


public class ProdutoController {
    private HomePage homePage;
    private ProdutoGateway produtoGateway;

    public ProdutoController(HomePage homePage, ProdutoGateway produtoGateway) {
        this.homePage = homePage;
        this.produtoGateway = produtoGateway;
    }

    public void initView() {

    }

    public void initProduto() {
        int count = 0;
        for (JButton button: homePage.getProductButtons()) {
            int finalCount = count;
            button.addActionListener(actionEvent -> switching(finalCount));
            count++;
        }
        homePage.getProductButtons().get(0).addActionListener(actionEvent -> {
            displayTable();
        });
        homePage.getProdutoSaveButton().addActionListener(actionEvent -> {
            try {
                saveProduto();
            } catch (ParseException | SQLException e) {
                e.printStackTrace();
            }
        });
        homePage.getProdutoUpdateButton().addActionListener(actionEvent -> {
            try {
                updateProduto();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        homePage.getProdutoDeleteButton().addActionListener(actionEvent -> {
            try {
                deleteProduto();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    private void switching(int count) {
        if (count == 0) {
            homePage.setAllVisibleFalse();
            homePage.getBody().add(homePage.getProdGetAll());
            homePage.getProdGetAll().setVisible(true);
        } else if (count == 1) {
            homePage.setAllVisibleFalse();
            homePage.getBody().add(homePage.getProdCreate());
            homePage.getProdCreate().setVisible(true);
        } else if (count == 2) {
            homePage.setAllVisibleFalse();
            homePage.getBody().add(homePage.getProdUpdate());
            homePage.getProdUpdate().setVisible(true);
        } else if (count == 3) {
            homePage.setAllVisibleFalse();
            homePage.getBody().add(homePage.getProdDelete());
            homePage.getProdDelete().setVisible(true);
        }
    }

    private void displayTable() {
        homePage.getProdGetAll().repaint();
        homePage.getProdGetAll().removeAll();

        JTable tableProduto = new JTable();
        DefaultTableModel modelProduto = new DefaultTableModel();
        Object[] columnsNameProduto = new Object[12];


        columnsNameProduto[0] = "codigo";
        columnsNameProduto[1] = "nome";
        columnsNameProduto[2] = "quantidade_minima";
        columnsNameProduto[3] = "validade";
        columnsNameProduto[4] = "descricao";
        columnsNameProduto[5] = "peso";
        columnsNameProduto[6] = "cor";
        columnsNameProduto[7] = "altura";
        columnsNameProduto[8] = "largura";
        columnsNameProduto[9] = "codigo_fornecedor";
        columnsNameProduto[10] = "cnpj_fornecedor";
        columnsNameProduto[11] = "codigo_categoria";

        modelProduto.setColumnIdentifiers(columnsNameProduto);

        Object[] rowData = new Object[12];

        ProdutoGateway pg = new ProdutoGateway();
        try {
            for (Produto produto : pg.getAll()) {
                rowData[0] = produto.getCodigo();
                rowData[1] = produto.getNome();
                rowData[2] = produto.getQuantidadeMinima();
                rowData[3] = produto.getValidade();
                rowData[4] = produto.getDescricao();
                rowData[5] = produto.getPeso();
                rowData[6] = produto.getCor();
                rowData[7] = produto.getAltura();
                rowData[8] = produto.getLargura();
                rowData[9] = produto.getFornecedor().getCodigo();
                rowData[10] = produto.getFornecedor().getCnpj();
                rowData[11] = produto.getCategoria().getCodigo();

                modelProduto.addRow(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        tableProduto.setModel(modelProduto);
        JScrollPane pane = new JScrollPane(tableProduto);

        homePage.getProdGetAll().add(pane, BorderLayout.CENTER);
    }
    private void saveProduto() throws ParseException, SQLException {
        String descricao = homePage.getDescricao().getText();
        if (descricao.equals("")) {
            descricao = null;
        }
        Double peso;
        try {
            peso = Double.parseDouble(homePage.getPeso().getText());
        } catch (NumberFormatException e) {
            peso = null;
        }

        String cor = homePage.getCor().getText();
        if (cor.equals("")) {
            cor = null;
        }

        Double altura;
        try {
            altura = Double.parseDouble(homePage.getAltura().getText());
        } catch (NumberFormatException e) {
            altura = null;
        }

        Double largura;
        try {
            largura = Double.parseDouble(homePage.getLargura().getText());
        } catch (NumberFormatException e) {
            largura = null;
        }

        String text = homePage.getValidadeProduto().getText();
        java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");
        java.time.LocalDate textFieldAsDate = java.time.LocalDate.parse(text, formatter);

        java.sql.Date sqlDate = java.sql.Date.valueOf(textFieldAsDate);
        this.produtoGateway.create(
                homePage.getNomeProduto().getText(),
                Integer.parseInt(homePage.getQtdMinima().getText()),
                sqlDate,
                descricao,
                peso,
                cor,
                altura,
                largura,
                Integer.parseInt(homePage.getCodigoFornecedor().getText()),
                homePage.getCNPJFornecedor().getText(),
                Integer.parseInt(homePage.getCodigoCategoria().getText())
        );
    }

    private void updateProduto() throws SQLException {
        String nome = homePage.getNomeUpdate().getText();
        String descricao = homePage.getDescricaoUpdate().getText();
        Double peso = Double.parseDouble(homePage.getPesoUpdate().getText());
        String cor = homePage.getCorUpdate().getText();
        Double altura = Double.parseDouble(homePage.getAlturaUpdate().getText());
        Double largura = Double.parseDouble(homePage.getLarguraUpdate().getText());
        int codigo = Integer.parseInt(homePage.getCodigoUpdate().getText());
        this.produtoGateway.update(nome, descricao, peso, cor, altura, largura, codigo);
    }

    private void deleteProduto() throws SQLException {
        int codigo = Integer.parseInt(homePage.getCodigoDelete().getText());

        this.produtoGateway.delete(codigo);
    }





}
