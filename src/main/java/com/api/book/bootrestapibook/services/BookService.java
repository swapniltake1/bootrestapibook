package com.api.book.bootrestapibook.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.api.book.bootrestapibook.dao.BookRepository;
import com.api.book.bootrestapibook.entities.Book;

@Component
public class BookService {
  
    @Autowired
     private BookRepository bookRepository;
    /* private static List<Book> list = new ArrayList<>();
    static{
        list.add(new Book(1, "React","xyz"));
        list.add(new Book(2, "java","xyz"));
        list.add(new Book(3, "javaScript","abc")); 
        list.add(new Book(4, "Python","anc"));
        list.add(new Book(5, "c++","yz"));
    } */

    // get all books 
    public List<Book> getAllBooks(){
        List<Book> list= (List<Book>) this.bookRepository.findAll();
        return list;
    }

    // get single book by id
    public Book getSingleBook(int id){
        Book book=null;
        try {
          //  book = list.stream().filter(e->e.getId()==id).findFirst().get();
        book= this.bookRepository.findById(id);
        } catch (Exception e) {
            System.out.println("Not Found");
            e.printStackTrace();
        }
          
        return book;
    }

    // Create a book 

    public Book addBook(Book book){
       // list.add(book);
      Book result= bookRepository.save(book);
        return result;
    }

    // Delete book
    public void deleteBook(int bid){
        // Book book=null;
          // book = list.stream().filter(e->e.getId()==bid).findFirst().get();
          // list.remove(book);
          bookRepository.deleteById(bid);
         
    }

    // update book 
    public void updateBook(Book book, int bookId) {

      /*  list = list.stream().map(b->{
       if(b.getId()==bookId)
       {
        b.setTitle(book.getTitle());
         b.setTitle(book.getTitle());
       }
            return b;
        }).collect(Collectors.toList());
 */
            book.setId(bookId);
            bookRepository.save(book);

    }

    


}
