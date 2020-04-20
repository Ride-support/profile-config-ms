package ridesupport.car.model;

import javax.persistence.*;

@Entity
@Table(name = "car")
@NamedQueries({@NamedQuery(name = Car.FIND_ALL, query = "SELECT u FROM Car u")})
public class Car {

    public static final String FIND_ALL = "Car.findAll";

    @Id
    private String plateNumber;

    private String model;
    private String brand;
    
    
	public String getPlateNumber() {
		return plateNumber;
	}
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
    
}
