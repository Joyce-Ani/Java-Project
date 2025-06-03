package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import models.Order;
import services.OrderService;

public class UpdateOrderController {

    // fx:id fields for your controls (make sure they match your FXML)
    @FXML
    private TextField orderIdField;
    // ... other fields for sender, receiver, etc.

    private OrderService orderService = new OrderService();

    @FXML
    private void handleUpdateOrder(ActionEvent event) {
        // Validate required fields and perform the update logic.
        if(orderIdField.getText().trim().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Incomplete Fields");
            alert.setHeaderText(null);
            alert.setContentText("Order ID is required.");
            alert.showAndWait();
            return;
        }
        
        // Create an Order object from the form's input.
        Order order = new Order();
        order.setOrderId(orderIdField.getText().trim());
        // ... set other order details
        
        boolean isUpdated = orderService.updateOrder(order);
        Alert alert;
        if(isUpdated) {
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Order Updated");
            alert.setHeaderText(null);
            alert.setContentText("The order was successfully updated!");
        } else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Update Failed");
            alert.setHeaderText(null);
            alert.setContentText("There was a problem updating the order. Please try again.");
        }
        alert.showAndWait();
    }
}
