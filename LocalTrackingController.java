
package com.randy.localtrack;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalTrackingController {

    @FXML private TableView<Shipment> shipmentTable;
    @FXML private TableColumn<Shipment, String> colOrderId;
    @FXML private TableColumn<Shipment, String> colProductId;
    @FXML private TableColumn<Shipment, String> colStatus;
    @FXML private TableColumn<Shipment, String> colUpdated;

    private ObservableList<Shipment> shipmentList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colOrderId.setCellValueFactory(data -> data.getValue().orderIdProperty());
        colProductId.setCellValueFactory(data -> data.getValue().productIdProperty());
        colStatus.setCellValueFactory(data -> data.getValue().statusProperty());
        colUpdated.setCellValueFactory(data -> data.getValue().lastUpdatedProperty());

        shipmentList.addAll(
            new Shipment("ORD001", "P001", "Pending", getCurrentTime()),
            new Shipment("ORD002", "P002", "Shipped", getCurrentTime())
        );

        shipmentTable.setItems(shipmentList);
    }

    @FXML
    private void markAsShipped() {
        Shipment selected = shipmentTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setStatus("Shipped");
            selected.setLastUpdated(getCurrentTime());
            shipmentTable.refresh();

            //  Show notification
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Shipment Update");
            alert.setHeaderText(null);
            alert.setContentText("Order " + selected.orderIdProperty().get() + " marked as shipped.");
            alert.showAndWait();
        }
    }

    @FXML
    private void markAsDelivered() {
        Shipment selected = shipmentTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setStatus("Delivered");
            selected.setLastUpdated(getCurrentTime());
            shipmentTable.refresh();

            //  Show notification
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Shipment Update");
            alert.setHeaderText(null);
            alert.setContentText("Order " + selected.orderIdProperty().get() + " marked as delivered.");
            alert.showAndWait();
        }
    }

    private String getCurrentTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
