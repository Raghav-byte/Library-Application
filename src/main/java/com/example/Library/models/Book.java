package com.example.Library.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Document
public class Book {

    @Id
    private UUID bookId;
    private List<UUID> libraryId = new ArrayList<>();
    private String bookName;
    private String authorName;
    private boolean isTrending;

    public Book() {
        this.bookId=UUID.randomUUID();
    }

    public UUID getBookId() {
        return bookId;
    }

    public void setBookId(UUID bookId) {
        this.bookId = bookId;
    }

    public List<UUID> getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(List<UUID> libraryId) {
        this.libraryId = libraryId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public boolean isTrending() {
        return isTrending;
    }

    public void setTrending(boolean trending) {
        isTrending = trending;
    }
}
