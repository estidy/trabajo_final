package com.cervelBuenTrato.core.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "finished")
@DiscriminatorValue("FINISHED")
public class Finished extends State {

	private static final long serialVersionUID = 1L;
	private static final String TYPE = "FINISHED";

	@Override
	public String getType() {
		return TYPE;
	}

}
