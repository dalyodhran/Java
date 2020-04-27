import java.util.*;

public class Book
{
//instance variables
private String title;
private String author;
private double price;

//constructor to initialize book details
public Book(String t, String a, double p)
{
    this.title = t;
    this.author = a;
    this.price = p;
}

//not sure how to implement this
public Book(BookStore b)
{

}

//getter methods
public String getTitle()
{
    return title;
}

public String getAuthor()
{
    return author;
}

public double getPrice()
{
    return price;
}

public String toString()
{
    return (title + ", by " + author + ". Cost: $" + price);
}

//method t find highest priced book
public  static Book  highestPricedBook(ArrayList<Book>  list)
{
    int i, highest=0;
    double high = list.get(0).getPrice(), next = 0;
    for(i=1; i<list.size();i++)
    {
        next = list.get(i).getPrice();
        if (high<next)
        {
            high = next;
            highest = i;
        }
    }
    return list.get(highest);
}


//method to ban and remove a certain book from the inventory
public  static ArrayList<Book>  banBook(ArrayList<Book>  list,  Book  book)
{
    int i=0;
    while(i<list.size())
    {
        if(list.get(i).getTitle().equals(book.getTitle()))
            list.remove(i);
        else
            i++;
    }
    return list;
}

}
