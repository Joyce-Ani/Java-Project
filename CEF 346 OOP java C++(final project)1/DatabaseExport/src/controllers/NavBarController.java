package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;

public class NavBarController {

    @FXML
    private Label homeLabel;
    
    @FXML
    private MenuBar navMenuBar;
    
    @FXML
    private Menu ordersMenu;
    
    @FXML
    private MenuItem menuCreateOrder;
    
    @FXML
    private MenuItem menuUpdateOrder;
    
    @FXML
    private Menu menuTrackShipmentsMenu;
    
    @FXML
    private ImageView settingsIcon;

    public MenuItem getMenuCreateOrder() {
        return menuCreateOrder;
    }
    
    public MenuItem getMenuUpdateOrder() {
        return menuUpdateOrder;
    }
    
    public Menu getMenuTrackShipmentsMenu() {
        return menuTrackShipmentsMenu;
    }
    
    public ImageView getSettingsIcon() {
        return settingsIcon;
    }
}
