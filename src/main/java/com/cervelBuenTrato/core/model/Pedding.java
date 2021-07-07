package com.cervelBuenTrato.core.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "pendding")
@DiscriminatorValue("PENDDING")
public class Pedding extends State {

	private static final long serialVersionUID = 1L;
	private static final String TYPE = "PENDDING";

	@Override
	public String getType() {
		return TYPE;
	}

}
