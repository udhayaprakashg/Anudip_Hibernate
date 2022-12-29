package com.udhaya;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="class2")
public class Class2 {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="class2_id")
	private int id;
	
	private String city;

	
	@ManyToMany(mappedBy="class2",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Class1> class1 = new HashSet<>();
	
	
	//Set add method
	
	public void addClass1(Class1 class1) {
		this.class1.add(class1);
	}
	
	//Getter and Setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	
	//Constructor
	public Class2(String city) {
		super();
		this.city = city;
	}

	public Class2() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
