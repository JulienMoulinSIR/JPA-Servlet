package istic.sir.jpa;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class Device {
	
	@Id @GeneratedValue
	private long id;
	private int consumption_avg;
	
	public 	Device() {
		
	}
	
	public 	Device(int consumption_avg) {
		this.consumption_avg = consumption_avg;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getConsumption_avg() {
		return consumption_avg;
	}

	public void setConsumption_avg(int consumption_avg) {
		this.consumption_avg = consumption_avg;
	}
	
}
