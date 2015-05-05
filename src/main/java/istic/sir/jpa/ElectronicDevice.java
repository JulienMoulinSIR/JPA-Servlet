package istic.sir.jpa;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

@Entity
@DiscriminatorColumn(name="ElectronicDevice")
public class ElectronicDevice extends Device {
	
	private int height;
	private int width;
	private int lenght;
	
	public ElectronicDevice() {
		super();
	}

	public ElectronicDevice(int consumption_avg, int height, int width, int lenght) {
		super(consumption_avg);
		this.height = height;
		this.width = width;
		this.lenght = lenght;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getLenght() {
		return lenght;
	}

	public void setLenght(int lenght) {
		this.lenght = lenght;
	}


}
