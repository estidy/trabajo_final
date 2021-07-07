package com.cervelBuenTrato.core.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity(name = "product")

public abstract class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_product;
	@Column(length = 50)
	@NotEmpty
	private String name;
	@Column(length = 50)
	private String description;
	private Integer stock_min;
	@NotEmpty
	private Integer stock_actual;
	@NotEmpty
	private BigDecimal price;
	@NotEmpty
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date expiration;
	private String measure;
	private Integer margin_gain;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public abstract String getType();

}
