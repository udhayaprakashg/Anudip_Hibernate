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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name="class1")
public class Class1 {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="class1_id")
	private int id;
	
	private String name;

	@ManyToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(
			name="class_1_2",
			joinColumns = @JoinColumn(name = "class1_id"),
			inverseJoinColumns= @JoinColumn(name="class2_id")
			)
	private Set<Class2> class2 = new HashSet<>();
	
	
	public void addClass2(Class2 class2) {
		this.class2.add(class2);
	}
	
	
	//Getter and Setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	//Constructor
	public Class1(String name) {
		super();
		this.name = name;
	}

	public Class1() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
