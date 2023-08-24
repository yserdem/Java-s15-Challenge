package com.workintech.media;

import com.workintech.data.Categories;
import com.workintech.person.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class MediaItem {
    //TODO ISBN will be transferred to BookItem
    private long isbn;
    private String title;
    private LocalDate publishDate;
    private String publisher;
    private Author author;
    private Categories category;
}
