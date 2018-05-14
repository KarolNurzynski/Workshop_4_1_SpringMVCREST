package pl.coderslab.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemoryBookService implements BookService {

    private List<Book> list;

    public MemoryBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel",
                "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz glowa, Java.",
                "Sierra Kathy, Bates Bert", "Helion", "programming"));
        list.add(new Book(3L, "9780130819338", "Java 2. Podstawy",
                "Cay Horstmann, Gary Cornell", "Helion", "programming"));
    }


    @Override
    public List<Book> getList() {
//        BookDao bookDao = new BookDao();
//        return bookDao.readAll();
        return list;
    }

    @Override
    public void setList(List<Book> list) {
        this.list = list;
    }

    @Override
    public Book getBookById(long id) {
        Book returnBook = null;
        for (Book book:list) {
            if (book.getId()==id) {
                returnBook = book;
            }
        }
        return returnBook;
    }

    @Override
    public void addBook(Book book) {
        list.add(book);
    }

    @Override
    public void editBook(Book book) {
        long id = book.getId();
        list.set((int) id,book);
    }

    @Override
    public void deleteBook(long id) {
        list.remove((int) id);
    }

}
