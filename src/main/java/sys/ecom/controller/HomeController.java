package sys.ecom.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import sys.ecom.components.AmountLengthSlider;
import sys.ecom.components.Brand;
import sys.ecom.components.Catgory;
import sys.ecom.components.Item;
import sys.ecom.components.ItemImageUrl;
import sys.ecom.components.Menu;
import sys.ecom.components.SubCategory;
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
            catgory.setTargetId("link" + i);
            catgory.setTergetLink("#" + catgory.getTargetId());
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

        List<Item> items = new ArrayList<Item>();
        Item item = new Item();
        item.setName("E-SHOPPER");
        item.setTagLine("Free E-Commerce Template");
        item.setDescription("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
        item.setBtnText("Get it now");
        item.setPriceTagImageUrl("/resources/images/home/pricing.png");
        item.setImageUrls(Arrays.asList(new ItemImageUrl("/resources/images/home/girl1.jpg")));
        items.add(item);

        Item item1 = new Item();
        item1.setName("E-SHOPPER");
        item1.setTagLine("Free E-Commerce Template");
        item1.setDescription("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
        item1.setBtnText("Get it now");
        item1.setPriceTagImageUrl("/resources/images/home/pricing.png");
        item1.setImageUrls(Arrays.asList(new ItemImageUrl("/resources/images/home/girl2.jpg")));
        items.add(item1);

        Item item2 = new Item();
        item2.setName("E-SHOPPER");
        item2.setTagLine("Free E-Commerce Template");
        item2.setDescription("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
        item2.setBtnText("Get it now");
        item2.setPriceTagImageUrl("/resources/images/home/pricing.png");
        item2.setImageUrls(Arrays.asList(new ItemImageUrl("/resources/images/home/girl3.jpg")));
        items.add(item2);

        Item item3 = new Item();
        item3.setName("E-SHOPPER");
        item3.setTagLine("Free E-Commerce Template");
        item3.setDescription("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
        item3.setBtnText("Get it now");
        item3.setPriceTagImageUrl("/resources/images/home/pricing.png");
        item3.setImageUrls(Arrays.asList(new ItemImageUrl("/resources/images/home/girl3.jpg")));
        items.add(item3);

//		view.addObject("items", null);
        view.addObject("items", items);

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
