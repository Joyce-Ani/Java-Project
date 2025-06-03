package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import models.Shipments;
import models.ShipmentEvents;
import services.ShipmentService;

public class TrackShipmentsController {

    @FXML
    private TextField trackingNumberField;
    
    @FXML
    private Label senderLabel;
    @FXML
    private Label receiverLabel;
    @FXML
    private Label estimatedDeliveryLabel;
    @FXML
    private Label statusLabel;
    
    @FXML
    private TableView<ShipmentEvents> timelineTable;
    @FXML
    private TableColumn<ShipmentEvents, String> timeColumn;
    @FXML
    private TableColumn<ShipmentEvents, String> eventColumn;
    
    @FXML
    private ImageView mapImageView;
    
    @FXML
    private Accordion trackingAccordion;
    
    // Query shipment information from the database.
    private ShipmentService shipmentService = new ShipmentService();
    
    @FXML
    private void handleTrackShipment(ActionEvent event) {
        String orderId = trackingNumberField.getText().trim();
        if (orderId.isEmpty()) {
            System.out.println("Order ID is required.");
            return;
        }
        
        Shipments shipment = shipmentService.getShipmentByTrackingNumber(orderId);
        if (shipment != null) {
            senderLabel.setText(shipment.getSender());
            receiverLabel.setText(shipment.getReceiver());
            estimatedDeliveryLabel.setText(shipment.getEstimatedDelivery());
            statusLabel.setText(shipment.getStatus());
            
            ObservableList<ShipmentEvents> events = FXCollections.observableArrayList(shipment.getEvents());
            timelineTable.setItems(events);
            timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
            eventColumn.setCellValueFactory(new PropertyValueFactory<>("eventDescription"));
            
            // Optionally update mapImageView—for instance, by loading an image URL based on shipment data.
        } else {
            senderLabel.setText("Not Found");
            receiverLabel.setText("Not Found");
            estimatedDeliveryLabel.setText("Not Found");
            statusLabel.setText("Not Found");
            timelineTable.setItems(null);
        }
    }
}
