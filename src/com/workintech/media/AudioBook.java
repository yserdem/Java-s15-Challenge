package com.workintech.media;

import com.workintech.data.Categories;
import com.workintech.person.Author;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class AudioBook extends MediaItem{
    private int durationByMinutes;
    @Builder
    public  AudioBook(long isbn, String title, LocalDate publishDate, String publisher, Author author, int durationByMinutes, Categories category) {
        super(isbn,title,publishDate,publisher,author,category);
        this.durationByMinutes = durationByMinutes;
    }

}
