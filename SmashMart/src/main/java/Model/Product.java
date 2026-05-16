package Model;
import java.sql.Timestamp;

public class Product {
    private Integer productID;
    private String name;
    private String description;
    private Double price;
    private Integer categoryID;
    private String brand;
    private String image;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Product() {}
    public Product(Integer productID, String name, String brand, String description,
                   Double price, String image, int categoryID) {
        this.productID = productID;
        this.name = name;
        this.brand = brand;
        this.description = description;
        this.price = price;
        this.image = image;
        this.categoryID=categoryID;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
