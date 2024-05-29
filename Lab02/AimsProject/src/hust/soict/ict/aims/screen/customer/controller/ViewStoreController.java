package hust.soict.ict.aims.screen.customer.controller;

import hust.soict.ict.aims.cart.Cart;
import hust.soict.ict.aims.media.Media;
import hust.soict.ict.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class ViewStoreController {

    private Store store;
    private Cart cart;

    @FXML
    private GridPane gridPane;

    @FXML
    void btnViewCartPressed(ActionEvent event) {
        try {
            final String FXML_CART_PATH = "/hust/soict/ict/aims/screen/customer/view/Cart.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(FXML_CART_PATH));
            fxmlLoader.setController(new CartController(cart, store));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Cart");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ViewStoreController(Store store) {
        this.store = store;
    }

    public ViewStoreController(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
    }

    @FXML
    public void initialize() {
        final String FXML_ITEM_PATH = "/hust/soict/ict/aims/screen/customer/view/Item.fxml";
        int column = 0;
        int row = 1;
        for (int i = 0; i < store.getItemsInStore().size(); i++) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource(FXML_ITEM_PATH));
                Media media = store.getItemsInStore().get(i);
                ItemController itemController = new ItemController(media, cart);
                fxmlLoader.setController(itemController);
                AnchorPane anchorPane = fxmlLoader.load();
                itemController.setData(media);

                if (column == 3) {
                    column = 0;
                    row++;
                }

                gridPane.add(anchorPane, column++, row);
                GridPane.setMargin(anchorPane, new Insets(20, 10, 10, 10));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
