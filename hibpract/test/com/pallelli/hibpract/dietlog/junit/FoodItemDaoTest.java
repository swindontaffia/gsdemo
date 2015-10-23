package com.pallelli.hibpract.dietlog.junit;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pallelli.hibpract.dietlog.MyHibernateSessionFactory;
import com.pallelli.hibpract.dietlog.beans.FoodItem;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/simple-job-launcher-context.xml" })

public class FoodItemDaoTest {

	@Autowired
	private MyHibernateSessionFactory sessionFactory;

	private Session session;

	static private final String FOOD_ITEM_NAME = "Pitted Kalamata Olives";
	static private final double CARBS = 0.5;
	static private final double FATS = 21.4;
	static private final double PROTEIN = 1.6;
	static private final double SATURATES = 2.7;
	static private final double SODIUM = 3.18 * 0.4;
	static private final double SUGARS = 0.5;
	static private final double FIBRE = 3.2;
	static private final String UNITS = "100g";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		session = sessionFactory.openSession();
	}

	@After
	public void tearDown() throws Exception {
		session.close();
	}

	@Test
	public void test() {
		create();
		read();
		update();
		read2();
		delete();
		read3();
	}

	private void create() {
		session.beginTransaction();
		FoodItem foodItem = new FoodItem(FOOD_ITEM_NAME);
		foodItem.setCarbs(CARBS);
		foodItem.setFats(FATS);
		foodItem.setProtein(PROTEIN);
		foodItem.setSaturates(SATURATES);
		foodItem.setSodium(SODIUM);
		foodItem.setSugars(SUGARS);
		foodItem.setFibre(FIBRE);
		foodItem.setUnits(UNITS);
		session.persist(foodItem);
		session.getTransaction().commit();
	}

	private void read() {
		FoodItem foodItem = (FoodItem) session.get(FoodItem.class, FOOD_ITEM_NAME);
		assertTrue(foodItem.getCarbs() == CARBS);
		assertTrue(foodItem.getFats() == FATS);
		assertTrue(foodItem.getProtein() == PROTEIN);
		assertTrue(foodItem.getSaturates() == SATURATES);
		assertTrue(foodItem.getSodium() == SODIUM);
		assertTrue(foodItem.getSugars() == SUGARS);
		assertTrue(foodItem.getFibre() == FIBRE);
		assertTrue(foodItem.getUnits().equals(UNITS));
	}

	private void update() {
		session.beginTransaction();
		FoodItem foodItem = (FoodItem) session.get(FoodItem.class, FOOD_ITEM_NAME);
		foodItem.setProtein(PROTEIN * 2);
		session.getTransaction().commit();
	}

	private void read2() {
		FoodItem foodItem = (FoodItem) session.get(FoodItem.class, FOOD_ITEM_NAME);
		assertTrue(foodItem.getCarbs() == CARBS);
		assertTrue(foodItem.getFats() == FATS);
		assertTrue(foodItem.getProtein() == PROTEIN * 2);
		assertTrue(foodItem.getSaturates() == SATURATES);
		assertTrue(foodItem.getSodium() == SODIUM);
		assertTrue(foodItem.getSugars() == SUGARS);
		assertTrue(foodItem.getFibre() == FIBRE);
		assertTrue(foodItem.getUnits().equals(UNITS));
	}

	private void delete() {
		FoodItem foodItem = (FoodItem) session.get(FoodItem.class, FOOD_ITEM_NAME);
		session.beginTransaction();
		session.delete(foodItem);
		session.getTransaction().commit();

	}

	private void read3() {
		FoodItem foodItem = (FoodItem) session.get(FoodItem.class, FOOD_ITEM_NAME);
		assertTrue(foodItem == null);
	}

}
