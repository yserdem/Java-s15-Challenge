package com.workintech;

import com.workintech.data.Categories;
import com.workintech.data.LibraryRack;
import com.workintech.media.Book;
import com.workintech.media.BookItem;
import com.workintech.person.Author;
import com.workintech.person.Librarian;
import com.workintech.person.Membership;
import com.workintech.person.User;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Author author1 = new Author("ali");
        Author author2 = new Author("veli");

        User user1 = User.builder().name("username1").membership(Membership.NEW_MEMBER).build();
        User user2 = User.builder().name("username2").membership(Membership.OLD_MEMBER).build();

        Book book1 = Book.builder().price(3).publisher("Can yayınları").publishDate(LocalDate.of(2020,3,13)).isbn(123L).numberOfPages(124)
                .title("Book1 Title").author(author1).category(Categories.BIOGRAPHY).build();
        Book book2 = Book.builder().price(2).publisher("Can yayınları").publishDate(LocalDate.of(2008,5,27)).isbn(555L).numberOfPages(77)
                .title("Book2 title").author(author2).category(Categories.HORROR).build();

        BookItem bookItem1 = new BookItem(book1, 1L);
        BookItem bookItem2 = new BookItem(book1, 2L);
        BookItem bookItem3 = new BookItem(book2, 3L);
        BookItem bookItem4 = new BookItem(book2, 4L);

        Librarian librarian = Librarian.builder().name("librarian").graduatedFrom("asd uni").workedForXYears(2).build();

        LibraryRack myLibraryDB = new LibraryRack();

        librarian.addBook(myLibraryDB, book1);
        librarian.addBook(myLibraryDB, book2);

        Book book3 = Book.builder().price(8).publisher("Can yayınları").publishDate(LocalDate.of(2008,5,15)).isbn(555L).numberOfPages(13)
                .title("Book3 title").author(author2).category(Categories.HORROR).build();


        System.out.println(myLibraryDB);





    }
}