package com.pallelli.mvcpract.junit;

import static org.junit.Assert.*;

import java.util.List;

import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pallelli.hibpract.dietlog.beans.FoodItem;
import com.pallelli.mvcpract.mock.MockDietLogDao;
import com.pallelli.mvcpract.rest.DietLoggerFoodItemService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/junit-app-context.xml" })

public class FoodItemServiceTest {

	@Autowired
	private DietLoggerFoodItemService theService;
	
	@Autowired
	private MockDietLogDao mockDietLogDao;
	
	private FoodItem foodItem;
	
	@Before
	public void setup() {
		foodItem = new FoodItem("t1");
		foodItem.setUnits("u1");
	}
	
	@Test 
	public void tests() {
		addFoodItem();
		getFoodItem();
		getAllFoodItems();
		updateFoodItem();
		deleteFoodItem();
	}
	
	public void addFoodItem() {
		theService.addFoodItem(foodItem);
		assertTrue(mockDietLogDao.contains(foodItem));
	}

	private void getFoodItem() {
		Response response = theService.getFoodItem(foodItem.getName());
		Object o = response.getEntity();
		assertTrue(foodItem.equals(o));
	}
	
	private void getAllFoodItems() {
		FoodItem fi2 = new FoodItem();
		fi2.setName("fi2");
		fi2.setUnits("2");
		mockDietLogDao.addFoodItem(fi2);
		Response response = theService.getAllFoodItems();
		Object o = response.getEntity();
		assertTrue( o instanceof List<?>);
		assertTrue( ((List<?>)o).size() == 2);
	}

	private void updateFoodItem() {
		foodItem.setUnits("u2");
		FoodItem preUpdateFoodItem = mockDietLogDao.getNamedFoodItem(foodItem.getName());
		assertFalse(foodItem.getUnits().equals(preUpdateFoodItem));
		theService.updateFoodItems(foodItem);
		assertTrue(mockDietLogDao.getNamedFoodItem(foodItem.getName()).getUnits().equals("u2"));
		
	}

	private void deleteFoodItem() {
		theService.deleteFoodItems(foodItem.getName());
		assertNull( mockDietLogDao.getNamedFoodItem(foodItem.getName()));
	}


}
