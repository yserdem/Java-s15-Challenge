package com.workintech.media;

import com.workintech.data.Categories;
import com.workintech.person.Author;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
//TODO convert concrete class to abstract class
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Book extends MediaItem{

    private int numberOfPages;
    private int price;
    private List<BookItem> bookItemList;
    @Builder
    public Book(long isbn, String title, LocalDate publishDate, String publisher, Author author, int numberOfPages, int price, Categories category) {
        super(isbn, title, publishDate, publisher, author, category);
        this.numberOfPages = numberOfPages;
        this.price = price;
    }
}
