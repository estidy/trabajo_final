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
@Entity(name = "type_beer")

public class TypeBeer implements Serializable {

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_type_beer;
	@Column(length = 50)
	@NotEmpty
	private String type;
	@Column(length = 50)
	private String description;
}
