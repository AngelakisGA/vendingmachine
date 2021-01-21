package com.techelevator.view;
import org.junit.Assert;
import org.junit.Test;


import materials.Drinks;

public class DrinksTest {

	@Test
	public void does_drinks_make_a_sound() {

		Drinks drinksIstantiation = new Drinks(null, null, 0);

		String expectedResult = "Glug Glug, Yum!";
		String actualResult = drinksIstantiation.getMessage();
		
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void does_chips_make_a_name() {

		Drinks drinksIstantiation = new Drinks(null, null, 0);

		String expectedResult = "Dr. Salt";
		String actualResult = drinksIstantiation.getName();
		
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void does_chips_make_a_code() {

		Drinks drinksIstantiation = new Drinks(null, null, 0);

		String [] expectedResult = {"C1", "C2", "C3","C4"};
		String actualResult = drinksIstantiation.getCode();
		
		Assert.assertEquals(expectedResult, actualResult);
	}
	@Test
	public void does_chips_have_a_cost() {
		
		Drinks drinksIstantiation = new Drinks(null, null, 0);
			
		Double expectedResult = 1.50;
		Double actualResult = drinksIstantiation.getPrice();
		
		Assert.assertEquals(expectedResult, actualResult);
	}
	@Test
	public void does_chips_have_a_quantity() {
		
		Drinks drinksIstantiation = new Drinks(null, null, 0);
		
		int expectedResult = 5;
		int actualResult = drinksIstantiation.getQuantity();
		
		Assert.assertEquals(expectedResult, actualResult);
	}
}
