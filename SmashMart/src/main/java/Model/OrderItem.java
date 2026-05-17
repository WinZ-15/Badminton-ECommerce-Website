package Model;

import java.sql.Timestamp;

/**
 * Represents an item within an order in the SmashMart system.
 * 
 * Each OrderItem links a product to an order and stores
 * the quantity and subtotal for that product.
 * This class is used for processing orders and storing
 * order details in the database.
 */
public class OrderItem {

    /** Unique identifier for the order item */
    private Integer orderItemID;

    /** ID of the associated order */
    private Integer orderID;

    /** ID of the product in this order item */
    private Integer productID;

    /** Quantity of the product ordered */
    private Integer quantity;

    /** Subtotal cost for this item (price × quantity) */
    private Double subtotal;

    /** Timestamp when the order item was created */
    private Timestamp createdAt;

    /**
     * Default constructor for OrderItem.
     */
    public OrderItem() {}

    /**
     * Gets the order item ID.
     * 
     * @return order item ID
     */
    public Integer getOrderItemID() {
        return orderItemID;
    }

    /**
     * Sets the order item ID.
     * 
     * @param orderItemID unique identifier for the order item
     */
    public void setOrderItemID(Integer orderItemID) {
        this.orderItemID = orderItemID;
    }

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
     * @param orderID ID of the associated order
     */
    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    /**
     * Gets the product ID.
     * 
     * @return product ID
     */
    public Integer getProductID() {
        return productID;
    }

    /**
     * Sets the product ID.
     * 
     * @param productID ID of the product
     */
    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    /**
     * Gets the quantity of the product.
     * 
     * @return quantity ordered
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the product.
     * 
     * @param quantity number of items ordered
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets the subtotal for this order item.
     * 
     * @return subtotal amount
     */
    public Double getSubtotal() {
        return subtotal;
    }

    /**
     * Sets the subtotal amount.
     * 
     * @param subtotal total cost for this item (price × quantity)
     */
    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
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
     * @param createdAt time when order item was created
     */
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}