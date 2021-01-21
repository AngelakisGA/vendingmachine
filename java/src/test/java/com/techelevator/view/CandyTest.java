package com.techelevator.view;
import org.junit.Assert;
import org.junit.Test;

import materials.Candy;




public class CandyTest {
	

	@Test
	public void does_candy_make_a_sound() {

		Candy candy = new Candy(null, null, 0);

		String expectedResult = "Munch Munch, Yum!";
		String actualResult = candy.getMessage();
		
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void does_candy_have_a_name() {

		Candy candy = new Candy(null, "Little League Chew", 0);
		
		String expectedResult = "Little League Chew";
		String actualResult = candy.getName();
		
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void does_candy_have_a_code() {
		Candy candy = new Candy("Whatever", "As if", 0);
		
		String [] expectedResult = {"B1", "B2", "B3","B4"};
		String actualResult = candy.getCode();
		
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void does_candy_have_a_cost() {
		Candy candy = new Candy("Yes","No", 0);
		
		Double expectedResult = 0.95;
		Double actualResult = candy.getPrice();
		
		Assert.assertEquals(expectedResult, actualResult);
	}
	@Test
	public void does_candy_have_a_quantity() {
		Candy candy = new Candy("Yes","No", 15);
		
		int expectedResult = 5;
		int actualResult = candy.getQuantity();
		
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	
	
	
	
}
