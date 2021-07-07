package com.cervelBuenTrato.core.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "cancelled")
@DiscriminatorValue("CANCELLED")
public class Cancelled extends State {

	private static final long serialVersionUID = 1L;
	private static final String TYPE = "CANCELLED";

	@Override
	public String getType() {
		return TYPE;
	}

}
