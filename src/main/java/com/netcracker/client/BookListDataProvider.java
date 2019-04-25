package com.netcracker.client;

import com.google.gwt.view.client.ListDataProvider;
import com.netcracker.shared.book.Book;
import java.util.ArrayList;

public class BookListDataProvider extends ListDataProvider {
    private BookTable bookTable;
    public BookListDataProvider(BookTable bookTable)
    {
        this.bookTable = bookTable;
        addDataDisplay(this.bookTable);
    }
    public void addBook(Book book)
    {
        getList().add(book);
    }
    public void reloadTable(ArrayList<Book> books)
    {
        getList().clear();
        for(Book book:books)
        {
            getList().add(book);
        }
    }
}
