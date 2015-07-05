package com.hitema.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the service database table.
 * 
 */
@Entity
@Table(name="service")
@NamedQuery(name="Service.findAll", query="SELECT s FROM Service s")
public class Service implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="description_service", nullable=false, length=255)
	private String descriptionService;

	@Column(unique=true, name="nom_service", nullable=false, length=255)
	private String nomService;

	@Column(name="url_service", nullable=false, length=255)
	private String urlService;

	public Service() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescriptionService() {
		return this.descriptionService;
	}

	public void setDescriptionService(String descriptionService) {
		this.descriptionService = descriptionService;
	}

	public String getNomService() {
		return this.nomService;
	}

	public void setNomService(String nomService) {
		this.nomService = nomService;
	}

	public String getUrlService() {
		return this.urlService;
	}

	public void setUrlService(String urlService) {
		this.urlService = urlService;
	}

}