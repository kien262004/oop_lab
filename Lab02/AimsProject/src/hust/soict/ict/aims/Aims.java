package hust.soict.ict.aims;

import hust.soict.ict.aims.cart.Cart;
import hust.soict.ict.aims.screen.customer.controller.ViewStoreController;
import hust.soict.ict.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

public class Aims extends Application {
    private static Store store;
    private static Cart cart;

    @Override
    public void start(Stage primaryStage) throws Exception {
        cart = new Cart();
        store = new Store();
        store.initData();
        FXMLLoader loader = new FXMLLoader();
        Parent root = null;
        // exception for load loader
        try {
            loader.setLocation(getClass().getResource("/hust/soict/ict/aims/screen/customer/view/Store.fxml"));
            ViewStoreController viewStoreController = new ViewStoreController(store, cart);
            loader.setController(viewStoreController);
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("AIMS Store");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
