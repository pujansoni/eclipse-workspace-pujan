package ShoppingCartAssignment;

/**
 * Assignment - 1
 * Copyright 15-01-2020
 * All rights reserved
 * @author Pujan Soni
 * @version Eclipse(4.14.0)
 * @version Java(1.8.0)
 */

public class GiftCard extends Item {
	String description, color;
	
	/**
	 * Creating the GiftCard() constructor in order to set description, color and price
	 * @param description parameter passed to set description of the GiftCard
	 * @param color parameter passed to set color of the GiftCard
	 * @param price parameter passed to set price of the GiftCard
	 */
	GiftCard(String description, String color, double price){
		super();
		super.setPrice(price);
		this.description = description;
		this.color = color;
	}

	/**
	 * Defined the getData() in order to display GiftCard data if the user wants to display the Items
	 * @return String to display the data
	 */
	public String getData() {
		return "GiftCard " + "(" + this.description + " - " + this.color + ")";
	}
}