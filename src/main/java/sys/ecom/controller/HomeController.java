package sys.ecom.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sys.ecom.bean.EntityManagerBuilder;
import sys.ecom.components.*;
import sys.ecom.test.DatatablesDemoEntity;
import sys.ecom.test.TestData;
import sys.ecom.util.DataTable;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {
	@GetMapping("/app")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("index");

		List<Menu> menus = new ArrayList<Menu>();
		for (int i = 0; i < 5; i++) {
			Menu menu = new Menu();
			menu.setName("Name" + i);
			menu.setDisplayName("DispName" + i);
			menu.setActive(i == 3 ? false : true);
			menu.setTergetLink("#");
			menu.setSubMenus(new ArrayList<SubMenu>());
			if (i != 2) {
				for (int j = 0; j < 5; j++) {
					SubMenu subMenu = new SubMenu();
					subMenu.setName("Name" + j);
					subMenu.setDisplayName("DispSubMenuName" + j);
					subMenu.setActive(i == j ? false : true);
					subMenu.setTergetLink("#");
					menu.getSubMenus().add(subMenu);
				}
			}
			menus.add(menu);
		}
		view.addObject("menus", menus);

		List<Catgory> catgories = new ArrayList<Catgory>();
		for (int i = 0; i < 5; i++) {
			Catgory catgory = new Catgory();
			catgory.setName("Name" + i);
			catgory.setDisplayName("CategoryName" + i);
			catgory.setActive(i == 3 ? false : true);
			catgory.setTargetId("link" + i);
			catgory.setTergetLink("#" + catgory.getTargetId());
			catgory.setSubCategories(new ArrayList<SubCategory>());
			catgory.setItems(new ArrayList<Item>());
			if (i != 2) {
				for (int j = 0; j < 5; j++) {
					SubCategory subCategory = new SubCategory();
					subCategory.setName("Name" + j);
					subCategory.setDisplayName("SubCatName" + j);
					subCategory.setActive(i == j ? false : true);
					subCategory.setTergetLink("#");
					catgory.getSubCategories().add(subCategory);
				}

				Item itm = new Item();
				itm.setName("Easy Polo Black Edition" + " " + i);
				itm.setPrice("Rs. 50");
				int ind;
				if (i < 4) {
					ind = i + 1;
				} else {
					ind = i % 4 + 1;
				}
				itm.setImageUrls(Arrays.asList(new ItemImageUrl("/resources/images/home/gallery" + ind + ".jpg")));
				catgory.getItems().add(itm);
			}
			catgories.add(catgory);
		}
		view.addObject("catgories", catgories);

		List<Brand> brands = new ArrayList<Brand>();
		for (int i = 0; i < 5; i++) {
			Brand brand = new Brand();
			brand.setName("Name" + i);
			brand.setDisplayName("Brand " + i);
			brand.setActive(i == 3 ? false : true);
			brand.setTergetLink("#");
			brand.setQuantity(5);

			brands.add(brand);
		}
		view.addObject("brands", brands);

		AmountLengthSlider amountLengthSlider = new AmountLengthSlider();
		amountLengthSlider.setSetMinValue(500);
		amountLengthSlider.setSetMaxValue(600);
		amountLengthSlider.setSliderMinValue(0);
		amountLengthSlider.setSliderMaxValue(600);
		view.addObject("amountLengthSlider", amountLengthSlider);

		List<Item> recommendedItems = new ArrayList<Item>();
		for (int i = 0; i < 5; i++) {
			Item recommendedItem = new Item();
			recommendedItem.setName("Easy Polo Black Edition" + " " + i);
			recommendedItem.setPrice("Rs. 50");

			int ind;
			if (i < 3) {
				ind = i + 1;
			} else {
				ind = i % 3 + 1;
			}

			recommendedItem
					.setImageUrls(Arrays.asList(new ItemImageUrl("/resources/images/home/recommend" + ind + ".jpg")));

			recommendedItems.add(recommendedItem);
		}
		view.addObject("recommendedItems", recommendedItems);

		int endVal;
		if (recommendedItems.size() > 2) {
			endVal = 2;
		} else {
			endVal = recommendedItems.size() - 1;
		}
		view.addObject("endVal", endVal);

		List<Item> featuresItems = new ArrayList<Item>();
		for (int i = 0; i < 6; i++) {
			Item featuresItem = new Item();
			featuresItem.setName("Easy Polo Black Edition" + " " + i);
			featuresItem.setPrice("Rs. 50");
			int ind = i + 1;
			featuresItem.setImageUrls(Arrays.asList(new ItemImageUrl("/resources/images/home/product" + ind + ".jpg")));
			featuresItems.add(featuresItem);
		}
		view.addObject("featuresItems", featuresItems);

		List<Item> items = new ArrayList<Item>();
		Item item = new Item();
		item.setName("E-SHOPPER");
		item.setTagLine("Free E-Commerce Template");
		item.setDescription(
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
		item.setBtnText("Get it now");
		item.setPriceTagImageUrl("/resources/images/home/pricing.png");
		item.setImageUrls(Arrays.asList(new ItemImageUrl("/resources/images/home/girl1.jpg")));
		items.add(item);

		Item item1 = new Item();
		item1.setName("E-SHOPPER");
		item1.setTagLine("Free E-Commerce Template");
		item1.setDescription(
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
		item1.setBtnText("Get it now");
		item1.setPriceTagImageUrl("/resources/images/home/pricing.png");
		item1.setImageUrls(Arrays.asList(new ItemImageUrl("/resources/images/home/girl2.jpg")));
		items.add(item1);

		Item item2 = new Item();
		item2.setName("E-SHOPPER");
		item2.setTagLine("Free E-Commerce Template");
		item2.setDescription(
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
		item2.setBtnText("Get it now");
		item2.setPriceTagImageUrl("/resources/images/home/pricing.png");
		item2.setImageUrls(Arrays.asList(new ItemImageUrl("/resources/images/home/girl3.jpg")));
		items.add(item2);

		Item item3 = new Item();
		item3.setName("E-SHOPPER");
		item3.setTagLine("Free E-Commerce Template");
		item3.setDescription(
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
		item3.setBtnText("Get it now");
		item3.setPriceTagImageUrl("/resources/images/home/pricing.png");
		item3.setImageUrls(Arrays.asList(new ItemImageUrl("/resources/images/home/girl3.jpg")));
		items.add(item3);

		// view.addObject("items", null);
		view.addObject("items", items);

		return view;
	}

	@RequestMapping(value = "/jpa", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity response() {

		EntityManagerBuilder builder = new EntityManagerBuilder();
		EntityManager em = builder.buildEntityManager();
		em.getTransaction().begin();
		TypedQuery<DatatablesDemoEntity> query = em.createQuery("select c from DatatablesDemoEntity c", DatatablesDemoEntity.class);
		DataTable dataTable = new DataTable(query.getResultList(), null, null,DatatablesDemoEntity.class);
		return new ResponseEntity(dataTable, HttpStatus.OK);
	}

	@GetMapping("/datatable")
	public String dataTable() {
		return "pipeline";
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public String error404() {
		return "404";
	}

	public class ResourceNotFoundException extends RuntimeException {
		private static final long serialVersionUID = 1L;
	}
}
