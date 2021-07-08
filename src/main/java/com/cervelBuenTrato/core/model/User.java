package com.cervelBuenTrato.core.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = -1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_user;
	@Column(length = 50)
	@NotEmpty
	private String username;
	@NotEmpty
	@Column(length = 128)
	private String password;
	@Column(length = 50, unique = true, nullable = false)
	@NotEmpty
	@Email
	private String email;
	private String phone;
	private Boolean active = Boolean.TRUE;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_user")
	private List<Profile> profiles;
	@OneToMany
	@JoinColumn(name = "id_user")
	private List<Purchase> purchases;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void activeUser() {
		this.active = Boolean.TRUE;
	}

	public void desactiveUser() {
		this.active = Boolean.FALSE;
	}
}
