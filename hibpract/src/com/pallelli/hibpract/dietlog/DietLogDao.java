package com.pallelli.hibpract.dietlog;

import java.util.List;

import com.pallelli.hibpract.dietlog.beans.FoodItem;

public interface DietLogDao {

	void addFoodItem(FoodItem foodItem);

	List<FoodItem> listFoodItems();

}
