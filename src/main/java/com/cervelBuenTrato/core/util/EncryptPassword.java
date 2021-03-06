package com.cervelBuenTrato.core.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptPassword {

	public static void main(String[] args) {
		var password = "1234";
		System.out.println("password sin encriptar:" + password);
		System.out.println("password encriptado:" + encryptPassword(password));
	}

	public static String encryptPassword(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(password);
	}
}
