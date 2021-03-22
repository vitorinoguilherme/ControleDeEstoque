package controllers;

import views.HomePage;

import javax.swing.*;

public class Fornecedor {
    private HomePage homePage;

    public Fornecedor(HomePage homePage) {
        this.homePage = homePage;
    }

    public void initView() {

    }

    public void initFornecedor() {
        int count = 0;
        for (JButton button: homePage.getFornecedoresButtons()) {
            int finalCount = count;
            button.addActionListener(actionEvent -> switching(finalCount));
            count++;
        }
    }

    private void switching(int count) {
        if (count == 0) {
            homePage.setAllVisibleFalse();
            homePage.getBody().add(homePage.getFornGetAll());
            homePage.getFornGetAll().setVisible(true);
        } else if (count == 1) {
            homePage.setAllVisibleFalse();
            homePage.getBody().add(homePage.getFornCreate());
            homePage.getFornCreate().setVisible(true);
        } else if (count == 2) {
            homePage.setAllVisibleFalse();
            homePage.getBody().add(homePage.getFornUpdate());
            homePage.getFornUpdate().setVisible(true);
        } else if (count == 3) {
            homePage.setAllVisibleFalse();
            homePage.getBody().add(homePage.getFornDelete());
            homePage.getFornDelete().setVisible(true);
        }
    }
}
