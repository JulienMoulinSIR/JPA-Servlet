package istic.sir.jpa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Person {
	
	@Id  @GeneratedValue
	private long id;
	private String firstName;
	private String lastName;
	private String gender;
	private String email;
	private Date birthday;
	private String fbProfil;
	
	@OneToMany(cascade=CascadeType.ALL)
	@Column(name="homes")
	private List<Home> homes = new ArrayList<Home>();
	
	@OneToMany(cascade=CascadeType.ALL)
	@Column(name="friends")
	private List<Person> friends = new ArrayList<Person>();
	
	public Person() {
		
	}
	
	public Person(String firstName, String lastName, String gender, String email, Date birthday, String fbProfil) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.birthday = birthday;
		this.fbProfil = fbProfil;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getFbProfil() {
		return fbProfil;
	}

	public void setFbProfil(String fbProfil) {
		this.fbProfil = fbProfil;
	}

	public List<Home> getHomes() {
		return homes;
	}

	public void setHomes(List<Home> homes) {
		this.homes = homes;
	}

	public List<Person> getFriends() {
		return friends;
	}

	public void setFriends(List<Person> friends) {
		this.friends = friends;
	}

}