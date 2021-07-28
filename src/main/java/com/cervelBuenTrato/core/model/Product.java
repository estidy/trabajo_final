package com.cervelBuenTrato.core.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity(name = "product")
@DiscriminatorColumn(name = "dtype")
public abstract class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_product;
	@Column(length = 50)
	@NotEmpty
	private String name;
	@Lob
	private String description;
	@NotNull
	private Integer stock_min;
	@NotNull
	private Integer stock_actual;
	@NotNull
	private Double price;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate expiration;
	private String measure;
	private Integer margin_gain;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public abstract String getType();

}
