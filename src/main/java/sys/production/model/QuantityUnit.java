package sys.production.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class QuantityUnit {
	@Id
    @GeneratedValue
    private long id;
    private String name;
    private String displayName;
    private double weightageValue;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDateTime;
    
    @ManyToOne
    @JoinColumn(name = "QtyUnitTypeId")
    @JsonIgnore
    private QuantityUnitType quantityUnitType;
    
    @OneToMany(mappedBy = "quantityUnit",cascade = CascadeType.ALL)
    private List<PackagingUnit> packagingUnits;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public double getWeightageValue() {
		return weightageValue;
	}

	public void setWeightageValue(double weightageValue) {
		this.weightageValue = weightageValue;
	}

	public Date getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public QuantityUnitType getQuantityUnitType() {
		return quantityUnitType;
	}

	public void setQuantityUnitType(QuantityUnitType quantityUnitType) {
		this.quantityUnitType = quantityUnitType;
	}

	public List<PackagingUnit> getPackagingUnits() {
		return packagingUnits;
	}

	public void setPackagingUnits(List<PackagingUnit> packagingUnits) {
		this.packagingUnits = packagingUnits;
	}
}
