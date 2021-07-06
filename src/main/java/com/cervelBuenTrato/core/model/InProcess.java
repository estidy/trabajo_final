package com.cervelBuenTrato.core.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "in_process")
@DiscriminatorValue("INPROCESS")
public class InProcess extends State {

	private static final long serialVersionUID = 1L;

}
