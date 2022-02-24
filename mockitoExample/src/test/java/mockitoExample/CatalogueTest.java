package mockitoExample;

import java.util.List;

import com.fdmgroup.controller.Catalogue;
import com.fdmgroup.controller.ReadItemCommandObject;
import com.fdmgroup.controller.WriteItemCommandObject;
import com.fdmgroup.model.Book;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class CatalogueTest {
	Catalogue catalogue;
	ReadItemCommandObject rec;
	List<Book> books;
	WriteItemCommandObject wic;
	Book book;
	
	@Before
	public void init() {
		
		catalogue = new Catalogue();
		rec = mock(ReadItemCommandObject.class);
		catalogue.setRec(rec);
		books = mock(List.class);
		wic = mock(WriteItemCommandObject.class);
		
		catalogue.setWic(wic);
		book = new Book();
	}
	
	//If we ask the catalogue to give us a list of all items when there are none, it should return an empty list.
	@Test
	public void test_getAllBooks_ifNoBooksAreInTheCatalogue() {
		List<Book> booksInCatalogue = catalogue.getAllBooks();
		assertEquals(0, booksInCatalogue.size());
	}
	
	//When we make a call to the getAllBooks method, it should make a call to the readAll method of the ReadItemCommand.
	@Test
	public void test_GetAllBooks_CallsReadAllMethodOfReadItemCommand_WhenCalled() {
		catalogue.getAllBooks();
		verify(rec, times(1)).readAll();
	}
	
	//If we make a call to getAllBooks command and it receives a List of books from the readAll method of the ReadItemCommand, it should return that same List.
	@Test
	public void test_GetAllBooks_ReturnsListOfBooksItReceivesFromReadAllMethodOfReadItemCommand_WhenCalled() {
		
		when(rec.readAll()).thenReturn(books);
		List<Book> booksInCatalogue = catalogue.getAllBooks();
		assertEquals(books, booksInCatalogue);
	}
	
	//The add book method of Catalogue should make a call to the insertItem method of WriteItemCommand
	@Test
	public void test_AddBook_CallsInsertItemMethodOfWriteItemCommand_WhenCalled() {
		catalogue.addBook(book);
		verify(wic, times(1)).insertItem((Book) any()); //(Book) any() is any instances of the class Book
	}

	//The add book method of Catalogue should pass the book it is given to the insertItem method of WriteItemCommand.
	@Test
	public void test_AddBook_CallsInsertItemMethodOfWriteItemCommandWithThePassedBookObject_WhenCalled() {
		catalogue.addBook(book);
		verify(wic, times(1)).insertItem(book);
	}
}
