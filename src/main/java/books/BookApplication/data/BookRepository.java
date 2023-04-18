package books.BookApplication.data;

import books.BookApplication.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class BookRepository {
   private Map<String, Book> books = new HashMap<String, Book>();

   public void save(Book book){
       books.put(book.getIsbn(),book);
   }

   public void delete(String isbn){
       books.remove(isbn);
   }

   public Book getBook( String isbn){
     return books.get(isbn);
   }

   public Collection<Book> getAllBooks(){
       return books.values();
   }

}
