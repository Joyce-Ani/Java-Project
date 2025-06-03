package services;

import db.DBConnection;
import models.Order;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderService {

    public boolean insertOrder(Order order) {
        boolean success = false;
        String sql = "INSERT INTO orders (" +
                     "sender_full_name, sender_address, sender_phone, sender_email, sender_country, " +
                     "receiver_full_name, receiver_address, receiver_phone, receiver_email, receiver_country, " +
                     "weight, full_description" +
                     ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, order.getSenderFullName());
            pstmt.setString(2, order.getSenderAddress());
            pstmt.setString(3, order.getSenderPhone());
            pstmt.setString(4, order.getSenderEmail());
            pstmt.setString(5, order.getSenderCountry());
            pstmt.setString(6, order.getReceiverFullName());
            pstmt.setString(7, order.getReceiverAddress());
            pstmt.setString(8, order.getReceiverPhone());
            pstmt.setString(9, order.getReceiverEmail());
            pstmt.setString(10, order.getReceiverCountry());
            pstmt.setBigDecimal(11, new BigDecimal(order.getWeight()));
            pstmt.setString(12, order.getFullDescription());

            int rowsAffected = pstmt.executeUpdate();
            success = (rowsAffected > 0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }
    
    public boolean updateOrder(Order order) {
        boolean success = false;
        // Assumes your orders table has a primary key column "order_id"
        String sql = "UPDATE orders SET " +
                     "sender_full_name = ?, sender_address = ?, sender_phone = ?, sender_email = ?, sender_country = ?, " +
                     "receiver_full_name = ?, receiver_address = ?, receiver_phone = ?, receiver_email = ?, receiver_country = ?, " +
                     "weight = ?, full_description = ? " +
                     "WHERE order_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, order.getSenderFullName());
            pstmt.setString(2, order.getSenderAddress());
            pstmt.setString(3, order.getSenderPhone());
            pstmt.setString(4, order.getSenderEmail());
            pstmt.setString(5, order.getSenderCountry());
            pstmt.setString(6, order.getReceiverFullName());
            pstmt.setString(7, order.getReceiverAddress());
            pstmt.setString(8, order.getReceiverPhone());
            pstmt.setString(9, order.getReceiverEmail());
            pstmt.setString(10, order.getReceiverCountry());
            pstmt.setBigDecimal(11, new BigDecimal(order.getWeight()));
            pstmt.setString(12, order.getFullDescription());
            pstmt.setString(13, order.getOrderId());

            int rowsAffected = pstmt.executeUpdate();
            success = (rowsAffected > 0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }
}
