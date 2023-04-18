package books.BookApplication.service;

import books.BookApplication.data.BookRepository;
import books.BookApplication.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    public void addBook(Book book){
        bookRepository.save(book);
    }

    public void updateBook(Book book){
        bookRepository.save(book);
    }

    public Book getBook(String isbn){
        return bookRepository.getBook(isbn);
    }

    public void delete(String isbn){
        bookRepository.delete(isbn);
    }

    public Collection<Book> getAllBooks(){
        return bookRepository.getAllBooks();
    }
}
