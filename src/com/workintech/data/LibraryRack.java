package com.workintech.data;

import com.workintech.media.Book;
import com.workintech.media.MediaItem;
import com.workintech.person.Author;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Data
public class LibraryRack implements Searchable {
    //TODO reduce Maps into a singular map to prevent repetition
    private List<Author> authors;
    private Map<String, List<Book>> booksByAuthor;
    private Map<Categories, List<Book>> booksByCategory;
    private Map<Long, Book> booksByISBN;
    private Map<String, Book> booksByTitle;


    @Override
    @SuppressWarnings("unchecked")
    public List<MediaItem> searchByCategory(Categories category) {
        return (List<MediaItem>) (List<?>) booksByCategory.get(category);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<MediaItem> searchByAuthor(String author) {
        return (List<MediaItem>) (List<?>) booksByAuthor.get(author);
    }

    @Override
    public MediaItem searchById(Long bookID) {
        return booksByISBN.get(bookID);
    }

    @Override
    public MediaItem searchByTitle(String title) {
        return booksByTitle.get(title);
    }

    public LibraryRack() {
        booksByTitle = new HashMap<>();
        booksByISBN = new HashMap<>();
        booksByAuthor = new HashMap<>();
        booksByCategory = new HashMap<>();
        authors = new ArrayList<>();
        for (Categories category: Categories.values()) {
            booksByCategory.put(category, new ArrayList<>());
        }

        for (Author author: authors) {
            booksByAuthor.put(author.getName(), null);
        }


    }
}
