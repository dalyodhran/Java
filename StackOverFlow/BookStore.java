import java.util.*;

public class BookStore
{
//instance variable
public ArrayList<Book> inventory;

//constructor
public BookStore()
{
    this.inventory = new ArrayList<Book>();
}

//method to add a new book to the inventory
public void addBook(Book newBook)
{
  //  String info = newBook.getTitle() + "," + newBook.getAuthor() + ", " +
newBook.getPrice();

    inventory.add(newBook);
}

//method to find total number of books in inventory
public int numBooks()
{
   return inventory.size();
}

//method to find specific book
public Book getBook(int index)
{
    if (index<0 || index>inventory.size())
        return null;
    else
        return inventory.get(index-1);
}

//method to add all book values in the inventory
public double bookstoreValue(BookStore store)
{
    double value=0;
    for(int i=0; i<inventory.size();i++)
    {
        value+= inventory.get(i).getPrice();
    }
    return value;
}

public static void main(String[] args)
{
    //instantiate a Bookstore object
    BookStore store = new BookStore();


    //Add a new Book to the inventory until user decides to stop
    Scanner kb = new Scanner(System.in);
    boolean flag = true;
    System.out.print("Do you want to enter a new book? (y/n): ");
    String reply = kb.nextLine();
    Book b = null;
    while(reply.equalsIgnoreCase("y") && flag == true)
    {
        System.out.print("Enter a title: ");
        String title = kb.nextLine();
        System.out.print("Enter the author: ");
        String author = kb.nextLine();
        System.out.print("Enter the price: ");
        double price = kb.nextDouble();
        kb.nextLine();
        b = new Book(title,author,price);
        store.addBook(b);
        System.out.print("Do you want to enter another book? (y/n): ");
        reply = kb.nextLine();
        if(reply.equalsIgnoreCase("n"))
            flag = false;
    }

    //System.out.println(inventory);
        System.out.println(store);


    //Print the number of books in the inventory
    System.out.println("Inventory has " + store.numBooks() + " books.");

    //Print the title of a book at a particular index.
    System.out.print("\nEnter the book number: ");
    int num = kb.nextInt();
    kb.nextLine();
    System.out.println("Book number " + num + " is: " + store.getBook(num));

    //Print the total value of all books
    System.out.println("\nTotal value of all books is: " +
store.bookstoreValue(store));

    //Print the highest priced book
    System.out.println("\nHighest priced book is " +
Book.highestPricedBook(inventory));

    //Ban a book
    System.out.println("\n" + inventory);
    System.out.print("Enter the title to be banned.");
    String bookName = kb.nextLine();
    Book remB = new Book(bookName,"",0);
    Book.banBook(inventory, remB);
    System.out.println("\nThe modified inventory is below.");
    System.out.println(inventory);


}


}
