package com.workintech.data;

import com.workintech.media.AudioBook;
import com.workintech.media.MediaItem;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class OnlineMedia implements Searchable {
    private Map<String, List<AudioBook>> mediaByAuthor;
    private Map<Categories, List<AudioBook>> mediaByCategory;
    private Map<Long, AudioBook> mediaById;
    private Map<String, AudioBook> mediaByTitle;

    @Override
    @SuppressWarnings("unchecked")
    public List<MediaItem> searchByCategory(Categories category) {
        return (List<MediaItem>) (List<?>) mediaByCategory.get(category);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<MediaItem> searchByAuthor(String author) {
        return (List<MediaItem>) (List<?>) mediaByAuthor.get(author);
    }

    @Override
    public MediaItem searchById(Long bookID) {
        return mediaById.get(bookID);
    }

    @Override
    public MediaItem searchByTitle(String title) {
        return mediaByTitle.get(title);
    }
}
