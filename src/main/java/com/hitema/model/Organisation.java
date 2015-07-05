package com.hitema.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the organisation database table.
 * 
 */
@Entity
@Table(name="organisation")
@NamedQuery(name="Organisation.findAll", query="SELECT o FROM Organisation o")
public class Organisation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="organisation_name", nullable=false, length=30)
	private String organisationName;

	@Column(nullable=false, length=30)
	private String password;

	public Organisation() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrganisationName() {
		return this.organisationName;
	}

	public void setOrganisationName(String organisationName) {
		this.organisationName = organisationName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}