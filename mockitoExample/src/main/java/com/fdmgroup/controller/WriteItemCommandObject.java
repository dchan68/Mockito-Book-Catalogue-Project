package com.fdmgroup.controller;

import com.fdmgroup.model.Book;

public interface WriteItemCommandObject {
	
	void insertItem(Book book);
}
