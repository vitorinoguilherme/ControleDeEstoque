package views;

import data.FornecedorGateway;
import data.ProdutoGateway;
import models.Fornecedor;
import models.Produto;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomePage {
    // View uses Swing framework to display UI to user
    private JFrame frame;
    private JPanel panel;
    private JPanel header;
    private JPanel breadcrumbs;
    private JPanel sidebar;
    private JPanel body;
    private JPanel middlePanel;
    private JPanel footer;

    private JLabel title;

    private JButton productButton;
    private JButton fornecedoresButton;
    private JButton purchaseButton;
    private JButton encomendaButton;

    // Pages of Body that have options of CRUD.
    private JPanel produto, fornecedores, compras, encomendas;

    private List<JButton> productButtons = new ArrayList<>();
    private List<JButton> fornecedoresButtons = new ArrayList<>();
    private List<JButton> purchaseButtons = new ArrayList<>();
    private List<JButton> encomendaButtons = new ArrayList<>();

    // Pages of specificy CRUD operations.
    private JPanel prodGetAll, prodCreate, prodUpdate, prodDelete;

    // Selecionar Produtos


    // JTextFields of prodCreate
    // Cadastrar produto
    private JPanel cadastrarProdutoPanel;
    private JLabel cadastrarProdutoLabel;
    private JTextField nomeProduto;
    private JTextField validadeProduto;
    private JTextField codigoCategoria;
    private JTextField qtdMinima;
    // Dimensões, Características e Descrição
    private JPanel informacoesPanel;
    private JLabel dimensoesLabel, caracteristicasLabel, descricaoLabel;
    private JTextField altura;
    private JTextField largura;
    private JTextField cor;
    private JTextField peso;
    private JTextField descricao;
    private JTextField codigo;
    private JPanel produtoSavePanel;
    private JButton produtoSaveButton;
    private JButton produtoDeleteButton;

    // Atualizar Produto
    private JPanel atualizarProdutoPanel;
    private JButton produtoUpdateButton;
    private JTextField nomeUpdate;
    private JTextField descricaoUpdate;
    private JTextField pesoUpdate;
    private JTextField corUpdate;
    private JTextField alturaUpdate;
    private JTextField larguraUpdate;
    private JTextField codigoUpdate;

    // Deletar Produto
    private JPanel deletarProdutoPanel;
    private JTextField codigoDelete;

    // Fornecedor
    private JPanel fornecedorPanel;
    private JLabel fornecedorLabel;
    private JTextField codigoFornecedor;
    private JTextField CNPJFornecedor;

    private JPanel fornGetAll, fornCreate, fornUpdate, fornDelete;
    private JPanel compGetAll, compCreate, compUpdate, compDelete;
    private JPanel encoGetAll, encoCreate, encoUpdate, encoDelete;

    public HomePage(String titleFrame) {
        // Create a Main Frame.
        frame = new JFrame(titleFrame);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setDefaultLookAndFeelDecorated(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setPreferredSize(new Dimension(1200, 700));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Header and breadcrumbs
        breadcrumbs = getPanel(Color.ORANGE);
        breadcrumbs.setPreferredSize(new Dimension(10, 25));

        header = new JPanel(new BorderLayout());
        header.add(breadcrumbs, BorderLayout.SOUTH);

        // Sidebar and body
        sidebar = getPanel(Color.BLACK);
        sidebar.setPreferredSize(new Dimension(130, 10));
        sidebar.setLayout(new GridLayout(4, 1, 5, 8));

        body = getPanel(Color.RED);
        //body.setPreferredSize(new Dimension(130, 500));
        body.setLayout(new BorderLayout());

        middlePanel = new JPanel(new BorderLayout());
        middlePanel.add(sidebar, BorderLayout.WEST);
        middlePanel.add(body, BorderLayout.CENTER);

        // Footer
        footer = getPanel(Color.DARK_GRAY);

        // Main Panel
        panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        panel.add(header, BorderLayout.NORTH);
        panel.add(middlePanel, BorderLayout.CENTER);
        panel.add(footer, BorderLayout.SOUTH);

        // Switching Pages in a JFrame
        produto = new JPanel(new GridLayout(2, 2, 150, 50));
        produto.setBorder(BorderFactory.createEmptyBorder(100, 100, 150, 100));

        fornecedores = new JPanel(new GridLayout(2, 2, 150, 50));
        fornecedores.setBorder(BorderFactory.createEmptyBorder(100, 100, 150, 100));

        compras = new JPanel(new GridLayout(2, 2, 150, 50));
        compras.setBorder(BorderFactory.createEmptyBorder(100, 100, 150, 100));

        encomendas = new JPanel(new GridLayout(2, 2, 150, 50));
        encomendas.setBorder(BorderFactory.createEmptyBorder(100, 100, 150, 100));

        // Pages with CRUD.
        prodGetAll = new JPanel(new BorderLayout());
        prodGetAll.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        prodCreate = new JPanel(new GridLayout(4,1, 0, 50));
        prodCreate.setBorder(BorderFactory.createEmptyBorder(50, 100, 0, 350));

        cadastrarProdutoPanel = new JPanel(new GridLayout(2,4, 20, 5));
        fornecedorPanel = new JPanel(new GridLayout(2,1, 10, 5));
        fornecedorPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 300));
        informacoesPanel = new JPanel(new GridLayout(3,3, 20, 5));
        produtoSavePanel = new JPanel(new BorderLayout());
        produtoSavePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 460));

        prodUpdate = new JPanel(new BorderLayout());
        prodUpdate.setBorder(BorderFactory.createEmptyBorder(100, 100, 150, 100));

        atualizarProdutoPanel = new JPanel(new GridLayout(8, 2, 0, 0));

        prodDelete = new JPanel(new GridLayout(2, 2, 150, 50));
        prodDelete.setBorder(BorderFactory.createEmptyBorder(100, 100, 150, 100));

        deletarProdutoPanel = new JPanel(new  GridLayout(3, 1, 0, 0));

        fornGetAll = new JPanel(new GridLayout(2, 2, 150, 50));
        fornGetAll.setBorder(BorderFactory.createEmptyBorder(100, 100, 150, 100));

        fornCreate = new JPanel(new GridLayout(2, 2, 150, 50));
        fornCreate.setBorder(BorderFactory.createEmptyBorder(100, 100, 150, 100));

        fornUpdate = new JPanel(new GridLayout(2, 2, 150, 50));
        fornUpdate.setBorder(BorderFactory.createEmptyBorder(100, 100, 150, 100));

        fornDelete = new JPanel(new GridLayout(2, 2, 150, 50));
        fornDelete.setBorder(BorderFactory.createEmptyBorder(100, 100, 150, 100));

        compGetAll = new JPanel(new GridLayout(2, 2, 150, 50));
        compGetAll.setBorder(BorderFactory.createEmptyBorder(100, 100, 150, 100));

        compCreate = new JPanel(new GridLayout(2, 2, 150, 50));
        compCreate.setBorder(BorderFactory.createEmptyBorder(100, 100, 150, 100));

        compUpdate = new JPanel(new GridLayout(2, 2, 150, 50));
        compUpdate.setBorder(BorderFactory.createEmptyBorder(100, 100, 150, 100));

        compDelete = new JPanel(new GridLayout(2, 2, 150, 50));
        compDelete.setBorder(BorderFactory.createEmptyBorder(100, 100, 150, 100));

        encoGetAll = new JPanel(new GridLayout(2, 2, 150, 50));
        encoGetAll.setBorder(BorderFactory.createEmptyBorder(100, 100, 150, 100));

        encoCreate = new JPanel(new GridLayout(2, 2, 150, 50));
        encoCreate.setBorder(BorderFactory.createEmptyBorder(100, 100, 150, 100));

        encoUpdate = new JPanel(new GridLayout(2, 2, 150, 50));
        encoUpdate.setBorder(BorderFactory.createEmptyBorder(100, 100, 150, 100));

        encoDelete = new JPanel(new GridLayout(2, 2, 150, 50));
        encoDelete.setBorder(BorderFactory.createEmptyBorder(100, 100, 150, 100));

        // Create UI elements
        title = new JLabel(titleFrame, SwingConstants.CENTER);
        title.setFont(new Font("Calibri", Font.BOLD, 24));

        Font sideBarFont = new Font("Calibri", Font.BOLD, 16);
        productButton = new JButton("Produtos");
        productButton.setFont(sideBarFont);
        fornecedoresButton = new JButton("Fornecedores");
        fornecedoresButton.setFont(sideBarFont);
        purchaseButton = new JButton("Compras");
        purchaseButton.setFont(sideBarFont);
        encomendaButton = new JButton("Encomendas");
        encomendaButton.setFont(sideBarFont);

        //Add UI element to frame
        header.add(title, BorderLayout.NORTH);

        sidebar.add(productButton);
        sidebar.add(fornecedoresButton);
        sidebar.add(purchaseButton);
        sidebar.add(encomendaButton);

        List<String> opcoes = Arrays.asList("Selecionar", "Criar", "Atualizar", "Deletar");
        for (String opc : opcoes) {
            JButton buttonProd = new JButton("" + opc + " produtos");
            buttonProd.setFont(new Font("Calibri", Font.ITALIC, 14));
            productButtons.add(buttonProd);
            produto.add(buttonProd);

            JButton buttonForn = new JButton("" + opc + " fornecedores");
            buttonForn.setFont(new Font("Calibri", Font.ITALIC, 14));
            fornecedoresButtons.add(buttonForn);
            fornecedores.add(buttonForn);

            JButton buttonComp = new JButton("" + opc + " compras");
            buttonComp.setFont(new Font("Calibri", Font.ITALIC, 14));
            purchaseButtons.add(buttonComp);
            compras.add(buttonComp);

            JButton buttonEnco = new JButton("" + opc + " encomendas");
            buttonEnco.setFont(new Font("Calibri", Font.ITALIC, 14));
            encomendaButtons.add(buttonEnco);
            encomendas.add(buttonEnco);
        }

        // Cadastrar produto
        cadastrarProdutoPanel.setBorder(new TitledBorder("Produto"));
        cadastrarProdutoPanel.add(new JLabel("Nome do Produto:"));
        cadastrarProdutoPanel.add(nomeProduto = new JTextField());
        cadastrarProdutoPanel.add(new JLabel("Codigo da Categoria:"));
        cadastrarProdutoPanel.add(codigoCategoria = new JTextField());
        cadastrarProdutoPanel.add(new JLabel("Validade:"));
        cadastrarProdutoPanel.add(validadeProduto = new JTextField());
        cadastrarProdutoPanel.add(new JLabel("Quantidade Minima:"));
        cadastrarProdutoPanel.add(qtdMinima = new JTextField());
        fornecedorPanel.setBorder(new TitledBorder("Fornecedor"));
        fornecedorPanel.add(new JLabel("Codigo fornecedor:"));
        fornecedorPanel.add(codigoFornecedor = new JTextField());
        fornecedorPanel.add(new JLabel("CNPJ fornecedor:"));
        fornecedorPanel.add(CNPJFornecedor = new JTextField());
        informacoesPanel.setBorder(new TitledBorder("Dimensoes / Caracteristicas"));
        informacoesPanel.add(new JLabel("Altura:"));
        informacoesPanel.add(altura = new JTextField());
        informacoesPanel.add(new JLabel("Largura:"));
        informacoesPanel.add(largura = new JTextField());
        informacoesPanel.add(new JLabel("Cor:"));
        informacoesPanel.add(cor = new JTextField());
        informacoesPanel.add(new JLabel("Peso:"));
        informacoesPanel.add(peso = new JTextField());
        informacoesPanel.add(new JLabel("Descricao:"));
        informacoesPanel.add(descricao = new JTextField());
        produtoSavePanel.add(produtoSaveButton = new JButton("Salvar produto"));

        prodCreate.add(cadastrarProdutoPanel);
        prodCreate.add(fornecedorPanel);
        prodCreate.add(informacoesPanel);
        prodCreate.add(produtoSavePanel);
        
        // Atualizar Produto
        atualizarProdutoPanel.setBorder(new TitledBorder("> Atualizar Produto"));
        atualizarProdutoPanel.add(new JLabel("CODIGO:"));
        atualizarProdutoPanel.add(codigoUpdate = new JTextField());
        atualizarProdutoPanel.add(new JLabel("Nome do Produto:"));
        atualizarProdutoPanel.add(nomeUpdate = new JTextField());
        atualizarProdutoPanel.add(new JLabel("Descricao:"));
        atualizarProdutoPanel.add(descricaoUpdate = new JTextField());
        atualizarProdutoPanel.add(new JLabel("Peso:"));
        atualizarProdutoPanel.add(pesoUpdate = new JTextField());
        atualizarProdutoPanel.add(new JLabel("Cor:"));
        atualizarProdutoPanel.add(corUpdate = new JTextField());
        atualizarProdutoPanel.add(new JLabel("Altura:"));
        atualizarProdutoPanel.add(alturaUpdate = new JTextField());
        atualizarProdutoPanel.add(new JLabel("Largura:"));
        atualizarProdutoPanel.add(larguraUpdate = new JTextField());

        produtoUpdateButton = new JButton("atualizar");
        produtoUpdateButton.setPreferredSize(new Dimension(200,40));
        JPanel panelUpdate = new JPanel();
        panelUpdate.add(produtoUpdateButton);

        prodUpdate.add(atualizarProdutoPanel, BorderLayout.CENTER);
        prodUpdate.add(panelUpdate, BorderLayout.AFTER_LAST_LINE);
