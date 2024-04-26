package com.bkgt.backend.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.bkgt.services.Services;
import com.mashape.unirest.http.exceptions.UnirestException;

public class NewTest {



	@Test
	public void validateCardPayment() throws IOException, UnirestException {
		String email="alara6@yopmail.com";
		String password="Test123";
		Services orders = new Services(email,password);
		Reporter.log("Verificar que el metodo de pago sea con Tarjeta");
		Assert.assertEquals(orders.getPaymentMethod(), "Tarjeta");
	}
	
	
	@Test		
	public void validateProductAndComplements() throws IOException, UnirestException {
		String email="alara6@yopmail.com";
		String password="Test123";
		Services orders = new Services(email,password);
		System.out.println(orders.getProductAndDescription());


		
	}
	
	@Test
	public void validateCashPayment() throws IOException, UnirestException {
		String email="alara6@yopmail.com";
		String password="Test123";
		Services orders = new Services(email,password);
		Assert.assertEquals(orders.getPaymentMethod(), "Efectivo");
		Reporter.log("Verificar que el metodo de pago sea en Efectivo");

	}
	
	
	
	
}
