package com.techelevator.view;
import org.junit.Assert;
import org.junit.Test;


import materials.Gum;

public class GumTest {

	@Test
	public void does_gum_make_a_sound() {

		Gum gumIstantiation = new Gum(null, null, 0);

		String expectedResult = "Chew Chew, Yum!";
		String actualResult = gumIstantiation.getMessage();
		
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void does_chips_make_a_name() {

		Gum gumIstantiation = new Gum(null, null, 0);

		String expectedResult = "U-Chews";
		String actualResult = gumIstantiation.getMessage();
		
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void does_chips_make_a_code() {

		Gum gumIstantiation = new Gum(null, null, 0);

		String [] expectedResult = {"D1", "D2", "D3","D4"};
		String actualResult = gumIstantiation.getCode();
		
		Assert.assertEquals(expectedResult, actualResult);
	}
	@Test
	public void does_chips_have_a_cost() {
		
		Gum gumIstantiation = new Gum(null, null, 0);
			
		Double expectedResult = 0.85;
		Double actualResult = gumIstantiation.getPrice();
		
		Assert.assertEquals(expectedResult, actualResult);
	}
	@Test
	public void does_chips_have_a_quantity() {
		
		Gum gumIstantiation = new Gum(null, null, 0);
		
		int expectedResult = 5;
		int actualResult = gumIstantiation.getQuantity();
		
		Assert.assertEquals(expectedResult, actualResult);
	}
}
