package ShoppingCartAssignment;

/**
 * Assignment - 1
 * Copyright 15-01-2020
 * All rights reserved
 * @author Pujan Soni(105167055)
 * @version Eclipse(4.14.0)
 * @version Java(1.8.0)
 */

import java.util.Scanner;

/**
 * Implement Comparable Item to override the compareTo() function in order to sort price of Item
 */
public abstract class Item implements Comparable<Item> {
	private static int id = 0;
	private double price;
	private Scanner userInput;
	
	/**
	 * Defined the Item() constructor which increments the id of an Item
	 */
	Item(){
		Item.setId(Item.getId() + 1);
	}
	
	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		Item.id = id;
	}
	
	/**
	 * Using the setPrice() function in order to set Item price. Also check if the price is valid or not
	 * @param itemPrice passing this variable in order to set the Item price
	 */
	public void setPrice(double itemPrice) {
		do {
			if(isNegative(itemPrice)) {
				System.out.println("Please enter a valid price.");
				userInput = new Scanner(System.in);
				itemPrice = userInput.nextDouble();	
			}
		} while(isNegative(itemPrice));
		this.price = itemPrice;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	/**
	 * Defined the isNegative() function in order to determine if the Item's price is negative or positive
	 * @param itemPrice passing this variable to determine whether it's negative or positive
	 * @return boolean value based on price value
	 */
	private boolean isNegative(double itemPrice) {
		return itemPrice < 0 ? true : false;
	}
	
	/**
	 * Overriding the compareTo() method of Comparable interface in order to sort price of Items
	 * @param i1 passing first object to compare it's value
	 * @return object whose value is less compare to the other object
	 */
	public int compareTo(Item i1) {
		return new Double(price).compareTo(i1.price);
	}
}
