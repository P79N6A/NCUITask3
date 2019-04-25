package com.netcracker.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.google.gwt.core.client.GWT;
import com.netcracker.shared.book.Book;

import java.util.ArrayList;

@RemoteServiceRelativePath("GenService")
public interface GenService extends RemoteService {
    /**
     * Utility/Convenience class.
     * Use GenService.App.getInstance() to access static instance of GenServiceAsync
     */
    ArrayList<Book> addRow(Book book, boolean kolStrSort);

    ArrayList<Book> getBookArray(Integer firstElem, Integer size);

    ArrayList<Book> reloadTable(Integer size, boolean kolStrSort);

    ArrayList<Book> goToPage(int page, int size, boolean kolStrSort);

    ArrayList<Book> goToFirstPage(int size, boolean kolStrSort);

    ArrayList<Book> goToLastPage(int size, boolean kolStrSort);

    ArrayList<Book> deleteBook(Book book, boolean kolStrSort);

    ArrayList<Book> changeBook(Book oldBook, Book newBook, boolean kolStrSort);

    /**
     * Utility/Convenience class.
     * Use GenService.App.getInstance() to access static instance of GenServiceAsync
     */
    public static class App {
        private static final GenServiceAsync ourInstance = (GenServiceAsync) GWT.create(GenService.class);

        public static GenServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
