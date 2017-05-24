package sys.ecom.components;

public class SubCategory {
	private String name;
	private String displayName;
	private String tergetLink;
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

	public String getTergetLink() {
		return tergetLink;
	}

	public void setTergetLink(String tergetLink) {
		this.tergetLink = tergetLink;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
}
