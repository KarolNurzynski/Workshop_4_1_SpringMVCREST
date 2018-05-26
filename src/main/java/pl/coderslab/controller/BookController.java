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

    @GetMapping("/")
    public List<Book> listOfBooks() {
        return memoryBookService.getList();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable long id) {
        return memoryBookService.getBookById(id);
    }

//    @PostMapping("/")
//    public void addBook(@RequestParam long id,
//                        @RequestParam String isbn,
//                        @RequestParam String title,
//                        @RequestParam String author,
//                        @RequestParam String publisher,
//                        @RequestParam String type) {
//        Book book = new Book(id,isbn,title,author,publisher,type);
//        memoryBookService.addBook(book);
//}

    // Sprawdzam postmanem: requestbody parsuje jsony/dane z formularza do obiektow (niestety z formularzem mi nie zadzialalo - prawdopodobnie trzeba ustawic odpowiedni header w formularzu)
    @PostMapping("/")
    public void addBook(@RequestBody Book book)
    {
        memoryBookService.addBook(book);
    }

//    http://localhost:8080/books/editBook?id=1&isbn=123&title=tit&author=aut&publisher=pub&type=typ

//    @PutMapping("/{id}")
//    public void editBook(@RequestParam long id,
//                        @RequestParam String isbn,
//                        @RequestParam String title,
//                        @RequestParam String author,
//                        @RequestParam String publisher,
//                        @RequestParam String type) {
//
//        Book book = new Book(id, isbn, title, author, publisher, type);
//        memoryBookService.editBook(book);
//    }

    @PutMapping("/{id}")
    public void editBook(@RequestBody Book book) {
        memoryBookService.editBook(book);
    }


    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable long id) {
        memoryBookService.deleteBook(id);
    }

}
