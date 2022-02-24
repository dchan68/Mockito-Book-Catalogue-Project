package com.fdmgroup.controller;

import com.fdmgroup.model.*;

import java.util.ArrayList;
import java.util.List;

public class Catalogue {
	
	ReadItemCommandObject rec;
	WriteItemCommandObject wic;
	
	List<Book> books = new ArrayList<Book>();
	
	public Catalogue() {
		super();	
	}

	public Catalogue(ReadItemCommandObject rec, WriteItemCommandObject wic, List<Book> books) {
		super();
		this.rec = rec;
		this.wic = wic;
		this.books = books;
	}
	
	public List<Book> getAllBooks(){
		books = rec.readAll();
		return books;
	}
	
	public ReadItemCommandObject getRec() {
		return rec;
	}

	public WriteItemCommandObject getWic() {
		return wic;
	}

	public void setWic(WriteItemCommandObject wic) {
		this.wic = wic;
	}

	public void setRec(ReadItemCommandObject rec) {
		this.rec = rec;
	}
	
	public void addBook(Book book) {
		wic.insertItem(book);
	}
	
}