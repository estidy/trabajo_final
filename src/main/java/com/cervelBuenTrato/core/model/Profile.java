package com.cervelBuenTrato.core.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity(name = "profile")
public class Profile implements Serializable {

	private static final long serialVersionUID = -5209006211039393023L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_profile;
	@Column(length = 50)
	@NotEmpty
	private String name;
	private String description;
}
