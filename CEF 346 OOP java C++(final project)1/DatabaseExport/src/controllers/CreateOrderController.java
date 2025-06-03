package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import models.Order;
import services.OrderService;

public class CreateOrderController {
    @FXML private TextField senderNameField;
    @FXML private TextField senderAddressField;
    @FXML private TextField senderPhoneField;
    @FXML private TextField senderEmailField;
    @FXML private TextField senderCountryField;
    @FXML private TextField receiverNameField;
    @FXML private TextField receiverAddressField;
    @FXML private TextField receiverPhoneField;
    @FXML private TextField receiverEmailField;
    @FXML private TextField receiverCountryField;
    @FXML private TextField weightField;
    @FXML private TextField fullDescriptionField;
    
    private OrderService orderService = new OrderService();
    
    @FXML
    private void handleSubmitOrder(ActionEvent event) {
        // Simple validation: Required fields check.
        if (senderNameField.getText().trim().isEmpty() ||
            receiverNameField.getText().trim().isEmpty() ||
            weightField.getText().trim().isEmpty()) {
            Alert validationAlert = new Alert(Alert.AlertType.WARNING);
            validationAlert.setTitle("Incomplete Fields");
            validationAlert.setHeaderText(null);
            validationAlert.setContentText("Please fill in the required fields: Sender Name, Receiver Name, and Weight.");
            validationAlert.showAndWait();
            return;
        }
      
        // Create an order with data from the form.
        Order order = new Order();
        order.setSenderFullName(senderNameField.getText());
        order.setSenderAddress(senderAddressField.getText());
        order.setSenderPhone(senderPhoneField.getText());
        order.setSenderEmail(senderEmailField.getText());
        order.setSenderCountry(senderCountryField.getText());
        order.setReceiverFullName(receiverNameField.getText());
        order.setReceiverAddress(receiverAddressField.getText());
        order.setReceiverPhone(receiverPhoneField.getText());
        order.setReceiverEmail(receiverEmailField.getText());
        order.setReceiverCountry(receiverCountryField.getText());
        order.setWeight(weightField.getText());
        order.setFullDescription(fullDescriptionField.getText());
      
        // Insert into database.
        boolean isInserted = orderService.insertOrder(order);
      
        // Alert user based on the result.
        Alert alert;
        if (isInserted) {
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Order Created");
            alert.setHeaderText(null);
            alert.setContentText("Your order has been successfully created!");
        } else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Order Creation Failed");
            alert.setHeaderText(null);
            alert.setContentText("There was a problem creating your order. Please try again.");
        }
        alert.showAndWait();
    }
    
    // Stub methods for navigation and login.
    @FXML
    private void handleCreateOrderNav(ActionEvent event) {
        // Handle navigation for Create Order (this page) if needed.
    }
    
    @FXML
    private void handleUpdateOrderNav(ActionEvent event) {
        // Navigate to Update Order view.
    }
    
    @FXML
    private void handleTrackShipmentsNav(ActionEvent event) {
        // Navigate to Track Shipments view.
    }
    
    @FXML
    private void handleLogin(ActionEvent event) {
        // Open a login dialog and after successful login change the loginButton or show user icon.
    }
}
