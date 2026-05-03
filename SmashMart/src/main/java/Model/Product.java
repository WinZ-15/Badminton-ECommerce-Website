package Model;

public class Product {
    private Integer productID;
    private String name;
    private String description;
    private Double price;
    private Integer stock;
    private Integer categoryID;
    private String brand;  
    private int userId;
    private String image;


    public Product(Integer productID, String name, String brand, String description,
                   Double price, String image, int userId) {
        this.productID = productID;
        this.name = name;
        this.brand = brand;
        this.description = description;
        this.price = price;
        this.image = image;
        this.userId = userId;
    }

 
    public Product() {}

 
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

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
