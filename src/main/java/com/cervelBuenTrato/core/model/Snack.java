package com.cervelBuenTrato.core.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "snack")
@DiscriminatorValue("SNACK")
public class Snack extends Product {

	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
