package com.cervelBuenTrato.core.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity(name = "snack")
@DiscriminatorValue("SNACK")
public class Snack extends Product {

	private static final long serialVersionUID = 1L;
	private static final String TYPE = "SNACK";
	@ManyToOne
	@JoinColumn(name = "id_size")
	private Size size;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String getType() {
		return TYPE;
	}

}
