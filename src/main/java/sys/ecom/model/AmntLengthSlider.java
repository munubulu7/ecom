package sys.ecom.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AmntLengthSlider {
	@Id
    @GeneratedValue
    private long id;
	private double sliderMinValue;
	private double sliderMaxValue;
	private double setMinValue;
	private double setMaxValue;

	public double getSliderMinValue() {
		return sliderMinValue;
	}

	public void setSliderMinValue(double sliderMinValue) {
		this.sliderMinValue = sliderMinValue;
	}

	public double getSliderMaxValue() {
		return sliderMaxValue;
	}

	public void setSliderMaxValue(double sliderMaxValue) {
		this.sliderMaxValue = sliderMaxValue;
	}

	public double getSetMinValue() {
		return setMinValue;
	}

	public void setSetMinValue(double setMinValue) {
		this.setMinValue = setMinValue;
	}

	public double getSetMaxValue() {
		return setMaxValue;
	}

	public void setSetMaxValue(double setMaxValue) {
		this.setMaxValue = setMaxValue;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
