package Model;
import java.sql.Timestamp;



public class OrderItem {
    private Integer orderItemID;
    private Integer orderID;
    private Integer productID;
    private Integer quantity;
    private Double subtotal;
    private Timestamp createdAt;

    public OrderItem() {}
    public Integer getOrderItemID() {
        return orderItemID;
    }

    public void setOrderItemID(Integer orderItemID) {
        this.orderItemID = orderItemID;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
