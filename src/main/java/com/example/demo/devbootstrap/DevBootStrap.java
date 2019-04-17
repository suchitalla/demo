package com.example.demo.devbootstrap;

import java.util.ArrayList;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.model.Publisher;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.repositories.BookRepository;
import com.example.demo.repositories.PublisherRepository;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent>{
	
	AuthorRepository ar;
	PublisherRepository pr;
	public DevBootStrap(AuthorRepository ar, BookRepository br,PublisherRepository pr) {
		super();
		this.ar = ar;
		this.br = br;
		this.pr = pr;
	}

	BookRepository br;
	

	private void initData()
	{
		ArrayList<Author> auths = new ArrayList<>();
		ArrayList<Book> books = new ArrayList<>();
		ArrayList<Publisher> pub = new ArrayList<>();
		Author auth1 = new Author("Eric","Gatenby");
		Publisher p1 = new Publisher("Collins","streetsville");
		Book book1 = new Book("domain","1234",p1);
		auth1.getBooks().add(book1);
		book1.getAuthors().add(auth1);
		auths.add(auth1);
		pub.add(p1);
		books.add(book1);
		
		Author auth2 = new Author("Derick","Teram");
		Publisher p2 = new Publisher("harper","streetsville");
		Book book2 = new Book("classes","1235",p2);
		auth2.getBooks().add(book2);
	
		book2.getAuthors().add(auth2);
		auths.add(auth2);
		pub.add(p2);
		books.add(book2);
		
		ar.saveAll(auths);
		pr.saveAll(pub);
		br.saveAll(books);
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();
		
	}
}
