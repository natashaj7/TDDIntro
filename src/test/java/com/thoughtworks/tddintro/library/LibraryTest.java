package com.thoughtworks.tddintro.library;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class LibraryTest {
    private List<String> books;
    private String title;
    private String title2;
    private PrintStream printStream;
    private Library library;
    DateTimeFormatter dateTimeFormatter;
    /*

        List books tests. Implement the first three tests for the Verify exercise

     */

    @Before
    public void setUp() throws Exception{
        books = new ArrayList<>();
        printStream = mock(PrintStream.class);
        dateTimeFormatter = mock(DateTimeFormatter.class);
    }


    @Test
    public void shouldPrintBookTitleWhenThereIsOneBook() {
        title = "Book Title";
        books.add(title);
        library = new Library(books, printStream, null);
        library.listBooks();
        verify(printStream).println("Book Title");
    }

    @Test
    public void shouldPrintNothingWhenThereAreNoBooks() {
        library = new Library(books, printStream, null);
        library.listBooks();
        verifyZeroInteractions(printStream);
    }

    @Test
    public void shouldPrintBothBookTitlesWhenThereAreTwoBooks() {
        title = "Book Title";
        title2 = "Book Title2";
        books.add(title);
        books.add(title2);
        library = new Library(books, printStream, null);
        library.listBooks();
        verify(printStream).println("Book Title");
        verify(printStream).println("Book Title2");

    }

    /*

        Welcome message tests. Implement these tests for the when/thenReturn exercise

     */

    
    // This one is done for you
    @Test
    public void shouldWelcomeUser() {
        library = new Library(books, printStream, dateTimeFormatter);

        // We don't need to mock DateTime because it is a value object
        // We can't mock it because it is a final class
        DateTime time = new DateTime();
        
        library.welcome(time);
        
        verify(printStream).println(contains("Welcome"));
    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsAnEmptyString() {
        DateTime time = new DateTime();

        when(dateTimeFormatter.print(time)).thenReturn("");

        library = new Library(books, printStream, dateTimeFormatter);

        library.welcome(time);

        verify(printStream).println("Welcome to the library! The current time is ");
        //the program doesn't actually display the formatted time. Verified that it prints the empty string
    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsNotEmpty() {
        DateTime time = new DateTime();
        when(dateTimeFormatter.print(time)).thenReturn("2014-11-07 12:33:32");

        library = new Library(books, printStream, dateTimeFormatter);

        library.welcome(time);

        verify(printStream).println("Welcome to the library! The current time is 2014-11-07 12:33:32");
    }
}