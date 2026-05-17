package Model;

import java.sql.Timestamp;

/**
 * Represents a Product in the SmashMart system.
 * 
 * This class stores product-related information such as name,
 * brand, description, price, category, image, and timestamps.
 * It is used to transfer product data between DAO, Servlets, and views (JSP).
 */
public class Product {

    /** Unique identifier for the product */
    private Integer productID;

    /** Name of the product */
    private String name;

    /** Description of the product */
    private String description;

    /** Price of the product */
    private Double price;

    /** Category ID associated with the product */
    private Integer categoryID;

    /** Brand of the product */
    private String brand;

    /** Image path or filename for the product */
    private String image;

    /** Timestamp when the product was created */
    private Timestamp createdAt;

    /** Timestamp when the product was last updated */
    private Timestamp updatedAt;

    /**
     * Default constructor for Product.
     */
    public Product() {}

    /**
     * Parameterized constructor for Product.
     * 
     * @param productID ID of the product
     * @param name name of the product
     * @param brand brand of the product
     * @param description description of the product
     * @param price price of the product
     * @param image image path of the product
     * @param categoryID category ID of the product
     */
    public Product(Integer productID, String name, String brand, String description,
                   Double price, String image, int categoryID) {
        this.productID = productID;
        this.name = name;
        this.brand = brand;
        this.description = description;
        this.price = price;
        this.image = image;
        this.categoryID = categoryID;
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
     * @param productID unique identifier of product
     */
    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    /**
     * Gets the product name.
     * 
     * @return product name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the product name.
     * 
     * @param name name of product
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the product description.
     * 
     * @return product description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the product description.
     * 
     * @param description description of product
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the product price.
     * 
     * @return product price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Sets the product price.
     * 
     * @param price price of product
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Gets the category ID.
     * 
     * @return category ID of product
     */
    public Integer getCategoryID() {
        return categoryID;
    }

    /**
     * Sets the category ID.
     * 
     * @param categoryID category ID
     */
    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }

    /**
     * Gets the product brand.
     * 
     * @return brand name
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Sets the product brand.
     * 
     * @param brand brand name
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Gets the product image path.
     * 
     * @return image path
     */
    public String getImage() {
        return image;
    }

    /**
     * Sets the product image path.
     * 
     * @param image image filename or path
     */
    public void setImage(String image) {
        this.image = image;
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
     * @param createdAt creation time
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
     * @param updatedAt last update time
     */
    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}