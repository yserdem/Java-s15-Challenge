package com.workintech.media;

import com.workintech.data.Categories;
import com.workintech.person.Author;
import com.workintech.person.Membership;
import com.workintech.person.User;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.Date;
@EqualsAndHashCode(callSuper = true)
@Data
public class BookItem extends Book{
    @Setter(AccessLevel.NONE)
    private LocalDate dateBorrowed;
    @Setter(AccessLevel.NONE)
    private LocalDate dueDate;
    private BookStatus bookStatus = BookStatus.AVAILABLE;
    private User userWhoHolds;
    private long bookID;


    public BookItem(Book book, long bookID) {
        super(book.getIsbn(),book.getTitle(),book.getPublishDate(), book.getPublisher(), book.getAuthor(), book.getNumberOfPages(), book.getPrice(), book.getCategory());
        this.bookID = bookID;
    }

    public BookItem(long isbn, String title,
                    LocalDate publishDate, String publisher, Author author,
                    int numberOfPages, int price, Categories category, long bookID) {
        super(isbn, title, publishDate, publisher, author, numberOfPages, price, category);
        this.bookID = bookID;
    }

    public void setBookBorrowed(User user) {
        this.dateBorrowed = LocalDate.now();
        this.dueDate = LocalDate.now().plusDays(5);
        this.bookStatus = BookStatus.BORROWED;
        this.userWhoHolds = user;
    }

    public void setBookReturned() {
        this.dateBorrowed = null;
        this.dueDate = null;
        this.bookStatus = BookStatus.AVAILABLE;
        this.userWhoHolds = null;
    }





}
