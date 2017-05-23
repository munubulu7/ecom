package sys.ecom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import sys.ecom.menu.Menu;
import sys.ecom.menu.SubMenu;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @GetMapping("/app")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("index");
        List<Menu> menus = new ArrayList();
        for (int i = 0; i < 5; i++) {
            Menu menu = new Menu();
            menu.setName("Name" + i);
            menu.setDisplayName("DispName" + i);
            menu.setActive(i==3?false:true);
            menu.setTergetLink("#");
            menu.setSubMenus(new ArrayList<SubMenu>());
            if (i != 2) {
                for (int j = 0; j < 5; j++) {
                    SubMenu subMenu = new SubMenu();
                    subMenu.setName("Name" + j);
                    subMenu.setDisplayName("DispSubMenuName" + j);
                    subMenu.setActive(i==j?false:true);
                    subMenu.setTergetLink("#");
                    menu.getSubMenus().add(subMenu);
                }
            }
            menus.add(menu);
        }
        view.addObject("menus", menus);
        return view;
    }

    @ExceptionHandler(Exception.class)
    public String error404(Exception e) {
        return "404";
    }
}
