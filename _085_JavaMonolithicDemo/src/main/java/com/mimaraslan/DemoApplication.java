package com.mimaraslan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
Spring; anotasyonlar ile sistemi yönetir.
Nesne yaratmak için belli anotasyonlar kullanır.
Bu anotasyonları bulabilmek için main metodunun olduğu class @SpringBootApplication ile işaretlenmiş olmalıdır.
Bu anotasyon sayesinde içinde bulunduğu package ve onun altındaki packagelerin içindeki tüm dosyalarda
diğer anotasyonları arar ve bulduklarıyla gerekli işlemleri yapar.
 */

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
