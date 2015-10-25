package com.pallelli.mvcpract.springmvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pallelli.hibpract.dietlog.DietLogDao;
import com.pallelli.hibpract.dietlog.beans.FoodItem;

/**
 * @author Neil Britton
 *
 */
@Controller
@RequestMapping("/")
public class FoodItemController {

	@Autowired
	private DietLogDao dietLogDao;

	@RequestMapping(value = "/getAllFoodItems", method = RequestMethod.GET)
	public ModelAndView getAllFoodItems(ModelMap model) {
		List<FoodItem> foodItems = dietLogDao.getAllFoodItems();
		ModelAndView modelAndView = new ModelAndView("foodItemList");
		modelAndView.addObject("foodItems", foodItems);

		return modelAndView;
	}

	@RequestMapping(value = "/showAddFoodItemForm", method = RequestMethod.GET)
	public ModelAndView showAddFoodItemForm(ModelMap model) {
		ModelAndView modelAndView = new ModelAndView("addFoodItemForm");
		FoodItemForm foodItemForm = new FoodItemForm();
		modelAndView.addObject("foodItemForm", foodItemForm);

		return modelAndView;
	}

	@RequestMapping(value = "/addFoodItem", method = RequestMethod.POST)
	public ModelAndView addFoodItemForm(@ModelAttribute("SpringWeb") FoodItemForm foodItemForm, ModelMap model) {
		ModelAndView modelAndView;
		foodItemForm.setDirty(true);
		foodItemForm.setError("");

		try {
			if (foodItemForm.isInvalid()) {
				modelAndView = new ModelAndView("addFoodItemForm");
				modelAndView.addObject("foodItemForm", foodItemForm);
			} else {
				dietLogDao.addFoodItem(foodItemForm.getFoodItem());
				modelAndView = getAllFoodItems(model);
			}
		} catch (Exception e) {
			foodItemForm.setError(e.toString());
			modelAndView = new ModelAndView("addFoodItemForm");
			modelAndView.addObject("foodItemForm", foodItemForm);
		}

		return modelAndView;
	}

}