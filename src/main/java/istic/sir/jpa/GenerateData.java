package istic.sir.jpa;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateData {
	
	@SuppressWarnings("deprecation")
	public List<Person> generatePersons() {
		List<Person> persons = new ArrayList<Person>();
		
		Person p1 = new Person();
		p1.setFirstName("Andre");
		p1.setLastName("Villeneuve");
		p1.setGender("Homme");
		p1.setEmail("AndreVilleneuve@teleworm.us");
		p1.setBirthday(new Date(1958, 9, 27));
		p1.setFbProfil("AndreVilleneuve");
		persons.add(p1);
		
		Person p2 = new Person();
		p2.setFirstName("Claire");
		p2.setLastName("Leduc");
		p2.setGender("Femme");
		p2.setEmail("ClaireLeduc@teleworm.us");
		p2.setBirthday(new Date(1990, 5, 14));
		p2.setFbProfil("ClaireLeduc");
		persons.add(p2);
		
		Person p3 = new Person();
		p3.setFirstName("Paul");
		p3.setLastName("Clement");
		p3.setGender("Homme");
		p3.setEmail("PaulClement@armyspy.com");
		p3.setBirthday(new Date(1988, 11, 21));
		p3.setFbProfil("PaulClement");
		persons.add(p3);
		
		
		return persons; 
	}
	
	public List<Home> generateHomes() {
		List<Home> homes = new ArrayList<Home>();
		
		Home h1 = new Home();
		h1.setNbRoom(4);
		h1.setSurface(80);
		h1.setAddress("40, rue Descartes. 67100 STRASBOURG");
		h1.setIPaddress("125.152.192.2");
		h1.addEquipment(generateElectronicDevice());
		h1.addEquipment(generateElectronicDevice());
		h1.addEquipment(generateHeater());
		homes.add(h1);
		
		Home h2 = new Home();
		h2.setNbRoom(3);
		h2.setSurface(63);
		h2.setAddress("23, rue de Penthièvre. 07000 PRIVAS");
		h2.setIPaddress("172.65.2.11");
		h2.addEquipment(generateElectronicDevice());
		h2.addEquipment(generateHeater());
		homes.add(h2);
		
		return homes; 
	}
	
	public Heater generateHeater() {
		Heater h = new Heater();
		h.setConsumption_avg(new Random().nextInt(3800)+200);
		
		switch(new Random().nextInt(5)){
			case 0:
				h.setEnergyClass('A');
				break;
			case 1:
				h.setEnergyClass('B');
				break;
			case 2:
				h.setEnergyClass('C');
				break;
			case 3:
				h.setEnergyClass('D');
				break;
			case 4:
				h.setEnergyClass('E');
				break;
		}
		
		if(new Random().nextInt(2) > 0){
			h.setProgrammable(true);
		} else {
			h.setProgrammable(false);
		}
		
		return h;
	}
	
	public ElectronicDevice generateElectronicDevice() {
		ElectronicDevice e = new ElectronicDevice();
		e.setConsumption_avg(new Random().nextInt(3800)+200);
		e.setHeight(new Random().nextInt(30)+5);
		e.setWidth(new Random().nextInt(30)+5);
		e.setLenght(new Random().nextInt(30)+5);
		
		return e; 
	}

}
