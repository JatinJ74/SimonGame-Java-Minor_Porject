package com.gvacharya.lms.main.book;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import com.gvacharya.lms.main.authors.Authors;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="book_id")
	private int id;
	
	@Column(name="book_title")
	private String title;
	
	@Column(name="book_isbn")
	private long isbn;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="book_authors", 
				joinColumns = @JoinColumn(name="book_id"),
				inverseJoinColumns = @JoinColumn(name="author_id"))
	private Set<Authors> authors = new HashSet<>();

	public Book() {
		super();
	}
	
	public Book(int id, String title, long isbn, Set<Authors> authors) {
		super();
		this.id = id;
		this.title = title;
		this.isbn = isbn;
		this.authors = authors;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public Set<Authors> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Authors> authors) {
		this.authors = authors;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", isbn=" + isbn + ", authors=" + authors + "]";
	}

	
}
