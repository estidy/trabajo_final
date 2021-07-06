package com.cervelBuenTrato.core.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "cancelled")
@DiscriminatorValue("CANCELLED")
public class Cancelled extends State {

	private static final long serialVersionUID = 1L;

}
