package ShoppingCartAssignment;

/**
 * Assignment - 1
 * Copyright 15-01-2020
 * All rights reserved
 * @author Pujan Soni
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
	
	/**
	 * Defined the Item() constructor which increments the id of an Item
	 */
	Item(){
		Item.id += 1;
	}
	
	/**
	 * Using the setPrice() function in order to set Item price. Also check if the price is valid or not
	 * @param itemPrice passing this variable in order to set the Item price
	 */
	protected void setPrice(double itemPrice) {
		do {
			if(isNegative(itemPrice)) {
				System.out.println("Please enter a valid price.");
				Scanner userInput = new Scanner(System.in);
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
	 * @return if the item value is negative or positive
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
