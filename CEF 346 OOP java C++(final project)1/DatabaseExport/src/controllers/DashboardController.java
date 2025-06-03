package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class DashboardController {

    // Root container from Dashboard.fxml
    @FXML
    private BorderPane rootPane;
    
    // Automatically injected controller for the included NavBar.fxml
    // (For fx:include with fx:id="navBarInclude", the controller is injected as navBarIncludeController)
    @FXML
    private NavBarController navBarIncludeController;
    
    // Chat panel controls (from Dashboard.fxml)
    @FXML
    private VBox chatContainer;
    @FXML
    private TextArea chatArea;
    @FXML
    private TextField chatInput;
    @FXML
    private Button sendButton;
    
    @FXML
    public void initialize() {
        System.out.println("DashboardController initialize called");
        
        // Check if the NavBarController is injected
        if (navBarIncludeController != null) {
            System.out.println("NavBarController injected successfully.");
            // Attach event handlers for orders options with debug logging.
            navBarIncludeController.getMenuCreateOrder().setOnAction(e -> {
                System.out.println("Create Order clicked");
                loadView("/view/CreateOrder.fxml");
            });
            navBarIncludeController.getMenuUpdateOrder().setOnAction(e -> {
                System.out.println("Update Order clicked");
                loadView("/view/UpdateOrder.fxml");
            });
            navBarIncludeController.getMenuTrackShipmentsMenu().setOnAction(e -> {
                System.out.println("Track Shipments clicked");
                loadView("/view/TrackShipments.fxml");
            });
            navBarIncludeController.getSettingsIcon().setOnMouseClicked(e -> {
                System.out.println("Settings icon clicked");
                handleSettings();
            });
        } else {
            System.err.println("NavBarController not injected! Check your fx:include in Dashboard.fxml (fx:id must be 'navBarInclude') and ensure that NavBar.fxml has its own fx:controller set.");
        }
        
        // Attach event handler for chat send button
        if (sendButton != null) {
            sendButton.setOnAction(e -> {
                System.out.println("Send button clicked");
                handleSendChat();
            });
        } else {
            System.err.println("sendButton is not defined in Dashboard.fxml.");
        }
    }
    
    /**
     * Loads the specified FXML view into the center of the rootPane.
     * @param resource Path to the FXML file.
     */
    private void loadView(String resource) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(resource));
            Parent view = loader.load();
            // Debug output before setting the view.
            System.out.println("Loaded view from: " + resource);
            rootPane.setCenter(view);
        } catch (IOException ex) {
            System.err.println("Error loading view: " + resource);
            ex.printStackTrace();
        }
    }
    
    /**
     * Appends the text from chatInput into chatArea and clears chatInput.
     */
    private void handleSendChat() {
        String message = chatInput.getText().trim();
        if (!message.isEmpty()) {
            chatArea.appendText("You: " + message + "\n");
            chatInput.clear();
        }
    }
    
    /**
     * Handles a click on the settings icon.
     */
    private void handleSettings() {
        System.out.println("Settings icon clicked. Open settings dialog.");
        // Replace this with your actual settings dialog code.
    }
}
