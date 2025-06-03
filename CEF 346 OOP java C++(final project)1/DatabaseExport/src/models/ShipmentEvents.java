package models;

public class ShipmentEvents {
    private String time;
    private String eventDescription;

    public ShipmentEvents() {
    }

    public ShipmentEvents(String time, String eventDescription) {
        this.time = time;
        this.eventDescription = eventDescription;
    }

    // Getters and Setters
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getEventDescription() {
        return eventDescription;
    }
    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }
}
