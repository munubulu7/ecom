package sys.ecom.components;

import java.util.List;

/**
 * Created by My System on 5/23/2017.
 */
public class Menu {
    private String name;
    private String displayName;
    private String tergetLink;
    private boolean isActive;
    private List<SubMenu> subMenus;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getTergetLink() {
        return tergetLink;
    }

    public void setTergetLink(String tergetLink) {
        this.tergetLink = tergetLink;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<SubMenu> getSubMenus() {
        return subMenus;
    }

    public void setSubMenus(List<SubMenu> subMenus) {
        this.subMenus = subMenus;
    }
}
