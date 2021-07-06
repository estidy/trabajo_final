package com.cervelBuenTrato.core.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity(name = "promotion")
public class Promotion implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_promotion;
	@OneToMany
	private List<Product> products;
	private String description;
	private Date date_from;
	private Date date_to;

}
