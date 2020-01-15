package ShoppingCartAssignment;

/**
 * Assignment - 1
 * Copyright 15-01-2020
 * All rights reserved
 * @author Pujan Soni
 * @version Eclipse(4.14.0)
 * @version Java(1.8.0)
 */

import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCartApp {
	/**
	 *	Created an ArrayList to store the list of items
	 */
	static ArrayList itemsAl = new ArrayList();
	
	public static void main(String[] args) {
		while(true) {
			/**
			 * Calling the userMenu() function to display the User Options, 
			 * also passed the ArrayList for keeping track of the Items
			 * @param itemsAl ArrayList for storing the Items
			 */
			userMenu(itemsAl);
		}
	}
	
	public static void userMenu(ArrayList itemsAl) {
		/**
		 * Using the switch statement for User Options
		 * @param option get input from the user to perform add, display or exit operation
		 */
		char option = getOptionFromUser();
		switch(option) {
		case '1':
			/**
			 * Calling the getUserOptions() function if user wants to add any data
			 */
			getUserOptions();
			break;
		case '2':
			/**
			 * Print the empty cart message if the cart is empty
			 * Create a ShoppingCart instance and print the data
			 */
			if(itemsAl.size() == 0) {
				System.out.println("Your Cart is Empty!");
			} else {
				ShoppingCart sc = new ShoppingCart();
				sc.getShoppingCartData(itemsAl);	
			}
			break;
		case '3':
			/**
			 * Exit from the program if user selects the Exit option
			 */
			System.out.println("Successful Exit");
			System.exit(0);
		default:
			/**
			 * Show the error message if user enters invalid input
			 */
			System.out.println("Please enter a valid option.\n");
		}
	}
	
	/**
	 * Defined the getUserOptions() function to add User data
	 */
	public static void getUserOptions() {
		while(true) {
			/**
			 * Using the switch statement for add Options
			 * @param option get input from the user to perform add or return operation
			 */
			char items = getItemFromUser();
			switch(items) {
			case '1':
				/**
				 * Calling the getBookDetails() function to get book details and adding the object to the ArrayList
				 */
				itemsAl.add(getBookDetails());
				break;
			case '2':
				/**
				 * Calling the getGiftCardDetails() function to get gift card details and adding the object to the ArrayList
				 */
				itemsAl.add(getGiftCardDetails());
				break;
			case '3':
				/**
				 * Calling the userMenu() function to return back to the main menu,
				 * @param itemsAl ArrayList to keep track of the Items
				 */
				userMenu(itemsAl);
				return;
			default:
				/**
				 * Show the error message if user enters invalid input
				 */
				System.out.println("Please enter a valid option.\n");
			}
		}
	}
	
	/**
	 * Show user options for main menu
	 */
	public static char getOptionFromUser() {
		System.out.println("1. Add\n2. Display\n3. Exit");
		Scanner choice = new Scanner(System.in);
		return choice.next().charAt(0);
	}
	
	/**
	 * User options for adding an Item
	 */
	public static char getItemFromUser() {
		System.out.println("1. Add Books\n2. Add Gift Cards\n3. Return to Main Menu");
		Scanner items = new Scanner(System.in);
		return items.next().charAt(0);
	}
	
	/**
	 * The getBookDetails() function is used to get Book details
	 */
	public static Book getBookDetails() {
		System.out.println("Please enter Book name: ");
		Scanner bDetails = new Scanner(System.in);
		String bName = bDetails.nextLine();
		System.out.println("Please enter Book title: ");
		String bTitle = bDetails.nextLine();
		System.out.println("Please enter Book price: ");
		double bPrice = bDetails.nextDouble();
		return new Book(bName, bTitle, bPrice);
	}
	
	/**
	 * The getGiftCardDetails() function is used to get Gift Card details
	 */
	public static GiftCard getGiftCardDetails() {
		System.out.println("Please enter Gift Card description: ");
		Scanner gDetails = new Scanner(System.in);
		String gDescription = gDetails.nextLine();
		System.out.println("Please enter GiftCard color: ");
		String gColor = gDetails.nextLine();
		System.out.println("Please enter Gift Card price: ");
		double gPrice = gDetails.nextDouble();
		return new GiftCard(gDescription, gColor, gPrice);
	}
}
