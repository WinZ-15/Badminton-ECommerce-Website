package Model;

/**
 * Represents an item in the shopping cart.
 * 
 * A CartItem consists of a product and the quantity selected
 * by the user. It is used to manage cart operations such as
 * adding products, updating quantities, and calculating totals.
 */
public class CartItem {

    /** The product included in the cart item */
    private Product product;

    /** Quantity of the product selected */
    private int quantity;

    /**
     * Parameterized constructor for CartItem.
     * 
     * @param product the product being added to the cart
     * @param quantity quantity of the product
     */
    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * Gets the product associated with this cart item.
     * 
     * @return product object
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Gets the quantity of the product.
     * 
     * @return quantity of product
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the product for this cart item.
     * 
     * @param product product to be set
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Sets the quantity for this cart item.
     * 
     * @param quantity number of items
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}