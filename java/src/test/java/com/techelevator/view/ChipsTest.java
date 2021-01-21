package com.techelevator.view;
import org.junit.Assert;
import org.junit.Test;

import materials.Candy;
import materials.Chips;

public class ChipsTest {

	@Test
	public void does_chips_make_a_sound() {

		Chips chipIstantiation = new Chips(null, null, 0);

		String expectedResult = "Crunch Crunch, Yum!";
		String actualResult = chipIstantiation.getMessage();
		
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void does_chips_make_a_name() {

		Chips chipIstantiation = new Chips(null, null, 0);

		String expectedResult = "Potato Crisps!";
		String actualResult = chipIstantiation.getName();
		
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void does_chips_make_a_code() {

		Chips chipIstantiation = new Chips(null, null, 0);

		String [] expectedResult = {"A1", "A2", "A3","A4"};
		String actualResult = chipIstantiation.getCode();
		
		Assert.assertEquals(expectedResult, actualResult);
	}
	@Test
	public void does_chips_have_a_cost() {
		Chips chipIstantiation = new Chips("Yes", "No", 0);
			
		
		Double expectedResult = 3.05;
		Double actualResult = chipIstantiation.getPrice();
		
		Assert.assertEquals(expectedResult, actualResult);
	}
	@Test
	public void does_chips_have_a_quantity() {
		Candy candy = new Candy("Yes","No", 15);
		
		int expectedResult = 5;
		int actualResult = candy.getQuantity();
		
		Assert.assertEquals(expectedResult, actualResult);
	}
}