//
        // Deletar produto
        deletarProdutoPanel.setBorder(new TitledBorder("> Deletar Produto"));
        deletarProdutoPanel.add(new JLabel("Codigo Produto:"));
        deletarProdutoPanel.add(codigoDelete = new JTextField());
        deletarProdutoPanel.add(produtoDeleteButton = new JButton("deletar"));

        prodDelete.add(deletarProdutoPanel);

        setAllVisibleFalse();
        // Add subpages of JFrame (Switching on-click)
        body.add(produto);
        body.add(fornecedores);
        body.add(compras);
        body.add(encomendas);

        // Add subpages of CRUD (Switching on-click)
        body.add(prodGetAll);
        body.add(prodCreate);
        body.add(prodUpdate);
        body.add(prodDelete);

        body.add(fornGetAll);
        body.add(fornCreate);
        body.add(fornUpdate);
        body.add(fornDelete);

        body.add(compGetAll);
        body.add(compCreate);
        body.add(compUpdate);
        body.add(compDelete);

        body.add(encoGetAll);
        body.add(encoCreate);
        body.add(encoUpdate);
        body.add(encoDelete);

        // Configure Panels in Frame.
        frame.setContentPane(panel);
        frame.pack();
    }

    private JPanel getPanel(Color color) {
        JPanel result = new JPanel();
        result.setBorder(BorderFactory.createLineBorder(color));
        return result;
    }

    public void setAllVisibleFalse() {
        getProdGetAll().setVisible(false);
        getProdCreate().setVisible(false);
        getProdUpdate().setVisible(false);
        getProdDelete().setVisible(false);

        getFornGetAll().setVisible(false);
        getFornCreate().setVisible(false);
        getFornUpdate().setVisible(false);
        getFornDelete().setVisible(false);

        getCompGetAll().setVisible(false);
        getCompCreate().setVisible(false);
        getCompUpdate().setVisible(false);
        getCompDelete().setVisible(false);

        getEncoGetAll().setVisible(false);
        getEncoCreate().setVisible(false);
        getEncoUpdate().setVisible(false);
        getEncoDelete().setVisible(false);

        getProduto().setVisible(false);
        getFornecedores().setVisible(false);
        getCompras().setVisible(false);
        getEncomendas().setVisible(false);
    }

    /**
     * Returns an ImageIcon, or null if the path was invalid.
     */
    protected ImageIcon createImageIcon(String path,
                                        String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    public JTextField getCodigoDelete() {
        return codigoDelete;
    }

    public void setCodigoDelete(JTextField codigoDelete) {
        this.codigoDelete = codigoDelete;
    }

    public JPanel getCadastrarProdutoPanel() {
        return cadastrarProdutoPanel;
    }

    public void setCadastrarProdutoPanel(JPanel cadastrarProdutoPanel) {
        this.cadastrarProdutoPanel = cadastrarProdutoPanel;
    }

    public JLabel getCadastrarProdutoLabel() {
        return cadastrarProdutoLabel;
    }

    public void setCadastrarProdutoLabel(JLabel cadastrarProdutoLabel) {
        this.cadastrarProdutoLabel = cadastrarProdutoLabel;
    }

    public JTextField getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(JTextField nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public JTextField getValidadeProduto() {
        return validadeProduto;
    }

    public void setValidadeProduto(JTextField validadeProduto) {
        this.validadeProduto = validadeProduto;
    }

    public JTextField getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(JTextField codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public JTextField getQtdMinima() {
        return qtdMinima;
    }

    public void setQtdMinima(JTextField qtdMinima) {
        this.qtdMinima = qtdMinima;
    }

    public JPanel getFornecedorPanel() {
        return fornecedorPanel;
    }

    public void setFornecedorPanel(JPanel fornecedorPanel) {
        this.fornecedorPanel = fornecedorPanel;
    }

    public JLabel getFornecedorLabel() {
        return fornecedorLabel;
    }

    public void setFornecedorLabel(JLabel fornecedorLabel) {
        this.fornecedorLabel = fornecedorLabel;
    }

    public JTextField getCodigoFornecedor() {
        return codigoFornecedor;
    }

    public void setCodigoFornecedor(JTextField codigoFornecedor) {
        this.codigoFornecedor = codigoFornecedor;
    }

    public JTextField getCNPJFornecedor() {
        return CNPJFornecedor;
    }

    public void setCNPJFornecedor(JTextField CNPJFornecedor) {
        this.CNPJFornecedor = CNPJFornecedor;
    }

    public JPanel getInformacoesPanel() {
        return informacoesPanel;
    }

    public void setInformacoesPanel(JPanel informacoesPanel) {
        this.informacoesPanel = informacoesPanel;
    }

    public JLabel getDimensoesLabel() {
        return dimensoesLabel;
    }

    public void setDimensoesLabel(JLabel dimensoesLabel) {
        this.dimensoesLabel = dimensoesLabel;
    }

    public JLabel getCaracteristicasLabel() {
        return caracteristicasLabel;
    }

    public void setCaracteristicasLabel(JLabel caracteristicasLabel) {
        this.caracteristicasLabel = caracteristicasLabel;
    }

    public JLabel getDescricaoLabel() {
        return descricaoLabel;
    }

    public void setDescricaoLabel(JLabel descricaoLabel) {
        this.descricaoLabel = descricaoLabel;
    }

    public JTextField getAltura() {
        return altura;
    }

    public void setAltura(JTextField altura) {
        this.altura = altura;
    }

    public JTextField getLargura() {
        return largura;
    }

    public void setLargura(JTextField largura) {
        this.largura = largura;
    }

    public JTextField getCor() {
        return cor;
    }

    public void setCor(JTextField cor) {
        this.cor = cor;
    }

    public JTextField getPeso() {
        return peso;
    }

    public void setPeso(JTextField peso) {
        this.peso = peso;
    }

    public JTextField getDescricao() {
        return descricao;
    }

    public void setDescricao(JTextField descricao) {
        this.descricao = descricao;
    }

    public JPanel getProdutoSavePanel() {
        return produtoSavePanel;
    }

    public void setProdutoSavePanel(JPanel produtoSavePanel) {
        this.produtoSavePanel = produtoSavePanel;
    }

    public JButton getProdutoSaveButton() {
        return produtoSaveButton;
    }

    public void setProdutoSaveButton(JButton produtoSaveButton) {
        this.produtoSaveButton = produtoSaveButton;
    }

    public JPanel getProdGetAll() {
        return prodGetAll;
    }

    public void setProdGetAll(JPanel prodGetAll) {
        this.prodGetAll = prodGetAll;
    }

    public JPanel getProdCreate() {
        return prodCreate;
    }

    public void setProdCreate(JPanel prodCreate) {
        this.prodCreate = prodCreate;
    }

    public JPanel getProdUpdate() {
        return prodUpdate;
    }

    public void setProdUpdate(JPanel prodUpdate) {
        this.prodUpdate = prodUpdate;
    }

    public JPanel getProdDelete() {
        return prodDelete;
    }

    public void setProdDelete(JPanel prodDelete) {
        this.prodDelete = prodDelete;
    }

    public JPanel getFornGetAll() {
        return fornGetAll;
    }

    public void setFornGetAll(JPanel fornGetAll) {
        this.fornGetAll = fornGetAll;
    }

    public JPanel getFornCreate() {
        return fornCreate;
    }

    public void setFornCreate(JPanel fornCreate) {
        this.fornCreate = fornCreate;
    }

    public JPanel getFornUpdate() {
        return fornUpdate;
    }

    public void setFornUpdate(JPanel fornUpdate) {
        this.fornUpdate = fornUpdate;
    }

    public JPanel getFornDelete() {
        return fornDelete;
    }

    public void setFornDelete(JPanel fornDelete) {
        this.fornDelete = fornDelete;
    }

    public JPanel getCompGetAll() {
        return compGetAll;
    }

    public void setCompGetAll(JPanel compGetAll) {
        this.compGetAll = compGetAll;
    }

    public JPanel getCompCreate() {
        return compCreate;
    }

    public void setCompCreate(JPanel compCreate) {
        this.compCreate = compCreate;
    }

    public JPanel getCompUpdate() {
        return compUpdate;
    }

    public void setCompUpdate(JPanel compUpdate) {
        this.compUpdate = compUpdate;
    }

    public JPanel getCompDelete() {
        return compDelete;
    }

    public void setCompDelete(JPanel compDelete) {
        this.compDelete = compDelete;
    }

    public JPanel getEncoGetAll() {
        return encoGetAll;
    }

    public void setEncoGetAll(JPanel encoGetAll) {
        this.encoGetAll = encoGetAll;
    }

    public JPanel getEncoCreate() {
        return encoCreate;
    }

    public void setEncoCreate(JPanel encoCreate) {
        this.encoCreate = encoCreate;
    }

    public JPanel getEncoUpdate() {
        return encoUpdate;
    }

    public void setEncoUpdate(JPanel encoUpdate) {
        this.encoUpdate = encoUpdate;
    }

    public JPanel getEncoDelete() {
        return encoDelete;
    }

    public void setEncoDelete(JPanel encoDelete) {
        this.encoDelete = encoDelete;
    }

    public List<JButton> getProductButtons() {
        return productButtons;
    }

    public void setProductButtons(List<JButton> productButtons) {
        this.productButtons = productButtons;
    }

    public List<JButton> getFornecedoresButtons() {
        return fornecedoresButtons;
    }

    public void setFornecedoresButtons(List<JButton> fornecedoresButtons) {
        this.fornecedoresButtons = fornecedoresButtons;
    }

    public List<JButton> getPurchaseButtons() {
        return purchaseButtons;
    }

    public void setPurchaseButtons(List<JButton> purchaseButtons) {
        this.purchaseButtons = purchaseButtons;
    }

    public List<JButton> getEncomendaButtons() {
        return encomendaButtons;
    }

    public void setEncomendaButtons(List<JButton> encomendaButtons) {
        this.encomendaButtons = encomendaButtons;
    }

    public JPanel getMiddlePanel() {
        return middlePanel;
    }

    public void setMiddlePanel(JPanel middlePanel) {
        this.middlePanel = middlePanel;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JPanel getHeader() {
        return header;
    }

    public void setHeader(JPanel header) {
        this.header = header;
    }

    public JPanel getBreadcrumbs() {
        return breadcrumbs;
    }

    public void setBreadcrumbs(JPanel breadcrumbs) {
        this.breadcrumbs = breadcrumbs;
    }

    public JPanel getSidebar() {
        return sidebar;
    }

    public void setSidebar(JPanel sidebar) {
        this.sidebar = sidebar;
    }

    public JPanel getBody() {
        return body;
    }

    public void setBody(JPanel body) {
        this.body = body;
    }

    public JPanel getFooter() {
        return footer;
    }

    public void setFooter(JPanel footer) {
        this.footer = footer;
    }

    public JLabel getTitle() {
        return title;
    }

    public void setTitle(JLabel title) {
        this.title = title;
    }

    public JButton getProductButton() {
        return productButton;
    }

    public void setProductButton(JButton productButton) {
        this.productButton = productButton;
    }

    public JButton getFornecedoresButton() {
        return fornecedoresButton;
    }

    public void setFornecedoresButton(JButton fornecedoresButton) {
        this.fornecedoresButton = fornecedoresButton;
    }

    public JButton getPurchaseButton() {
        return purchaseButton;
    }

    public void setPurchaseButton(JButton purchaseButton) {
        this.purchaseButton = purchaseButton;
    }

    public JButton getEncomendaButton() {
        return encomendaButton;
    }

    public void setEncomendaButton(JButton encomendaButton) {
        this.encomendaButton = encomendaButton;
    }

    public JPanel getProduto() {
        return produto;
    }

    public void setProduto(JPanel produto) {
        this.produto = produto;
    }

    public JPanel getFornecedores() {
        return fornecedores;
    }

    public void setFornecedores(JPanel fornecedores) {
        this.fornecedores = fornecedores;
    }

    public JPanel getCompras() {
        return compras;
    }

    public void setCompras(JPanel compras) {
        this.compras = compras;
    }

    public JPanel getEncomendas() {
        return encomendas;
    }

    public void setEncomendas(JPanel encomendas) {
        this.encomendas = encomendas;
    }

    public JPanel getAtualizarProdutoPanel() {
        return atualizarProdutoPanel;
    }

    public void setAtualizarProdutoPanel(JPanel atualizarProdutoPanel) {
        this.atualizarProdutoPanel = atualizarProdutoPanel;
    }

    public JPanel getDeletarProdutoPanel() {
        return deletarProdutoPanel;
    }

    public void setDeletarProdutoPanel(JPanel deletarProdutoPanel) {
        this.deletarProdutoPanel = deletarProdutoPanel;
    }

    public JTextField getCodigo() {
        return codigo;
    }

    public void setCodigo(JTextField codigo) {
        this.codigo = codigo;
    }

    public JButton getProdutoUpdateButton() {
        return produtoUpdateButton;
    }

    public void setProdutoUpdateButton(JButton produtoUpdateButton) {
        this.produtoUpdateButton = produtoUpdateButton;
    }

    public JButton getProdutoDeleteButton() {
        return produtoDeleteButton;
    }

    public void setProdutoDeleteButton(JButton produtoDeleteButton) {
        this.produtoDeleteButton = produtoDeleteButton;
    }

    public JTextField getNomeUpdate() {
        return nomeUpdate;
    }

    public void setNomeUpdate(JTextField nomeUpdate) {
        this.nomeUpdate = nomeUpdate;
    }

    public JTextField getDescricaoUpdate() {
        return descricaoUpdate;
    }

    public void setDescricaoUpdate(JTextField descricaoUpdate) {
        this.descricaoUpdate = descricaoUpdate;
    }

    public JTextField getPesoUpdate() {
        return pesoUpdate;
    }

    public void setPesoUpdate(JTextField pesoUpdate) {
        this.pesoUpdate = pesoUpdate;
    }

    public JTextField getCorUpdate() {
        return corUpdate;
    }

    public void setCorUpdate(JTextField corUpdate) {
        this.corUpdate = corUpdate;
    }

    public JTextField getAlturaUpdate() {
        return alturaUpdate;
    }

    public void setAlturaUpdate(JTextField alturaUpdate) {
        this.alturaUpdate = alturaUpdate;
    }

    public JTextField getLarguraUpdate() {
        return larguraUpdate;
    }

    public void setLarguraUpdate(JTextField larguraUpdate) {
        this.larguraUpdate = larguraUpdate;
    }

    public JTextField getCodigoUpdate() {
        return codigoUpdate;
    }

    public void setCodigoUpdate(JTextField codigoUpdate) {
        this.codigoUpdate = codigoUpdate;
    }
}
