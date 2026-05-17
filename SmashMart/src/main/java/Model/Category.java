package Model;

/**
 * Represents a Category in the SmashMart system.
 * 
 * This class is used to group products into different categories
 * such as rackets, shuttlecocks, accessories, etc.
 * It helps in organizing and filtering products.
 */
public class Category {

    /** Unique identifier for the category */
    private Integer categoryID;

    /** Name of the category */
    private String categoryName;

    /**
     * Default constructor for Category.
     */
    public Category() {
    }

    /**
     * Parameterized constructor for Category.
     * 
     * @param categoryID unique ID of the category
     * @param categoryName name of the category
     */
    public Category(Integer categoryID, String categoryName) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
    }

    /**
     * Gets the category ID.
     * 
     * @return category ID
     */
    public Integer getCategoryID() {
        return categoryID;
    }

    /**
     * Sets the category ID.
     * 
     * @param categoryID unique identifier of category
     */
    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }

    /**
     * Gets the category name.
     * 
     * @return category name
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * Sets the category name.
     * 
     * @param categoryName name of category
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}