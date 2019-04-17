package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;

@Entity
public class Book {
public Book() {
		super();
	}
public Book(String title, String isbn, Publisher publisher) {
		super();
		this.title = title;
		this.isbn = isbn;
		this.publisher = publisher;
	}
public Book(String title, String isbn, Publisher publisher, Set<Author> authors) {
		super();
		this.title = title;
		this.isbn = isbn;
		this.publisher = publisher;
		this.authors = authors;
	}
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
public long id;
public String title;
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getIsbn() {
	return isbn;
}
public void setIsbn(String isbn) {
	this.isbn = isbn;
}
public Publisher getPublisher() {
	return publisher;
}
public void setPublisher(Publisher publisher) {
	this.publisher = publisher;
}
public Set<Author> getAuthors() {
	return authors;
}
public void setAuthors(Set<Author> authors) {
	this.authors = authors;
}
@Override
public String toString() {
	return "Book [id=" + id + ", title=" + title + ", isbn=" + isbn + ", publisher=" + publisher + ", authors="
			+ authors + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (int) (id ^ (id >>> 32));
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Book other = (Book) obj;
	if (id != other.id)
		return false;
	return true;
}
private String isbn;

@OneToOne
public Publisher publisher;
@ManyToMany
@JoinTable(name="author_book",joinColumns = @JoinColumn(name="book_id") , inverseJoinColumns= @JoinColumn(name="author_id"))
public Set<Author> authors = new HashSet<>();
	
}
