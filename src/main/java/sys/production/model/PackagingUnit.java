package sys.production.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PackagingUnit {
	@Id
    @GeneratedValue
    private long id;
    private String name;
    private String displayName;
    private double QtyUnitValue;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDateTime;
    
    @ManyToOne
    @JoinColumn(name = "QtyUnitId")
    @JsonIgnore
    private QuantityUnit quantityUnit;

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

	public double getQtyUnitValue() {
		return QtyUnitValue;
	}

	public void setQtyUnitValue(double qtyUnitValue) {
		QtyUnitValue = qtyUnitValue;
	}

	public Date getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public QuantityUnit getQuantityUnit() {
		return quantityUnit;
	}

	public void setQuantityUnit(QuantityUnit quantityUnit) {
		this.quantityUnit = quantityUnit;
	}
}
