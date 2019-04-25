package com.netcracker.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.netcracker.shared.book.Book;

import java.util.ArrayList;

public interface GenServiceAsync {
    /**
     * Utility/Convenience class.
     * Use GenService.App.getInstance() to access static instance of GenServiceAsync
     */
    void addRow(Book book,boolean kolStrSort, AsyncCallback<ArrayList<Book>> async);
    void deleteBook(Book book, boolean kolStrSort, AsyncCallback<ArrayList<Book>> async);
    void changeBook(Book oldBook, Book newBook, boolean kolStrSort, AsyncCallback<ArrayList<Book>> async);
    void reloadTable(Integer size, boolean kolStrSort, AsyncCallback<ArrayList<Book>> async);
    void getBookArray(Integer firstElem, Integer size, AsyncCallback<ArrayList<Book>> async);
    void goToPage(int page, int size, boolean kolStrSort, AsyncCallback<ArrayList<Book>> async);
    void goToFirstPage(int size, boolean kolStrSort, AsyncCallback<ArrayList<Book>> async);
    void goToLastPage(int size, boolean kolStrSort, AsyncCallback<ArrayList<Book>> async);
}
