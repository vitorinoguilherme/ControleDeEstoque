package controllers;


import data.ProdutoGateway;
import views.HomePage;

import java.awt.*;

public class ControllerHomePage {
    private HomePage homePage;
    private ProdutoController produto;
    private Fornecedor fornecedor;
    private Compra compra;
    private Encomenda encomenda;
    private ProdutoGateway produtoGateway;

    public ControllerHomePage(HomePage homePage, ProdutoGateway produtoGateway) {
        this.homePage = homePage;
        this.produtoGateway = produtoGateway;
        this.produto = new ProdutoController(this.homePage, this.produtoGateway);
        this.produto.initProduto();
        this.fornecedor = new Fornecedor(this.homePage);
        this.fornecedor.initFornecedor();
        this.compra = new Compra(this.homePage);
        this.compra.initCompra();
        this.encomenda = new Encomenda(this.homePage);
        this.encomenda.initEncomenda();
    }

    public void initView() {

    }

    public void initController() {
        homePage.getProductButton().addActionListener(actionEvent -> switchingProduto());
        homePage.getFornecedoresButton().addActionListener(actionEvent -> switchingFornecedores());
        homePage.getPurchaseButton().addActionListener(actionEvent -> switchingPurchase());
        homePage.getEncomendaButton().addActionListener(actionEvent -> switchingEncomendas());
    }

    private void switchingProduto() {
        homePage.setAllVisibleFalse();
        homePage.getBody().add(homePage.getProduto());
        homePage.getProduto().setVisible(true);
    }

    private void switchingFornecedores() {
        homePage.setAllVisibleFalse();
        homePage.getBody().add(homePage.getFornecedores());
        homePage.getFornecedores().setVisible(true);
    }

    private void switchingPurchase() {
        homePage.setAllVisibleFalse();
        homePage.getBody().add(homePage.getCompras());
        homePage.getCompras().setVisible(true);
    }

    private void switchingEncomendas() {
        homePage.setAllVisibleFalse();
        homePage.getBody().add(homePage.getEncomendas());
        homePage.getEncomendas().setVisible(true);
    }

//    private void setAllVisibleFalse() {
//        homePage.getProdGetAll().setVisible(false);
//        homePage.getProdCreate().setVisible(false);
//        homePage.getProdUpdate().setVisible(false);
//        homePage.getProdDelete().setVisible(false);
//
//        homePage.getProduto().setVisible(false);
//        homePage.getFornecedores().setVisible(false);
//        homePage.getCompras().setVisible(false);
//        homePage.getEncomendas().setVisible(false);
//    }
}
