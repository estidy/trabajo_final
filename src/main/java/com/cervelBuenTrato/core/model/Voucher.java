package com.cervelBuenTrato.core.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "voucher")

public class Voucher implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_voucher;
	@OneToOne
	@NotEmpty
	@JoinColumn(name = "id_purchase")
	private Purchase purchase;
	@OneToOne
	@NotEmpty
	@JoinColumn(name = "id_user")
	private Usr user;
	@OneToOne
	@NotEmpty
	@JoinColumn(name = "id_payment")
	private Payment payment;
	@NotEmpty
	private Date date;
	@NotEmpty
	private BigDecimal toltal_price;

}
