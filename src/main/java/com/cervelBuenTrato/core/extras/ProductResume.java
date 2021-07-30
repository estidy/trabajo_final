package com.cervelBuenTrato.core.extras;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Lob;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductResume implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id_product;
	private String name;
	@Lob
	private String description;
	private Double price;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate expiration;
	private Integer stock_actual;
	private Integer stock_min;
	private String type;
	private Integer dias_venc;
}
