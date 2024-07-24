package com.orm;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Emp {

	@Id
	private int e_id;

	private String name;

	@ManyToMany
	/*
	 * @JoinTable(name="Emp-Proj", joinColumns= {@JoinColumn(name="Emp-Id")},
	 * inverseJoinColumns= {@JoinColumn(name="Proj-Id")})
	 */
	private List<Proj> proj;

	public int getE_id() {
		return e_id;
	}

	public void setE_id(int e_id) {
		this.e_id = e_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Proj> getProj() {
		return proj;
	}

	public void setProj(List<Proj> proj) {
		this.proj = proj;
	}

	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Emp(int e_id, String name, List<Proj> proj) {
		super();
		this.e_id = e_id;
		this.name = name;
		this.proj = proj;
	}

}
