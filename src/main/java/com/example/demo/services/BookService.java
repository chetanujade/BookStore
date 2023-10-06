package com.example.demo.services;

//import java.util.ArrayList;
import java.util.List;
//import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BookRepo;
import com.example.demo.entity.Book;

@Service
public class BookService {
	
	@Autowired
	private BookRepo bookRepo;

//	private static   List<Book> list = new ArrayList();
	
	
//	static{
		
//		list.add(new Book (12,"Java Complete Reference", "XYZ"));
//		list.add(new Book (13,"Source of destiny", "ABC"));
//		list.add(new Book (14,"Life of pie", "Brian Lara"));
//		list.add(new Book (15,"Pirates of Carebian", "Captain Jack Sparrow"));
//		list.add(new Book (16,"Inception", "Cristopher Nolen"));
		
//	}
	//get all books
	public List<Book> getAllBooks() {
		
		
		List<Book> list = (List<Book>)this.bookRepo.findAll();
		return list;
		
	}
	
	//get single book
	public Book getBookById(int id) {
		
		
		Book book = null;
		try {
		// book = list.stream().filter(e->e.getId()==id).findFirst().get();
			book = this.bookRepo.findById(id);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return book;
	}
	
	
	
	//adding the book
	public Book addBook(Book b)
	{
		Book result = bookRepo.save(b);
		return result;
	}
	
	
	//Delete the book
	public void deleteBook(int bid)
	{
//		list = list.stream().filter(e->e.getId() !=bid
//		{
//			if(e.getId() != bid)
//			{
//				return true;
//			}
//			else 
//				return false;
//		}
//		).collect(Collectors.toList());
		 bookRepo.deleteById(bid);
	}
	
	public void updateBook( Book book , int bookId )
	{
//		list = list.stream().map(e->{
//			if(e.getId() == bookId) {
//				e.setTitle(book.getTitle());
//				e.setAuthor(book.getAuthor());
//			}
//			return e;
//		}).collect(Collectors.toList());
		
		book.setId(bookId);
		bookRepo.save(book);
	}
}
