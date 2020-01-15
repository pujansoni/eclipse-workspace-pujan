package ShoppingCartAssignment;

/**
 * Assignment - 1
 * Copyright 15-01-2020
 * All rights reserved
 * @author Pujan Soni
 * @version Eclipse(4.14.0)
 * @version Java(1.8.0)
 */

import java.util.*;

public class ShoppingCart {
	/**
	 * Defined the getShoppingCartData() function to display the Items
	 * @param itemsAl passing the ArrayList created in ShoppingCartApp class
	 */
	public void getShoppingCartData(ArrayList itemsAl) {
		/**
		 * Sorting the ArrayList on Item price
		 * @param itemsAll passing the ArrayList to sort Items
		 */
		Collections.sort(itemsAl);
		System.out.println("Price" + "\t" + "Items");
		String strData = "";
		/**
		 * Using the for loop to check the type of Items and display data
		 */
		for(int i=0; i<itemsAl.size(); i++) {
			Object obj = itemsAl.get(i);
			if(obj instanceof Book) {
				strData = ((Book) obj).getPrice() + "\t" + ((Book) obj).getData();
			} else if(obj instanceof GiftCard) {
				strData = ((GiftCard) obj).getPrice() + "\t" + ((GiftCard) obj).getData();
			}
			System.out.println(strData);
		}
	}
}