package com.netcracker.client;

import com.google.gwt.cell.client.DateCell;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import com.netcracker.shared.author.Author;
import com.netcracker.shared.book.Book;
import com.netcracker.shared.structures.Date;

import java.util.Arrays;
import java.util.List;

public class BookTable extends CellTable {
    private static Book selectedBook;
    private SingleSelectionModel<Book> selectionModel;
    public BookTable()
    {
        selectedBook = new Book(-1,new Author("",
                "",
                ""),
                "",
                -1,
                new Date("01.01.1111"),
                new Date("01.01.1112"));
        setKeyboardSelectionPolicy(HasKeyboardSelectionPolicy.KeyboardSelectionPolicy.ENABLED);
        setAutoHeaderRefreshDisabled(true);
        setAutoFooterRefreshDisabled(true);
        addColumn(idColumn(),"ID");
        addColumn(authorColumn(),"AUTHOR");
        addColumn(nameColumn(),"NAME");
        addColumn(kolStrColumn(),"KOLSTR");
        addColumn(dateIsdColumn(), "DATEISD");
        addColumn(dateAddColumn(), "DATEADD");
        selectionModel = selectionModel();
        setSelectionModel(selectionModel);
        //setWidth("100%",false);
    }

    private static TextColumn<Book> idColumn()
    {
        return new TextColumn<Book>() {
                    @Override
                    public String getValue(Book object) {
                        return ""+object.getId();
                    }
                };
    }

    private static TextColumn<Book> authorColumn()
    {
        return new TextColumn<Book>() {
            @Override
            public String getValue(Book object) {
                return object.getAuthor().toString();
            }
        };
    }

    private static TextColumn<Book> nameColumn()
    {
        return new TextColumn<Book>() {
            @Override
            public String getValue(Book object) {
                return object.getName();
            }
        };
    }

    private static TextColumn<Book> kolStrColumn()
    {
        return new TextColumn<Book>() {
            @Override
            public String getValue(Book object) {
                return ""+object.getKolStr();
            }
        };
    }

    private static TextColumn<Book> dateIsdColumn()
    {
        return new TextColumn<Book>() {
            @Override
            public String getValue(Book object) {
                return object.getDateIsd().toString();
            }
        };
    }

    private static TextColumn<Book> dateAddColumn()
    {
        return new TextColumn<Book>() {
            @Override
            public String getValue(Book object) {
                return object.getDateAdd().toString();
            }
        };
    }

    private static SingleSelectionModel<Book> selectionModel()
    {
        final SingleSelectionModel<Book> selectionModel
                = new SingleSelectionModel<Book>();
        selectionModel.addSelectionChangeHandler(
                new SelectionChangeEvent.Handler() {
                    public void onSelectionChange(SelectionChangeEvent event) {
                        Book selected = selectionModel.getSelectedObject();
                        if (selected != null) {

                            //Window.alert("You selected: " + selected.getId());
                            selectedBook = selected;
                        }
                    }
                });
        return selectionModel;
    }

    public void clearSelectionModule()
    {
        selectionModel.clear();
    }

    public Book getSelectedBook()
    {
        return selectedBook;
    }
}
