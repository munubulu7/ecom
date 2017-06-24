package sys.ecom.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SubMenus {
	@Id
    @GeneratedValue
    private long id;
	
    private String name;
    private String displayName;
    private String tergetLink;
    private boolean isActive;
    
    @ManyToOne
	private Menus menus;

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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Menus getMenus() {
		return menus;
	}

	public void setMenus(Menus menus) {
		this.menus = menus;
	}
}
