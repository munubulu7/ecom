package sys.ecom.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import sys.ecom.components.Catgory;
import sys.ecom.components.SubCategory;
import sys.ecom.components.Menu;
import sys.ecom.components.SubMenu;

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
			catgory.setTergetLink("#link"+i);
			catgory.setTargetId("link"+i);
			catgory.setSubCategories(new ArrayList<SubCategory>());
			if (i != 2) {
				for (int j = 0; j < 5; j++) {
					SubCategory subCategory = new SubCategory();
					subCategory.setName("Name" + j);
					subCategory.setDisplayName("SubCatName" + j);
					subCategory.setActive(i == j ? false : true);
					subCategory.setTergetLink("#");
					catgory.getSubCategories().add(subCategory);
				}
			}
			catgories.add(catgory);
		}
		view.addObject("catgories", catgories);

		return view;
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public String error404() {
		return "404";
	}

	public class ResourceNotFoundException extends RuntimeException {
		private static final long serialVersionUID = 1L;
	}
}
