package controllers;

import views.HomePage;

import javax.swing.*;

public class Encomenda {
    private HomePage homePage;

    public Encomenda(HomePage homePage) {
        this.homePage = homePage;
    }

    public void initView() {

    }

    public void initEncomenda() {
        int count = 0;
        for (JButton button: homePage.getEncomendaButtons()) {
            int finalCount = count;
            button.addActionListener(actionEvent -> switching(finalCount));
            count++;
        }
    }

    private void switching(int count) {
        if (count == 0) {
            homePage.setAllVisibleFalse();
            homePage.getBody().add(homePage.getEncoGetAll());
            homePage.getEncoGetAll().setVisible(true);
        } else if (count == 1) {
            homePage.setAllVisibleFalse();
            homePage.getBody().add(homePage.getEncoCreate());
            homePage.getEncoCreate().setVisible(true);
        } else if (count == 2) {
            homePage.setAllVisibleFalse();
            homePage.getBody().add(homePage.getEncoUpdate());
            homePage.getEncoUpdate().setVisible(true);
        } else if (count == 3) {
            homePage.setAllVisibleFalse();
            homePage.getBody().add(homePage.getEncoDelete());
            homePage.getEncoDelete().setVisible(true);
        }

    }
}
