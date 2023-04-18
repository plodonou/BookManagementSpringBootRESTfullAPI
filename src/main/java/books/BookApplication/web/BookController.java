package books.BookApplication.web;

import books.BookApplication.domain.Book;
import books.BookApplication.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("books")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        bookService.addBook(book);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @PutMapping("books/{isbn}")
    public ResponseEntity<?> update(@PathVariable String isbn, @RequestBody Book book){
        bookService.updateBook(book);
        return new ResponseEntity<Book>(book,HttpStatus.OK);

    }

    @GetMapping("books/{isbn}")
    public ResponseEntity<?> getBook(@PathVariable String isbn){
       Book book = bookService.getBook(isbn);
       if (book == null){
           return new ResponseEntity<CustomErrorType>(new CustomErrorType("the book = "+ isbn + " is not exist"), HttpStatus.NOT_FOUND);
       }

       bookService.updateBook(book);
       return new ResponseEntity<>(book,HttpStatus.OK);

    }

    @GetMapping("books")
    public ResponseEntity<Books> getAllBooks() {
        Books books = new Books(bookService.getAllBooks());
        return new ResponseEntity<Books>(books, HttpStatus.OK);
    }

    @DeleteMapping("books/{isbn}")
    public ResponseEntity<?> deleteBook(@PathVariable String isbn){
        Book book = bookService.getBook(isbn);
        if (book == null){
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("the book = "+ isbn + " is not exist"), HttpStatus.NOT_FOUND);
        }

        bookService.delete(isbn);
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);

    }
}
