package com.netcracker.server;

import com.netcracker.shared.author.Author;
import com.netcracker.shared.book.Book;
import com.netcracker.shared.structures.Date;

import java.io.File;
import java.util.ArrayList;

public class BookBSD {
    private final static String workDir = System.getProperty("user.dir");
    private final static String fileDirectoryName = workDir + File.separator;
    private final static String fileName = "BookBSD";
    public final static String fileFullName = fileDirectoryName+fileName;

    public final static ArrayList<Book> books;

    static {
        books = new ArrayList<>();
        books.add(new Book(1,new Author("LeoTolstoy",
                "m",
                "leo_tolstoy@mail.ru"),
                "WarAndPeace",
                1274,
                new Date("01.01.1869"),
                new Date("07.05.1997")));
        books.add(new Book(2,new Author("GeorgeRaymondRichardMartin",
                "m",
                "george_raymond_richard_martin@mail.ru"),
                "AGameOfThrones",
                9999,
                new Date("01.01.1996"),
                new Date("07.05.1997")));
        books.add(new Book(3,new Author("StephenEdwinKing",
                "m",
                "stephen_edwin_king@mail.ru"),
                "TheGreenMile",
                448,
                new Date("01.01.1996"),
                new Date("07.05.1997")));
        books.add(new Book(4,new Author("StephenEdwinKing",
                "m",
                "stephen_edwin_king@mail.ru"),
                "TheStand",
                246,
                new Date("01.01.1978"),
                new Date("07.05.1997")));
        books.add(new Book(5,new Author("WilliamShakespeare",
                "m",
                "william_shakespeare@mail.ru"),
                "VenusAndAdonis",
                464,
                new Date("01.01.1593"),
                new Date("07.05.1997")));
        books.add(new Book(6,new Author("FyodorDostoyevsky",
                "m",
                "fyodor_dostoyevsky@mail.ru"),
                "TheIdiot",
                520,
                new Date("01.01.1868"),
                new Date("07.05.1997")));
        books.add(new Book(7,new Author("AlexanderPushkin",
                "m",
                "alexander_pushkin@mail.ru"),
                "K***",
                1,
                new Date("01.01.1825"),
                new Date("07.05.1997")));
    }
}
