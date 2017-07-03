package sys.ecom.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import sys.ecom.bean.Transaction;
import sys.ecom.components.AmountLengthSlider;
import sys.ecom.components.Brand;
import sys.ecom.components.Catgory;
import sys.ecom.components.Item;
import sys.ecom.components.ItemImageUrl;
import sys.ecom.components.Menu;
import sys.ecom.components.SubCategory;
import sys.ecom.components.SubMenu;
import sys.ecom.model.AmntLengthSlider;
import sys.ecom.model.Menus;
import sys.ecom.model.SubMenus;
import sys.ecom.portal.HomePageDesigner;
import sys.ecom.test.DatatablesDemoEntity;
import sys.ecom.util.DataTable;

@Controller
public class HomeController {
	private Transaction tn = Transaction.getInstance();

	@GetMapping("/app")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("index");

		HomePageDesigner homePageDesigner = new HomePageDesigner();

		List<Menu> menus = new ArrayList<Menu>();

		tn.begin();
		List<Menus> menus1 = tn.getAll(Menus.class);
		for (int i = 0; i < menus1.size(); i++) {
			Menus data = menus1.get(i);
			Menu menu = new Menu();
			menu.setName(data.getName());
			menu.setDisplayName(data.getDisplayName());
			menu.setActive(data.isActive());
			menu.setTergetLink("#");
			menu.setSubMenus(new ArrayList<SubMenu>());
			List<SubMenus> submenus1 = data.getSubMenus();
			for (int j = 0; j < submenus1.size(); j++) {
				SubMenus subdata = submenus1.get(j);
				SubMenu subMenu = new SubMenu();
				subMenu.setName(subdata.getName());
				subMenu.setDisplayName(subdata.getDisplayName());
				subMenu.setActive(subdata.isActive());
				subMenu.setTergetLink("#");
				menu.getSubMenus().add(subMenu);
			}
			menus.add(menu);
		}
		// for (int i = 0; i < 5; i++) {
		// Menu menu = new Menu();
		// menu.setName("Name" + i);
		// menu.setDisplayName("DispName" + i);
		// menu.setActive(i == 3 ? false : true);
		// menu.setTergetLink("#");
		// menu.setSubMenus(new ArrayList<SubMenu>());
		// if (i != 2) {
		// for (int j = 0; j < 5; j++) {
		// SubMenu subMenu = new SubMenu();
		// subMenu.setName("Name" + j);
		// subMenu.setDisplayName("DispSubMenuName" + j);
		// subMenu.setActive(i == j ? false : true);
		// subMenu.setTergetLink("#");
		// menu.getSubMenus().add(subMenu);
		// }
		// }
		// menus.add(menu);
		// }

		// view.addObject("menus", menus);
		homePageDesigner.setMenus(menus);

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
		// view.addObject("catgories", catgories);
		homePageDesigner.setCatgories(catgories);

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
		// view.addObject("brands", brands);
		homePageDesigner.setBrands(brands);

		AmountLengthSlider amountLengthSlider = new AmountLengthSlider();
		AmntLengthSlider amntLengthSlider = tn.getAll(AmntLengthSlider.class).get(0);
		amountLengthSlider.setSetMinValue(amntLengthSlider.getSetMinValue());
		amountLengthSlider.setSetMaxValue(amntLengthSlider.getSetMaxValue());
		amountLengthSlider.setSliderMinValue(amntLengthSlider.getSliderMinValue());
		amountLengthSlider.setSliderMaxValue(amntLengthSlider.getSliderMaxValue());
		// view.addObject("amountLengthSlider", amountLengthSlider);
		homePageDesigner.setAmountLengthSlider(amountLengthSlider);

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
		// view.addObject("recommendedItems", recommendedItems);
		homePageDesigner.setRecommendedItems(recommendedItems);

		List<Item> featuresItems = new ArrayList<Item>();
		for (int i = 0; i < 6; i++) {
			Item featuresItem = new Item();
			featuresItem.setName("Easy Polo Black Edition" + " " + i);
			featuresItem.setPrice("Rs. 50");
			int ind = i + 1;
			featuresItem.setImageUrls(Arrays.asList(new ItemImageUrl("/resources/images/home/product" + ind + ".jpg")));
			featuresItems.add(featuresItem);
		}
		// view.addObject("featuresItems", featuresItems);
		homePageDesigner.setFeaturesItems(featuresItems);

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
		// view.addObject("items", items);
		homePageDesigner.setItems(items);

		view.addObject("homePageDesigner", homePageDesigner);
		return view;
	}

	@RequestMapping(value = "/jpa", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity response(WebRequest webRequest) {
		Map<String, String[]> params = webRequest.getParameterMap();
		DataTable dataTable = new DataTable(params.get("length"), params.get("start"), params.get("draw"),
				params.get("column"), DatatablesDemoEntity.class);
		return new ResponseEntity(dataTable, HttpStatus.OK);
	}

	@GetMapping("/datatable")
	public String dataTable() {
		return "pipeline";
	}

	@GetMapping(value = "/insert", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String insert() {
		List<DatatablesDemoEntity> list = tn.getAll(DatatablesDemoEntity.class);
		try {
			tn.begin();
			for (int i = 0; i < 1; i++) {
				System.out.println("inserting for :" + i);
				for (DatatablesDemoEntity datatablesDemoEntity : list) {
					DatatablesDemoEntity entity = new DatatablesDemoEntity();
					entity.setAge(datatablesDemoEntity.getAge());
					entity.setFirstName(datatablesDemoEntity.getFirstName());
					entity.setEmail(datatablesDemoEntity.getEmail());
					entity.setExtn(datatablesDemoEntity.getExtn());
					entity.setLastName(datatablesDemoEntity.getLastName());
					entity.setOffice(datatablesDemoEntity.getOffice());
					entity.setPosition(datatablesDemoEntity.getPosition());
					entity.setSalary(datatablesDemoEntity.getSalary());
					entity.setSeq(datatablesDemoEntity.getSeq());
					entity.setStartDate(datatablesDemoEntity.getStartDate());
					tn.insertData(entity);
				}
			}
			tn.commit();
		} catch (Exception e) {
			tn.rollback();
			e.printStackTrace();
		}
		return "done";
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public String error404() {
		return "404";
	}

	public class ResourceNotFoundException extends RuntimeException {
		private static final long serialVersionUID = 1L;
	}
}
