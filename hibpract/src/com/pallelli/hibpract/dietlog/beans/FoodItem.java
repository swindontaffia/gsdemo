package com.pallelli.hibpract.dietlog.beans;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FoodItem")
public class FoodItem
{

	private String name;
	private String units;
	private double carbs;
	private double sugars;
	private double protein;
	private double fats;
	private double saturates;
	private double sodium;
	private double fibre;
	private double energy;

	public FoodItem(String name)
	{
		this.name = name;
	}

	public FoodItem()
	{
	}

	@Id
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getUnits()
	{
		return units;
	}

	public void setUnits(String units)
	{
		this.units = units;
	}

	public double getCarbs()
	{
		return carbs;
	}

	public void setCarbs(double carbs)
	{
		this.carbs = carbs;
	}

	public double getSugars()
	{
		return sugars;
	}

	public void setSugars(double sugars)
	{
		this.sugars = sugars;
	}

	public double getProtein()
	{
		return protein;
	}

	public void setProtein(double protein)
	{
		this.protein = protein;
	}

	public double getFats()
	{
		return fats;
	}

	public void setFats(double fats)
	{
		this.fats = fats;
	}

	public double getSaturates()
	{
		return saturates;
	}

	public void setSaturates(double saturates)
	{
		this.saturates = saturates;
	}

	public double getSodium()
	{
		return sodium;
	}

	public void setSodium(double sodium)
	{
		this.sodium = sodium;
	}

	public void setFibre(double fibre)
	{
		this.fibre = fibre;
	}
	
	public double getFibre()
	{
		return fibre;
	}

	public double getEnergy() {
		return energy;
	}

	public void setEnergy(double energy) {
		this.energy = energy;
	}
}
