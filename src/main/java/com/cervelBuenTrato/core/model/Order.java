package com.cervelBuenTrato.core.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "orders")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_order;
	@OneToOne
	@JoinColumn(name = "id_product")
	private Product product;
	private Integer quantity;

	public Double getTotalPrice() {
		return (Math.pow(product.getPrice(), this.quantity));
	}

}
