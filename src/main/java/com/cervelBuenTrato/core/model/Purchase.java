package com.cervelBuenTrato.core.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity(name = "purchase")
public class Purchase implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_purchase;
	private Long nro_purchase;
	@OneToMany
	private List<Order> orders;
	private Date date;
	@OneToOne
	@JoinColumn(name = "id_dest_adress")
	private DestinationAdress destination_adress;
	@OneToOne
	@JoinColumn(name = "id_user")
	private User user;
	@OneToOne
	@JoinColumn(name = "id_voucher")
	private Voucher voucher;
	@OneToOne
	@JoinColumn(name = "id_payment")
	private Payment payment;
	@OneToOne
	@JoinColumn(name = "id_state")
	private State state;
	// @Enumerated(EnumType.String)

	public BigDecimal getTotalAmount() {
		return null;
	}
}
