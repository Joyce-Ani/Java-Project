package services;

import db.DBConnection;
import models.Shipments;
import models.ShipmentEvents;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShipmentService {

    public Shipments getShipmentByTrackingNumber(String trackingNumber) {
        Shipments shipment = null;
        String sql = "SELECT * FROM orders WHERE order_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, trackingNumber);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    shipment = new Shipments();
                    shipment.setTrackingNumber(rs.getString("order_id"));
                    shipment.setSenderFullName(rs.getString("sender_full_name"));
                    shipment.setSenderAddress(rs.getString("sender_address"));
                    shipment.setSenderPhone(rs.getString("sender_phone"));
                    shipment.setSenderEmail(rs.getString("sender_email"));
                    shipment.setSenderCountry(rs.getString("sender_country"));
                    
                    shipment.setReceiverFullName(rs.getString("receiver_full_name"));
                    shipment.setReceiverAddress(rs.getString("receiver_address"));
                    shipment.setReceiverPhone(rs.getString("receiver_phone"));
                    shipment.setReceiverEmail(rs.getString("receiver_email"));
                    shipment.setReceiverCountry(rs.getString("receiver_country"));
                    
                    shipment.setWeight(rs.getString("weight"));
                    shipment.setFullDescription(rs.getString("full_description"));
                    
                    // Set a dummy status; adjust if your table has a status column.
                    shipment.setStatus("In Transit");
                    
                    // Optionally populate timeline events.
                    List<ShipmentEvents> events = new ArrayList<>();
                    events.add(new ShipmentEvents("2025-05-01 10:00", "Shipment Picked Up"));
                    events.add(new ShipmentEvents("2025-05-03 14:30", "In Transit"));
                    events.add(new ShipmentEvents("2025-05-05 09:15", "Arrived at Destination Hub"));
                    shipment.setEvents(events);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shipment;
    }
}
