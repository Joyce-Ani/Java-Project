package javafxapp;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class OrderApp extends Application {

    private TextField orderIdField, destinationField, productField, quantityField, priceField;
    private TextArea displayArea;

    private Map<String, ExportOrder> orders = new HashMap<>();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Export Order System");

        Label lblOrderId = new Label("Order ID (for Update):");
        orderIdField = new TextField();

        Label lblDestination = new Label("Destination:");
        destinationField = new TextField();

        Label lblProduct = new Label("Product Description:");
        productField = new TextField();

        Label lblQuantity = new Label("Quantity:");
        quantityField = new TextField();

        Label lblPrice = new Label("Price:");
        priceField = new TextField();

        Button createBtn = new Button("Create Order");
        Button updateBtn = new Button("Update Order");

        displayArea = new TextArea();
        displayArea.setEditable(false);
        displayArea.setPrefHeight(200);

        createBtn.setOnAction(e -> createOrder());
        updateBtn.setOnAction(e -> updateOrder());

        GridPane formGrid = new GridPane();
        formGrid.setPadding(new Insets(10));
        formGrid.setHgap(10);
        formGrid.setVgap(10);

        formGrid.add(lblOrderId, 0, 0);
        formGrid.add(orderIdField, 1, 0);
        formGrid.add(lblDestination, 0, 1);
        formGrid.add(destinationField, 1, 1);
        formGrid.add(lblProduct, 0, 2);
        formGrid.add(productField, 1, 2);
        formGrid.add(lblQuantity, 0, 3);
        formGrid.add(quantityField, 1, 3);
        formGrid.add(lblPrice, 0, 4);
        formGrid.add(priceField, 1, 4);
        formGrid.add(createBtn, 0, 5);
        formGrid.add(updateBtn, 1, 5);

        VBox layout = new VBox(10, formGrid, displayArea);
        layout.setPadding(new Insets(15));

        Scene scene = new Scene(layout, 450, 450);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void createOrder() {
        try {
            String id = UUID.randomUUID().toString().substring(0, 8);
            String dest = destinationField.getText();
            String prod = productField.getText();
            int qty = Integer.parseInt(quantityField.getText());
            double price = Double.parseDouble(priceField.getText());

            ExportOrder order = new ExportOrder(id, dest, prod, qty, price);
            orders.put(id, order);
            displayArea.setText("Order Created:\n" + order.toString());
            orderIdField.setText(id);
        } catch (NumberFormatException e) {
            displayArea.setText("Invalid quantity or price!");
        }
    }

    private void updateOrder() {
        String id = orderIdField.getText();
        if (!orders.containsKey(id)) {
            displayArea.setText("Order ID not found.");
            return;
        }

        try {
            String dest = destinationField.getText();
            String prod = productField.getText();
            int qty = Integer.parseInt(quantityField.getText());
            double price = Double.parseDouble(priceField.getText());

            ExportOrder order = orders.get(id);
            order.update(dest, prod, qty, price);
            displayArea.setText("Order Updated:\n" + order.toString());
        } catch (NumberFormatException e) {
            displayArea.setText("Invalid quantity or price!");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}