package sys.ecom.menu;

/**
 * Created by My System on 5/23/2017.
 */
public class SubMenu {
    String name;
    String displayName;
    String tergetLink;
    boolean isActive;

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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getTergetLink() {
        return tergetLink;
    }

    public void setTergetLink(String tergetLink) {
        this.tergetLink = tergetLink;
    }
}
