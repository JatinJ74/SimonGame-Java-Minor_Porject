package com.gvacharya.lms.main.authors;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.gvacharya.lms.main.book.Book;

@Entity
public class Authors {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="author_id")
	private int id;
	
	@Column(name="author_name")
	private String name;
	
	@ManyToMany(cascade=CascadeType.ALL, mappedBy="authors")
	private Set<Book> book = new HashSet<>();

	public Authors() {
		super();
	}

	public Authors(int id, String name, Set<Book> book) {
		super();
		this.id = id;
		this.name = name;
		this.book = book;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Book> getBook() {
		return book;
	}

	public void setBook(Set<Book> book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "Authors [id=" + id + ", name=" + name + ", book=" + book + "]";
	}
	
}
