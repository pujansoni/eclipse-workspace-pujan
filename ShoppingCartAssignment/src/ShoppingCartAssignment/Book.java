package ShoppingCartAssignment;

/**
 * Assignment - 1
 * Copyright 15-01-2020
 * All rights reserved
 * @author Pujan Soni (105167055)
 * @version Eclipse(4.14.0)
 * @version Java(1.8.0)
 */

public class Book extends Item {
	String aName, title;

	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
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