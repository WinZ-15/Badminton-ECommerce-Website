package Model;

import java.sql.Timestamp;

/**
 * Represents an Order in the SmashMart system.
 * 
 * This class stores information about a user's order,
 * including the user who placed the order, order status,
 * total amount, and timestamps.
 * It is used to manage order processing and tracking.
 */
public class Order {

    /** Unique identifier for the order */
    private Integer orderID;

    /** ID of the user who placed the order */
    private Integer userID;

    /** Current status of the order (e.g., Pending, Completed) */
    private String status;

    /** Total amount of the order */
    private Double totalAmount;

    /** Timestamp when the order was created */
    private Timestamp createdAt;

    /** Timestamp when the order was last updated */
    private Timestamp updatedAt;

    /**
     * Default constructor for Order.
     */
    public Order() {}

    /**
     * Gets the order ID.
     * 
     * @return order ID
     */
    public Integer getOrderID() {
        return orderID;
    }

    /**
     * Sets the order ID.
     * 
     * @param orderID unique identifier for the order
     */
    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    /**
     * Gets the user ID.
     * 
     * @return user ID who placed the order
     */
    public Integer getUserID() {
        return userID;
    }

    /**
     * Sets the user ID.
     * 
     * @param userID ID of the user placing the order
     */
    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    /**
     * Gets the order status.
     * 
     * @return current order status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the order status.
     * 
     * @param status status of the order (e.g., Pending, Completed)
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the total order amount.
     * 
     * @return total amount of the order
     */
    public Double getTotalAmount() {
        return totalAmount;
    }

    /**
     * Sets the total order amount.
     * 
     * @param totalAmount total cost of the order
     */
    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * Gets the creation timestamp.
     * 
     * @return createdAt timestamp
     */
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the creation timestamp.
     * 
     * @param createdAt time when the order was created
     */
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets the last updated timestamp.
     * 
     * @return updatedAt timestamp
     */
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Sets the last updated timestamp.
     * 
     * @param updatedAt time when the order was last updated
     */
    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}