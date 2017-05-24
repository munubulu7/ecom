package sys.ecom.components;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by My System on 5/24/2017.
 */
public class Item {
    private String name;
    private String description;
    private String availability;
    private String condition;
    private String brand;
    private String price;
    private List<ItemImageUrl> imageUrls = new ArrayList<ItemImageUrl>();

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

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<ItemImageUrl> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<ItemImageUrl> imageUrls) {
        this.imageUrls = imageUrls;
    }
}
