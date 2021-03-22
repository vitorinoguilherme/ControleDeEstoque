import controllers.ControllerHomePage;
import data.ProdutoGateway;
import views.HomePage;

public class App {
    public static void main(String[] args) {
        // Assemble all the pieces of the MVC
        ProdutoGateway pg = new ProdutoGateway();
        HomePage view = new HomePage("Gerenciador de Estoque");
        ControllerHomePage controller = new ControllerHomePage(view, pg);
        controller.initController();
    }


//    public static void main(String[] args) {
//        JFrame frame = new example("Gerenciador de Estoque");
//        frame.setVisible(true);
//    }



}
