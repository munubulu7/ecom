package sys.ecom.portal;

import java.util.List;

import sys.ecom.components.AmountLengthSlider;
import sys.ecom.components.Brand;
import sys.ecom.components.Catgory;
import sys.ecom.components.Item;
import sys.ecom.components.Menu;

/**
 * Created by My System on 5/23/2017.
 */
public class HomePageDesigner {
	private List<Menu> menus;
	private List<Catgory> catgories;
	private List<Brand> brands;
	private AmountLengthSlider amountLengthSlider;
	private List<Item> recommendedItems;
	private List<Item> featuresItems;
	private List<Item> items;

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public List<Catgory> getCatgories() {
		return catgories;
	}

	public void setCatgories(List<Catgory> catgories) {
		this.catgories = catgories;
	}

	public List<Brand> getBrands() {
		return brands;
	}

	public void setBrands(List<Brand> brands) {
		this.brands = brands;
	}

	public AmountLengthSlider getAmountLengthSlider() {
		return amountLengthSlider;
	}

	public void setAmountLengthSlider(AmountLengthSlider amountLengthSlider) {
		this.amountLengthSlider = amountLengthSlider;
	}

	public List<Item> getRecommendedItems() {
		return recommendedItems;
	}

	public void setRecommendedItems(List<Item> recommendedItems) {
		this.recommendedItems = recommendedItems;
	}

	public List<Item> getFeaturesItems() {
		return featuresItems;
	}

	public void setFeaturesItems(List<Item> featuresItems) {
		this.featuresItems = featuresItems;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

}
