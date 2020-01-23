package ShoppingCartAssignment;

/**
 * Assignment - 1
 * Copyright 15-01-2020
 * All rights reserved
 * @author Pujan Soni(105167055)
 * @version Eclipse(4.14.0)
 * @version Java(1.8.0)
 */

public class GiftCard extends Item {
	String description, color;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
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