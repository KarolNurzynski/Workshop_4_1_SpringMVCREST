package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.model.MemoryBookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private MemoryBookService memoryBookService;

    @RequestMapping("/hello")
    public String hello(){
        return "{hello: World}";
    }

    @RequestMapping("/helloBook")
    public Book helloBook(){
        return new Book(1L,"9788324631766","Thinking in Java",
                "Bruce Eckel","Helion","programming");
    }

    @RequestMapping("/listOfBooks")
    public List<Book> listOfBooks() {
        System.out.println(memoryBookService.getList().toString());
        return memoryBookService.getList();
    }

    @RequestMapping("/getBookById")
    public Book getBookById(@RequestParam long id) {
        return memoryBookService.getBookById(id);
    }

    @PostMapping("/addBook")
    public void addBook(@RequestParam long id,
                        @RequestParam String isbn,
                        @RequestParam String title,
                        @RequestParam String author,
                        @RequestParam String publisher,
                        @RequestParam String type) {

        Book book = new Book(id, isbn, title, author, publisher, type);
        memoryBookService.addBook(book);
    }

    // OPCJA 3 - wykorzystanie @RequestBody - Spring pobierze dane z HTTP i przeksztalci je na obiekt Javy
//    @PostMapping("/addBook")
//    public void addBook(@RequestBody Book book) {
//        memoryBookService.addBook(book);
//    }

    @PutMapping("/editBook")
    public void editBook(@RequestParam long id,
                        @RequestParam String isbn,
                        @RequestParam String title,
                        @RequestParam String author,
                        @RequestParam String publisher,
                        @RequestParam String type) {

        Book book = new Book(id, isbn, title, author, publisher, type);
        memoryBookService.editBook(book);
    }

    @DeleteMapping("/deleteBook")
    public void deleteBook(@RequestParam long id) {
        memoryBookService.deleteBook(id);
    }

}
