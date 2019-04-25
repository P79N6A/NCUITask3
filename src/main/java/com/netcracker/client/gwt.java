package com.netcracker.client;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.netcracker.client.validator.Validator;
import com.netcracker.shared.author.Author;
import com.netcracker.shared.book.Book;
import com.netcracker.shared.structures.Date;

import java.util.ArrayList;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class gwt implements EntryPoint {
    /**
     * The message displayed to the user when the server cannot be reached or
     * returns an error.
     */

    private static final String SERVER_ERROR = "An error occurred while "
            + "attempting to contact the server. Please check your network "
            + "connection and try again.";

    /**
     * This is the entry point method.
     */

    public void onModuleLoad() {
        // Create a CellTable.
        BookTable bookTable = new BookTable();
        TablePageControl pageControl = new TablePageControl(0, 5);
        bookTable.setPageSize(pageControl.getPageSize());
        BookListDataProvider bookProvider = new BookListDataProvider(bookTable);
        final boolean[] sort = new boolean[1];
        CheckBox sortBox = new CheckBox("KolStr: sort(on)/no sort(off)");
        sortBox.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                if (sortBox.getValue()) sort[0] = true;
                else sort[0] = false;
            }
        });
        GenService.App.getInstance().reloadTable(pageControl.getPageSize(), sort[0], new AsyncCallback<ArrayList<Book>>() {
            @Override
            public void onFailure(Throwable throwable) {

            }

            @Override
            public void onSuccess(ArrayList<Book> books) {
                bookProvider.reloadTable(books);
            }
        });

        Button buttonNextPage = new Button("NextPage");
        buttonNextPage.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                GenService.App.getInstance().goToPage(pageControl.nextPage(), pageControl.getPageSize(), sort[0], new AsyncCallback<ArrayList<Book>>() {
                    @Override
                    public void onFailure(Throwable throwable) {

                    }

                    @Override
                    public void onSuccess(ArrayList<Book> books) {
                        bookProvider.reloadTable(books);
                    }
                });
            }
        });
        Button buttonPrevPage = new Button("PrevPage");
        buttonPrevPage.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                GenService.App.getInstance().goToPage(pageControl.prevPage(), pageControl.getPageSize(), sort[0], new AsyncCallback<ArrayList<Book>>() {
                    @Override
                    public void onFailure(Throwable throwable) {

                    }

                    @Override
                    public void onSuccess(ArrayList<Book> books) {
                        bookProvider.reloadTable(books);
                    }
                });
            }
        });
        Button buttonFirstPage = new Button("FirstPage");
        buttonFirstPage.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                pageControl.firstPage();
                GenService.App.getInstance().goToFirstPage(pageControl.getPageSize(), sort[0], new AsyncCallback<ArrayList<Book>>() {
                    @Override
                    public void onFailure(Throwable throwable) {

                    }

                    @Override
                    public void onSuccess(ArrayList<Book> books) {
                        bookProvider.reloadTable(books);
                    }
                });
            }
        });
        Button buttonLastPage = new Button("LastPage");
        buttonLastPage.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                GenService.App.getInstance().goToLastPage(pageControl.getPageSize(), sort[0], new AsyncCallback<ArrayList<Book>>() {
                    @Override
                    public void onFailure(Throwable throwable) {

                    }

                    @Override
                    public void onSuccess(ArrayList<Book> books) {
                        bookProvider.reloadTable(books);
                    }
                });
            }
        });
        //Add Row
        VerticalPanel panelAddRow = new VerticalPanel();

        Label labelAuthorName = new Label("AuthorName: ");
        TextBox textBoxAuthorName = new TextBox();
        textBoxAuthorName.setText("Arni");
        HorizontalPanel panelAuthorName = new HorizontalPanel();
        panelAuthorName.add(labelAuthorName);
        panelAuthorName.add(textBoxAuthorName);
        panelAuthorName.setSpacing(7);

        Label labelAuthorGender = new Label("AuthorGender: ");
        TextBox textBoxAuthorGender = new TextBox();
        textBoxAuthorGender.setText("m");
        HorizontalPanel panelAuthorGender = new HorizontalPanel();
        panelAuthorGender.add(labelAuthorGender);
        panelAuthorGender.add(textBoxAuthorGender);
        panelAuthorGender.setSpacing(7);

        Label labelAuthorEmail = new Label("AuthorEmail: ");
        TextBox textBoxAuthorEmail = new TextBox();
        textBoxAuthorEmail.setText("Arni@mail.ru");
        HorizontalPanel panelAuthorEmail = new HorizontalPanel();
        panelAuthorEmail.add(labelAuthorEmail);
        panelAuthorEmail.add(textBoxAuthorEmail);
        panelAuthorEmail.setSpacing(7);

        Label labelBookName = new Label("BookName: ");
        TextBox textBoxBookName = new TextBox();
        textBoxBookName.setText("HelloWorld");
        HorizontalPanel panelBookName = new HorizontalPanel();
        panelBookName.add(labelBookName);
        panelBookName.add(textBoxBookName);
        panelBookName.setSpacing(7);

        Label labelBookKolStr = new Label("BookKolStr: ");
        TextBox textBoxBookKolStr = new TextBox();
        textBoxBookKolStr.setText("1234");
        HorizontalPanel panelBookKolStr = new HorizontalPanel();
        panelBookKolStr.add(labelBookKolStr);
        panelBookKolStr.add(textBoxBookKolStr);
        panelBookKolStr.setSpacing(7);

        Label labelBookDateIsd = new Label("BookDateIsd: ");
        TextBox textBoxBookDateIsd = new TextBox();
        textBoxBookDateIsd.setText("01.01.1925");
        HorizontalPanel panelBookDateIsd = new HorizontalPanel();
        panelBookDateIsd.add(labelBookDateIsd);
        panelBookDateIsd.add(textBoxBookDateIsd);
        panelBookDateIsd.setSpacing(7);

        Label labelBookDateAdd = new Label("BookDateAdd: ");
        TextBox textBoxBookDateAdd = new TextBox();
        textBoxBookDateAdd.setText("07.05.1997");
        HorizontalPanel panelBookDateAdd = new HorizontalPanel();
        panelBookDateAdd.add(labelBookDateAdd);
        panelBookDateAdd.add(textBoxBookDateAdd);
        panelBookDateAdd.setSpacing(7);

        Label labelValidator = new Label("Validator: ");
        TextBox textBoxValidator = new TextBox();
        textBoxValidator.setEnabled(false);
        HorizontalPanel panelValidator = new HorizontalPanel();
        panelValidator.add(labelValidator);
        panelValidator.add(textBoxValidator);

        panelAddRow.add(panelAuthorName);
        panelAddRow.add(panelAuthorGender);
        panelAddRow.add(panelAuthorEmail);
        panelAddRow.add(panelBookName);
        panelAddRow.add(panelBookKolStr);
        panelAddRow.add(panelBookDateIsd);
        panelAddRow.add(panelBookDateAdd);
        panelAddRow.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);

        Button buttonAddRow = new Button("AddRow");
        buttonAddRow.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                String result = Validator.bookValidator(textBoxAuthorName.getText(),
                        textBoxAuthorGender.getText(),
                        textBoxAuthorEmail.getText(),
                        textBoxBookName.getText(),
                        textBoxBookKolStr.getText(),
                        textBoxBookDateIsd.getText(),
                        textBoxBookDateAdd.getText());
                textBoxValidator.setText(result);
                if (textBoxValidator.getText().equals("Success")) {
                    Book book = new Book(-1,
                            new Author(
                                    textBoxAuthorName.getText(),
                                    textBoxAuthorGender.getText(),
                                    textBoxAuthorEmail.getText()
                            ),
                            textBoxBookName.getText(),
                            Integer.parseInt(textBoxBookKolStr.getText()),
                            new Date(textBoxBookDateIsd.getText()),
                            new Date(textBoxBookDateAdd.getText()));
                    GenService.App.getInstance().addRow(book, sort[0], new AsyncCallback<ArrayList<Book>>() {
                        @Override
                        public void onFailure(Throwable throwable) {

                        }

                        @Override
                        public void onSuccess(ArrayList<Book> books) {
                            //Window.alert(book.toString());
                            pageControl.firstPage();
                            bookProvider.reloadTable(books);
                        }
                    });
                }
            }
        });
        Button buttonChangeBook = new Button("ChangeBook");
        buttonChangeBook.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                String result = Validator.bookValidator(textBoxAuthorName.getText(),
                        textBoxAuthorGender.getText(),
                        textBoxAuthorEmail.getText(),
                        textBoxBookName.getText(),
                        textBoxBookKolStr.getText(),
                        textBoxBookDateIsd.getText(),
                        textBoxBookDateAdd.getText());
                textBoxValidator.setText(result);
                if (textBoxValidator.getText().equals("Success")) {
                    Book book = new Book(bookTable.getSelectedBook().getId(),
                            new Author(
                                    textBoxAuthorName.getText(),
                                    textBoxAuthorGender.getText(),
                                    textBoxAuthorEmail.getText()
                            ),
                            textBoxBookName.getText(),
                            Integer.parseInt(textBoxBookKolStr.getText()),
                            new Date(textBoxBookDateIsd.getText()),
                            new Date(textBoxBookDateAdd.getText()));
                    GenService.App.getInstance().changeBook(bookTable.getSelectedBook(), book,sort[0], new AsyncCallback<ArrayList<Book>>() {
                        @Override
                        public void onFailure(Throwable throwable) {

                        }

                        @Override
                        public void onSuccess(ArrayList<Book> books) {
                            pageControl.firstPage();
                            bookProvider.reloadTable(books);
                        }
                    });
                }
            }
        });
        Button buttonDeleteBook = new Button("DeleteBook");
        buttonDeleteBook.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                GenService.App.getInstance().deleteBook(bookTable.getSelectedBook(), sort[0], new AsyncCallback<ArrayList<Book>>() {
                    @Override
                    public void onFailure(Throwable throwable) {

                    }

                    @Override
                    public void onSuccess(ArrayList<Book> books) {
                        pageControl.firstPage();
                        bookProvider.reloadTable(books);
                    }
                });
            }
        });

        FlowPanel mainPanel = new FlowPanel();
        HorizontalPanel sortPanel = new HorizontalPanel();
        sortPanel.add(sortBox);
        sortPanel.setBorderWidth(1);

        VerticalPanel panelTable = new VerticalPanel();
        HorizontalPanel panelPageControl = new HorizontalPanel();

        buttonFirstPage.setWidth("100%");
        buttonPrevPage.setWidth("100%");
        buttonNextPage.setWidth("100%");
        buttonLastPage.setWidth("100%");

        panelPageControl.add(buttonFirstPage);
        panelPageControl.add(buttonPrevPage);
        panelPageControl.add(buttonNextPage);
        panelPageControl.add(buttonLastPage);

        panelPageControl.setWidth("100%");
        panelPageControl.setHeight("100%");
        panelPageControl.setBorderWidth(1);

        VerticalPanel verticalPanel = new VerticalPanel();
        buttonAddRow.setWidth("100%");
        buttonChangeBook.setWidth("100%");
        buttonDeleteBook.setWidth("100%");
        verticalPanel.add(buttonAddRow);
        verticalPanel.add(buttonChangeBook);
        verticalPanel.add(buttonDeleteBook);
        verticalPanel.add(panelValidator);
        verticalPanel.setSpacing(7);
        verticalPanel.setBorderWidth(1);
        verticalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

        bookTable.setWidth("100%");
        panelTable.add(bookTable);
        panelTable.setWidth("100%");
        panelTable.setBorderWidth(5);
        mainPanel.setWidth("100%");
        VerticalPanel secondPanel = new VerticalPanel();
        secondPanel.setWidth("100%");
        secondPanel.setHeight("100%");
        secondPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        secondPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        secondPanel.setSpacing(20);
        secondPanel.add(panelTable);
        secondPanel.add(sortPanel);
        secondPanel.add(panelPageControl);

        HorizontalPanel panelChangeTable = new HorizontalPanel();
        panelChangeTable.add(panelAddRow);
        panelChangeTable.add(verticalPanel);
        panelChangeTable.setBorderWidth(1);
        panelChangeTable.setHeight("100%");
        panelChangeTable.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        panelChangeTable.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        panelChangeTable.setSpacing(10);

        secondPanel.add(panelChangeTable);

        mainPanel.add(secondPanel);


        RootPanel.get().add(mainPanel);
        RootPanel.get().setSize("1024", "768");
    }
}
