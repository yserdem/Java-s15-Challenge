package com.workintech.person;

import com.workintech.media.Book;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;
@EqualsAndHashCode(callSuper = true)
@Data
public class Author extends Person{
    private List<Book> booksPublished;

    public Author(String name) {
        super(name);
        booksPublished = new ArrayList<>();
    }
}
