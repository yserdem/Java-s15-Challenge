package com.workintech.data;

import com.workintech.media.Book;
import com.workintech.media.MediaItem;

import java.util.List;

public interface Searchable {
    public List<MediaItem> searchByCategory(Categories category);
    public List<MediaItem> searchByAuthor(String author);
    public MediaItem searchById(Long bookID);
    public MediaItem searchByTitle(String title);
}
