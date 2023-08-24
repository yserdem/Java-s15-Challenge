package com.workintech.person;


import com.workintech.data.LibraryRack;
import com.workintech.media.Book;
import com.workintech.media.BookItem;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class Librarian extends Person{
    private int workedForXYears;
    private String graduatedFrom;
    @Builder
    public Librarian(String name, int workedForXYears, String graduatedFrom){
        super(name);
        this.graduatedFrom = graduatedFrom;
        this.workedForXYears = workedForXYears;
    }

    public void addBook(LibraryRack libraryRack, Book book) {
        libraryRack.getBooksByTitle().put(book.getTitle(), book);

        libraryRack.getBooksByISBN().put(book.getIsbn(), book);

        //add book to a new list, then update catalog
        List<Book> booksInCategory = libraryRack.getBooksByCategory().get(book.getCategory());
        booksInCategory.add(book);
        libraryRack.getBooksByCategory().put(book.getCategory(), booksInCategory);

        //reach author's books from Author
        book.getAuthor().getBooksPublished().add(book);
        libraryRack.getBooksByAuthor().put(book.getAuthor().getName(), book.getAuthor().getBooksPublished());

        if (!libraryRack.getAuthors().contains(book.getAuthor())) {
            libraryRack.getAuthors().add(book.getAuthor());
        }


    }

    //TODO update this method!!!
    public void updateBook(LibraryRack libraryRack, Book book) {
        if (libraryRack.getBooksByISBN().containsKey(book.getIsbn())) {
            //update booksByCategory
            List<Book> booksInCategory = libraryRack.getBooksByCategory().get(book.getCategory());
            System.out.println(booksInCategory);
            booksInCategory.remove(booksInCategory.get(booksInCategory.indexOf(book)));
            booksInCategory.add(book);
            libraryRack.getBooksByCategory().put(book.getCategory(), booksInCategory);

            //update booksByAuthor
            List<Book> booksInAuthor = libraryRack.getBooksByAuthor().get(book.getAuthor().getName());
            booksInAuthor.remove(booksInAuthor.get(booksInAuthor.indexOf(book)));
            booksInAuthor.add(book);
            libraryRack.getBooksByAuthor().put(book.getAuthor().getName(), booksInAuthor);
            //update bookList in Author
            book.getAuthor().setBooksPublished(booksInAuthor);

            //update booksByTitle
            libraryRack.getBooksByTitle().replace(book.getTitle(), book);
        }
    }

    public void removeBook(LibraryRack libraryRack, Book book) {
        libraryRack.getBooksByCategory().get(book.getCategory()).remove(book);
        libraryRack.getBooksByISBN().remove(book.getIsbn());
        libraryRack.getBooksByTitle().remove(book.getTitle());
        libraryRack.getBooksByAuthor().get(book.getAuthor().getName()).remove(book);
    }

    public void issueBook(BookItem bookItem, User user) {
        if(user.getBooksBorrowed() < user.getBorrowLimit()) {
            bookItem.setBookBorrowed(user);
            user.setBooksBorrowed(user.getBooksBorrowed() + 1);
            user.getBookBorrowedList().add(bookItem);
            user.setAmountFine(user.getAmountFine() + bookItem.getPrice());
        }
    }

    public void returnBook(BookItem bookItem, User user) {
        if (user.getBookBorrowedList().contains(bookItem)) {
            bookItem.setBookReturned();
            user.setBooksBorrowed(user.getBooksBorrowed() - 1);
            user.getBookBorrowedList().remove(bookItem);
            user.setAmountFine(user.getAmountFine() - bookItem.getPrice());
        }
    }

}
