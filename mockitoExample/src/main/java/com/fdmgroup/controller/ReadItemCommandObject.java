package com.fdmgroup.controller;

import java.util.List;

import com.fdmgroup.model.Book;

public interface ReadItemCommandObject {
	
	List<Book> readAll();
}

