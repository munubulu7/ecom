package sys.production.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class QuantityUnitType {
	@Id
    @GeneratedValue
    private long id;
    private String type;
    private String displayName;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDateTime;
    
    @OneToMany(mappedBy = "quantityUnitType",cascade = CascadeType.ALL)
    private List<QuantityUnit> quantityUnits;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Date getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public List<QuantityUnit> getQuantityUnits() {
		return quantityUnits;
	}

	public void setQuantityUnits(List<QuantityUnit> quantityUnits) {
		this.quantityUnits = quantityUnits;
	}
}
