package com.cervelBuenTrato.core.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity(name = "beer")
@DiscriminatorValue("BEER")
public class Beer extends Product {

	private static final long serialVersionUID = 1L;
	private static final String TYPE = "BEER";

	@ManyToOne
	@JoinColumn(name = "id_type_beer")
	private TypeBeer type_beer;

	@Override
	public String getType() {
		return TYPE;
	}

}
