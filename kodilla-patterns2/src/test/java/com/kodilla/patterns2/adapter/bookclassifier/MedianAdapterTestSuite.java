package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MedianAdapterTestSuite {

    @Test
    void publicationYearMedianTest() {
        //Given
        MedianAdapter medianAdapter = new MedianAdapter();
        Set<Book> books = new HashSet<>();
        books.add(new Book("Author1", "Title1", 2023, "Signature1"));
        books.add(new Book("Author2", "Title2", 1994, "Signature2"));
        books.add(new Book("Author3", "Title3", 2012, "Signature3"));

        //When
        int medianYear = medianAdapter.publicationYearMedian(books);

        //Then
        assertEquals(2012, medianYear);
    }
}