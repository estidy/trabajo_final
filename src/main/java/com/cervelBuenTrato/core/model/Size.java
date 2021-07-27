package com.cervelBuenTrato.core.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "size")
public class Size implements Serializable {

	private static final long serialVersionUID = -5209006211039393023L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_size;
	@NotNull
	private Integer grams;
	@Column(length = 50)
	@NotEmpty
	private String description;
}
