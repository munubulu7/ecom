package sys.ecom.components;

public class Brand {
	private String name;
	private String displayName;
	private String tergetLink;
	private double quantity;
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

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
}
