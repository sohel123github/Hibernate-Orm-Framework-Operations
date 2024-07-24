package com.orm;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Proj {

	@Id
	private int p_id;

	private String proj_name;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "proj")
	private List<Emp> emp;

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public String getProj_name() {
		return proj_name;
	}

	public void setProj_name(String proj_name) {
		this.proj_name = proj_name;
	}

	public List<Emp> getEmp() {
		return emp;
	}

	public void setEmp(List<Emp> emp) {
		this.emp = emp;
	}

	public Proj() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Proj(int p_id, String proj_name, List<Emp> emp) {
		super();
		this.p_id = p_id;
		this.proj_name = proj_name;
		this.emp = emp;
	}

}
