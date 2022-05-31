package com.example.Library.services;

import com.example.Library.models.Book;
import com.example.Library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class BookServices {

    @Autowired
    private BookRepository bookRepository;

    //TO CREATE BOOK
    public Book createBook(Book book) {
        book.setLibraryId(null);
        return bookRepository.save(book);
    }

    //TO SHOW ALL BOOKS
    public List<Book> showAllBooks() {
        return bookRepository.findAll();
    }

    //TO SHOW ONE BOOK
    public Optional<Book> oneBook(UUID bookId) {
        return bookRepository.findById(bookId);
    }

    //TO DELETE BOOK
    public String deleteBook(UUID bookId) {
        bookRepository.deleteById(bookId);
        return "Book Deleted";
    }

    //TO UPDATE BOOK
    public Book updateBook(Book book) {
        AtomicReference<Book> bookAtomicReference = new AtomicReference<>();
        Optional<Book> existingBook =bookRepository.findById(book.getBookId());
        existingBook.ifPresentOrElse(b->{
            b.setBookName(book.getBookName()!=  null ? book.getBookName() : b.getBookName());
            b.setAuthorName(book.getAuthorName()!= null ? book.getAuthorName() : b.getAuthorName());
            bookAtomicReference.set(bookRepository.save(b));
        },()-> {
            try {
                throw new Exception("Book doesn't exist");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        return bookAtomicReference.get();
    }
}
