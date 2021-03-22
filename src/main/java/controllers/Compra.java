package controllers;

import views.HomePage;

import javax.swing.*;

public class Compra {
    private HomePage homePage;

    public Compra(HomePage homePage) {
        this.homePage = homePage;
    }

    public void initView() {

    }

    public void initCompra() {
        int count = 0;
        for (JButton button: homePage.getPurchaseButtons()) {
            int finalCount = count;
            button.addActionListener(actionEvent -> switching(finalCount));
            count++;
        }
    }

    private void switching(int count) {
        if (count == 0) {
            homePage.setAllVisibleFalse();
            homePage.getBody().add(homePage.getCompGetAll());
            homePage.getCompGetAll().setVisible(true);
        } else if (count == 1) {
            homePage.setAllVisibleFalse();
            homePage.getBody().add(homePage.getCompCreate());
            homePage.getCompCreate().setVisible(true);
        } else if (count == 2) {
            homePage.setAllVisibleFalse();
            homePage.getBody().add(homePage.getCompUpdate());
            homePage.getCompUpdate().setVisible(true);
        } else if (count == 3) {
            homePage.setAllVisibleFalse();
            homePage.getBody().add(homePage.getCompDelete());
            homePage.getCompDelete().setVisible(true);
        }
    }
}
