package ZomatoAppCollectionsFramework;

public class FoodItem {

    private int foodId;
    private String foodName;
    private String category;
    private double price;

    // Default constructor
    public FoodItem() {
    }

    // Parameterized constructor
    public FoodItem(int foodId, String foodName,
                    String category, double price) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.category = category;
        this.price = price;
    }

    // Getter and Setter for foodId
    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    // Getter and Setter for foodName
    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    // Getter and Setter for category
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // Getter and Setter for price
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // toString method
    @Override
    public String toString() {
        return "FoodItem [foodId=" + foodId
                + ", foodName=" + foodName
                + ", category=" + category
                + ", price=" + price + "]";
    }
}
