package sys.ecom.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Menus {
	@Id
    @GeneratedValue
    private long id;
    private String name;
    private String displayName;
    private String tergetLink;
    private boolean isActive;
    
    @OneToMany(mappedBy = "menus", cascade = CascadeType.ALL)
	private List<SubMenus> subMenus;

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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<SubMenus> getSubMenus() {
		return subMenus;
	}

	public void setSubMenus(List<SubMenus> subMenus) {
		this.subMenus = subMenus;
	}
}
