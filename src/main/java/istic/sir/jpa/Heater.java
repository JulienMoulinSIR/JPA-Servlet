package istic.sir.jpa;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

@Entity
@DiscriminatorColumn(name="Heater")
public class Heater extends Device {

	private boolean programmable;
	private char energyClass;
	
	public Heater() {
		super();
	}
	
	public Heater(int consumption_avg, boolean programmable, char energyClass) {
		super(consumption_avg);
		this.programmable = programmable;
		this.energyClass = energyClass;
	}

	public boolean isProgrammable() {
		return programmable;
	}

	public void setProgrammable(boolean programmable) {
		this.programmable = programmable;
	}

	public char getEnergyClass() {
		return energyClass;
	}

	public void setEnergyClass(char energyClass) {
		this.energyClass = energyClass;
	}
	
	
}
