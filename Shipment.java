
package com.randy.localtrack;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Shipment {
    private StringProperty orderId;
    private StringProperty productId;
    private StringProperty status;
    private StringProperty lastUpdated;

    public Shipment(String orderId, String productId, String status, String lastUpdated) {
        this.orderId = new SimpleStringProperty(orderId);
        this.productId = new SimpleStringProperty(productId);
        this.status = new SimpleStringProperty(status);
        this.lastUpdated = new SimpleStringProperty(lastUpdated);
    }

    public StringProperty orderIdProperty() { return orderId; }
    public StringProperty productIdProperty() { return productId; }
    public StringProperty statusProperty() { return status; }
    public StringProperty lastUpdatedProperty() { return lastUpdated; }

    public void setStatus(String status) { this.status.set(status); }
    public void setLastUpdated(String updated) { this.lastUpdated.set(updated); }
}
