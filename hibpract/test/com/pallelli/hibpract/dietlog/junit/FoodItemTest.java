package com.pallelli.hibpract.dietlog.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import com.pallelli.hibpract.dietlog.beans.FoodItem;

public class FoodItemTest {

	@Test
	public void test() {
		testCarbs();
		testFats();
		testFibre();
		testProtein();
		testSaturates();
		testSodium();
		testSugars();
		testUnits();
		testEquals();
		testClone();
	}

	private void testEquals() {
		FoodItem fi1 = new FoodItem();
		initFoodItem(fi1);
		FoodItem fi2 = new FoodItem();
		initFoodItem(fi2);
		assertTrue(fi1.equals(fi2));
	}

	private void initFoodItem(FoodItem fi) {
		fi.setName("fi");
		fi.setCarbs(10);
		fi.setFats(20);
		fi.setFibre(30);
		fi.setProtein(40);
		fi.setSaturates(50);
		fi.setSodium(60);
		fi.setSugars(70);
		fi.setUnits("u");
	}

	private void testClone() {
		FoodItem fi1 = new FoodItem();
		initFoodItem(fi1);
		FoodItem fi2 = (FoodItem)fi1.clone();
		assertTrue(fi1 != fi2);
		assertTrue(fi1.equals(fi2));
	}

	private void testUnits() {
		FoodItem fi1 = new FoodItem();
		fi1.setUnits("x");
		assertTrue(fi1.getUnits().equals("x"));
	}

	private void testSugars() {
		FoodItem fi1 = new FoodItem();
		fi1.setSugars(232);
		assertTrue(fi1.getSugars() == 232);
	}

	private void testSodium() {
		FoodItem fi1 = new FoodItem();
		fi1.setSodium(594);
		assertTrue(fi1.getSodium() == 594);
	}

	private void testSaturates() {
		FoodItem fi1 = new FoodItem();
		fi1.setSaturates(943);
		assertTrue(fi1.getSaturates() == 943);
	}

	private void testProtein() {
		FoodItem fi1 = new FoodItem();
		fi1.setProtein(332);
		assertTrue(fi1.getProtein() == 332);
	}

	private void testFibre() {
		FoodItem fi1 = new FoodItem();
		fi1.setFibre(1920);
		assertTrue(fi1.getFibre() == 1920);
	}

	private void testFats() {
		FoodItem fi1 = new FoodItem();
		fi1.setFats(5402);
		assertTrue(fi1.getFats()==5402);
	}

	private void testCarbs() {
		FoodItem fi1 = new FoodItem();
		fi1.setCarbs(7219);
		assertTrue(fi1.getCarbs() == 7219); 
	}

}
