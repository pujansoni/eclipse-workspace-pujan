import java.util.*;
public class StreamLibrary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Here we can add any number of filter methods to filter our data and store it in the stream and at the end use the eager method forEach to print the data
//		The stream is efficient compare to forEach because in forEach our code will be more lengthly
		ArrayList<Book> books = populateLibrary();
		books.stream().filter(book -> {
			return book.getAuthor().startsWith("J");
		}).filter(book -> {
			return book.getTitle().startsWith("E");
		}).forEach(System.out::println);
		
		System.out.println("=====================");
//		It is ideal to use the stream method when we are dealing with the small amount of data, but when we have a large dataset then the parallelStream method should be used
		books.parallelStream().filter(book -> {
			return book.getAuthor().startsWith("J");
		}).forEach(System.out::println);
	}
	
	static ArrayList<Book> populateLibrary(){
		ArrayList<Book> books = new ArrayList();
        books.add(new Book("Alice Walker", "The Color Purple"));
        books.add(new Book("Alice Walker", "Meridian"));
        books.add(new Book("Toni Morrison", "Beloved"));
        books.add(new Book("Toni Morrison", "Jazz"));
        books.add(new Book("Toni Morrison", "Paradise"));
        books.add(new Book("John Steinbeck", "The Grapes of Wrath"));
        books.add(new Book("John Steinbeck", "East of Eden"));
        books.add(new Book("Kazuo Ishiguro", "The Remains of the Day"));
        books.add(new Book("Kazuo Ishiguro", "Never Let Me Go"));
        books.add(new Book("Kazuo Ishiguro", "The Buried Giant"));
        books.add(new Book("Jane Austen", "Pride and Prejudice"));
        books.add(new Book("Jane Austen", "Emma"));
        books.add(new Book("Jane Austen", "Persuasion"));
        books.add(new Book("Jane Austen", "Mansfield Park"));
        books.add(new Book("Chinua Achebe", "Things Fall Apart"));
        books.add(new Book("Chinua Achebe", "No Longer at Ease"));
        books.add(new Book("Chinua Achebe", "Home and Exile"));
        return books;
	}

}
