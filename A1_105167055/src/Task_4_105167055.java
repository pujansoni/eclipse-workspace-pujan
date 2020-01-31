import searchtrees.*;
import java.util.*;

public class Task_4_105167055 {
	static AVLTree<Integer> avlIns = new AVLTree<Integer>();
	static SplayTree<Integer> splayIns = new SplayTree<Integer>();
	static RedBlackBST<Integer, Integer> redIns = new RedBlackBST<Integer, Integer>();
	static BinarySearchTree<Integer> bstIns = new BinarySearchTree<>( );
	static Scanner sc = new Scanner(System.in);
	static final int RECORDS = 100000;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please enter your choice of Search Tree for insert, search and delete operations: ");
		switch(getUserMenu()) {
		case 1:
			getTreeDetails("AVLTree");
			System.out.println(insertInTree(avlIns) + " nanoseconds\t"
					+ searchInTree(avlIns) + " nanoseconds\t" 
					+ removeFromTree(avlIns) + " nanoseconds");
			break;
		case 2:
			getTreeDetails("SplayTree");
			System.out.println(insertInTree(splayIns) + " nanoseconds\t"
					+ searchInTree(splayIns) + " nanoseconds\t" 
					+ removeFromTree(splayIns) + " nanoseconds");
			break;
		case 3:
			getTreeDetails("RedBlackBST");
			System.out.println(insertInTree(redIns) + " nanoseconds\t" 
					+ searchInTree(redIns) + " nanoseconds\t" 
					+ removeFromTree(redIns) + " nanoseconds");
			break;
		case 4:
			getTreeDetails("BinarySearchTree");
			System.out.println(insertInTree(bstIns) + " nanoseconds\t" 
					+ searchInTree(bstIns) + " nanoseconds\t" 
					+ removeFromTree(bstIns) + " nanoseconds");
			break;
		case 5:
			System.out.println("Exiting...");
			return;
		default:
			System.out.println("Please enter a valid input");
		}
	}
	
	static int getUserMenu() {
		System.out.println("1) AVL Tree\n2) Splay Tree\n3) RedBlack BST\n4) BST\n5) Exit");
		return sc.nextInt();
	}
	
	static void getTreeDetails(String treeName) {
		System.out.println(treeName + " details(100000 records)");
		System.out.println("Insert\t\t" + "Search\t\t" + "Delete\t\t");
	}
	
	@SuppressWarnings("unchecked")
	static long insertInTree(Object typeOfSearchTree) {
		long totalTime = 0;
		for( int i = 1; i <= RECORDS; i++) {
			long startTime = 0, endTime = 0;
			if(typeOfSearchTree instanceof AVLTree) {
				startTime = System.nanoTime();
				((AVLTree<Integer>) typeOfSearchTree).insert(i);
				endTime = System.nanoTime();
			} else if(typeOfSearchTree instanceof SplayTree) {
				startTime = System.nanoTime();
				((SplayTree<Integer>) typeOfSearchTree).insert(i);
				endTime = System.nanoTime();
			} else if(typeOfSearchTree instanceof RedBlackBST) {
				startTime = System.nanoTime();
				((RedBlackBST<Integer, Integer>) typeOfSearchTree).put(i, i);
				endTime = System.nanoTime();
			} else if(typeOfSearchTree instanceof BinarySearchTree) {
				startTime = System.nanoTime();
				((BinarySearchTree<Integer>) typeOfSearchTree).insert(i);
				endTime = System.nanoTime();
			}
	    	totalTime += (endTime - startTime);
	    }
		return totalTime/RECORDS;
	}
	
	@SuppressWarnings("unchecked")
	static long searchInTree(Object typeOfSearchTree) {
		long totalTime = 0;
		for( int i = 1; i <= RECORDS; i++) {
	    	int randomInt = getRandomInteger(RECORDS, 1);
	    	long startTime = 0, endTime = 0;
	    	if(typeOfSearchTree instanceof AVLTree) {
	    		startTime = System.nanoTime();
	    		((AVLTree<Integer>) typeOfSearchTree).contains(randomInt);
	    		endTime = System.nanoTime();
	    	} else if(typeOfSearchTree instanceof SplayTree) {
	    		startTime = System.nanoTime();
	    		((SplayTree<Integer>) typeOfSearchTree).contains(randomInt);
	    		endTime = System.nanoTime();
	    	} else if(typeOfSearchTree instanceof RedBlackBST) {
	    		startTime = System.nanoTime();
	    		((RedBlackBST<Integer, Integer>) typeOfSearchTree).get(randomInt);
	    		endTime = System.nanoTime();
	    	} else if(typeOfSearchTree instanceof BinarySearchTree) {
	    		startTime = System.nanoTime();
	    		((BinarySearchTree<Integer>) typeOfSearchTree).contains(randomInt);
	    		endTime = System.nanoTime();
	    	}
	    	totalTime += (endTime - startTime);
	    }
		return totalTime/RECORDS;
	}
	
	@SuppressWarnings("unchecked")
	static long removeFromTree(Object typeOfSearchTree) {
		long totalTime = 0;
		for( int i = RECORDS; i >= 1; i--) {
			long startTime = 0, endTime = 0;
			if(typeOfSearchTree instanceof AVLTree) {
	    		startTime = System.nanoTime();
	    		((AVLTree<Integer>) typeOfSearchTree).remove(i);
	    		endTime = System.nanoTime();
	    	} else if(typeOfSearchTree instanceof SplayTree) {
	    		startTime = System.nanoTime();
	    		((SplayTree<Integer>) typeOfSearchTree).remove(i);
	    		endTime = System.nanoTime();
	    	} else if(typeOfSearchTree instanceof RedBlackBST) {
	    		startTime = System.nanoTime();
	    		((RedBlackBST<Integer, Integer>) typeOfSearchTree).delete(i);
	    		endTime = System.nanoTime();
	    	} else if(typeOfSearchTree instanceof BinarySearchTree) {
	    		startTime = System.nanoTime();
	    		((BinarySearchTree<Integer>) typeOfSearchTree).remove(i);
	    		endTime = System.nanoTime();
	    	}
	    	totalTime += (endTime - startTime);
	    }
		return totalTime/RECORDS;
	}
	
	// returns random integer between minimum and maximum range
    public static int getRandomInteger(int maximum, int minimum){
        return ((int) (Math.random()*(maximum - minimum))) + minimum;
    }
}