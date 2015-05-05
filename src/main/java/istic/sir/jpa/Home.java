package istic.sir.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Home {
	
	@Id @GeneratedValue
	private long id;
	private int nbRoom;
	private int surface;
	private String address;
	private String IPaddress;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Device> equipments = new ArrayList<Device>();
	
	public Home() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNbRoom() {
		return nbRoom;
	}

	public void setNbRoom(int nbRoom) {
		this.nbRoom = nbRoom;
	}

	public int getSurface() {
		return surface;
	}

	public void setSurface(int surface) {
		this.surface = surface;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIPaddress() {
		return IPaddress;
	}

	public void setIPaddress(String iPaddress) {
		IPaddress = iPaddress;
	}

	public List<Device> getEquipments() {
		return equipments;
	}

	public void setEquipments(List<Device> equipments) {
		this.equipments = equipments;
	}
	
	public void addEquipment(Device device) {
		this.equipments.add(device);
	}

	
}