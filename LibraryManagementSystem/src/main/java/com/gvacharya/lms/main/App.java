package com.gvacharya.lms.main;

import com.gvacharya.lms.main.authordao.AuthorDAO;
import com.gvacharya.lms.main.authors.Authors;
import com.gvacharya.lms.main.book.Book;
import com.gvacharya.lms.main.bookdao.BookDAO;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	AuthorDAO authorService = new AuthorDAO();
    	BookDAO bookService = new BookDAO();
  	
//    	Authors authors = new Authors();
//    	authors.setName("J.J. Tolkein");
//    	authorService.saveAuthor(authors);
//    	
//    	Book book1 = new Book();
//    	book1.setTitle("Harry Potter and the Chamber of Secrets");
//    	book1.setIsbn(9320776929L);
//    	book1.getAuthors().add(authors);
//    	bookService.saveBook(book1);
//    	book1.setTitle("Nahi pata kya naam tha");
//    	bookService.updateBook(book1);
    	
    	
    	Book book2 = bookService.getBooks(1);
    	System.out.println("Book Id: " + book2.getId());
    	System.out.println("Book Name: " + book2.getTitle());
    	System.out.println("Book isbn: " + book2.getIsbn());
    	
    	Authors author = authorService.getAuthors(1);
    	System.out.println("Book Author: " + author.getName());
    	
       
        
    }
}
