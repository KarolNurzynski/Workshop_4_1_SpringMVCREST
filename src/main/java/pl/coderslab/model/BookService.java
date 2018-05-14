package pl.coderslab.model;

import java.util.List;

public interface BookService {

    List<Book> getList();

    void setList(List<Book> list);

    Book getBookById(long id);

    void addBook(Book book);

    void editBook(Book book);

    void deleteBook(long id);

}
