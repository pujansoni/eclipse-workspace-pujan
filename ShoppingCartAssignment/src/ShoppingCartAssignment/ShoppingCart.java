package ShoppingCartAssignment;

/**
 * Assignment - 1
 * Copyright 15-01-2020
 * All rights reserved
 * @author Pujan Soni(105167055)
 * @version Eclipse(4.14.0)
 * @version Java(1.8.0)
 */

import java.util.*;

public class ShoppingCart {
	/**
	 *	Created an ArrayList to store the list of items
	 */
	ArrayList<Item> itemsAl = new ArrayList<Item>();
	ShoppingCart(){}
	/**
	 * Created a constructor for the ShoppingCart to set the ArrayList<Item>.
	 * The ArrayList<Item> is used to add the Items in the array list.
	 * @param itemsAl The itemsAl ArrayList<Item> is passed to set the ArrayList<Item> for ShoppingCart
	 */
	ShoppingCart(ArrayList<Item> itemsAl){
		this.itemsAl = itemsAl;
	}
	public ArrayList<Item> getItemsAl() {
		return itemsAl;
	}
	/**
	 * Defined the getShoppingCartData() function to display the Items
	 * @param itemsAl passing the ArrayList created in ShoppingCartApp class
	 */
	public void getShoppingCartData(ArrayList<Item> itemsAl) {
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