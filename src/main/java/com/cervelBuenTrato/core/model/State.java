package com.cervelBuenTrato.core.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity(name = "state")

public abstract class State implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_state;
	@OneToOne
	@JoinColumn(name = "id_purchase")
	private Purchase purchase;
}
