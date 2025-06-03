package models;

import java.util.List;

public class Shipments {
    private String trackingNumber;
    
    private String senderFullName;
    private String senderAddress;
    private String senderPhone;
    private String senderEmail;
    private String senderCountry;
    
    private String receiverFullName;
    private String receiverAddress;
    private String receiverPhone;
    private String receiverEmail;
    private String receiverCountry;
    
    private String weight;
    private String fullDescription;
    
    // Additional fields for tracking
    private String status;
    private List<ShipmentEvents> events;
    
    public Shipments() {
    }
    
    // Getters and Setters
    public String getTrackingNumber() {
        return trackingNumber;
    }
    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }
    
    public String getSenderFullName() {
        return senderFullName;
    }
    public void setSenderFullName(String senderFullName) {
        this.senderFullName = senderFullName;
    }
    
    public String getSenderAddress() {
        return senderAddress;
    }
    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }
    
    public String getSenderPhone() {
        return senderPhone;
    }
    public void setSenderPhone(String senderPhone) {
        this.senderPhone = senderPhone;
    }
    
    public String getSenderEmail() {
        return senderEmail;
    }
    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }
    
    public String getSenderCountry() {
        return senderCountry;
    }
    public void setSenderCountry(String senderCountry) {
        this.senderCountry = senderCountry;
    }
    
    public String getReceiverFullName() {
        return receiverFullName;
    }
    public void setReceiverFullName(String receiverFullName) {
        this.receiverFullName = receiverFullName;
    }
    
    public String getReceiverAddress() {
        return receiverAddress;
    }
    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }
    
    public String getReceiverPhone() {
        return receiverPhone;
    }
    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }
    
    public String getReceiverEmail() {
        return receiverEmail;
    }
    public void setReceiverEmail(String receiverEmail) {
        this.receiverEmail = receiverEmail;
    }
    
    public String getReceiverCountry() {
        return receiverCountry;
    }
    public void setReceiverCountry(String receiverCountry) {
        this.receiverCountry = receiverCountry;
    }
    
    public String getWeight() {
        return weight;
    }
    public void setWeight(String weight) {
        this.weight = weight;
    }
    
    public String getFullDescription() {
        return fullDescription;
    }
    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }
    
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
    public List<ShipmentEvents> getEvents() {
        return events;
    }
    public void setEvents(List<ShipmentEvents> events) {
        this.events = events;
    }
    
    // Convenience methods for tracking display:
    public String getSender() {
        return senderFullName;
    }
    public String getReceiver() {
        return receiverFullName;
    }
    public String getEstimatedDelivery() {
        // For demonstration, return a hard-coded date.
        return "2025-06-07";
    }
}
