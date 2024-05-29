package hust.soict.ict.aims.test.screen.customer.store;

import hust.soict.ict.aims.cart.Cart;
import hust.soict.ict.aims.media.DigitalVideoDisc;
import hust.soict.ict.aims.store.Store;
import hust.soict.ict.aims.screen.customer.controller.ViewStoreController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application {
    private static Store store;

    @Override
    public void start(Stage primaryStage) throws Exception {
        final String STORE_FXML_FILE_PATH = "hust/soict/ict/aims/screen/customer/view/Store.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));

        ViewStoreController viewStoreController = new ViewStoreController(store, new Cart());
        fxmlLoader.setController(viewStoreController);

        Parent root = fxmlLoader.load();

        primaryStage.setTitle("Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        store = new Store();

        // Add some items to store here
        store.addMedia(new DigitalVideoDisc("Title 1", "Category 1", "Director 1", 100, 2.5f));
        store.addMedia(new DigitalVideoDisc("Title 2", "Category 2", "Director 2", 200, 3.5f));
        store.addMedia(new DigitalVideoDisc("Title 3", "Category 3", "Director 3", 150, 3.0f));

        launch(args);
    }
}
