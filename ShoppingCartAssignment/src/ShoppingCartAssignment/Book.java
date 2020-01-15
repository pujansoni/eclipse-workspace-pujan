package ShoppingCartAssignment;

/**
 * Assignment - 1
 * Copyright 15-01-2020
 * All rights reserved
 * @author Pujan Soni
 * @version Eclipse(4.14.0)
 * @version Java(1.8.0)
 */

public class Book extends Item {
	String aName, title;
	
	/**
	 * Creating the Book() constructor in order to set aName, title and price
	 * @param aName parameter passed to set aName of the Book
	 * @param title parameter passed to set title of the Book
	 * @param price parameter passed to set price of the Book
	 */
	Book(String aName, String title, double price){
		super();
		super.setPrice(price);
		this.aName = aName;
		this.title = title;
	}
	
	/**
	 * Defined the getData() in order to display Book data if the user wants to display the Items
	 * @return String to display the data
	 */
	public String getData() {
		return "Book " + "(" + this.title + " - " + this.aName + ")";
	}
}