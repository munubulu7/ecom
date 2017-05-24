package sys.ecom.components;

import java.util.List;

public class Catgory {
	private String name;
	private String displayName;
	private String tergetLink;
	private String targetId;
	boolean isActive;
	private List<SubCategory> subCategories;

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

	public List<SubCategory> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(List<SubCategory> subCategories) {
		this.subCategories = subCategories;
	}

	public String getTargetId() {
		return targetId;
	}

	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}

}
