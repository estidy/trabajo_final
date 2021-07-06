package com.cervelBuenTrato.core.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "destination_adress")

public class DestinationAdress implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_dest_adress;
	private Integer number;
	private String Dto;
	private String street;
	private String location;
	private String zone;

}
