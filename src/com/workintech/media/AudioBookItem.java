package com.workintech.media;

import com.workintech.person.Author;
import com.workintech.person.User;
import lombok.*;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
public class AudioBookItem extends AudioBook{
    @Setter(AccessLevel.NONE)
    private LocalDate dateBorrowed;
    @Setter(AccessLevel.NONE)
    private LocalDate dueDate;
    private User userWhoHolds;

    /*public AudioBookItem(long isbn, String title, LocalDate publishDate, String publisher, Author author,
                         String category,int durationByMinutes) {
        super(isbn, title, publishDate, publisher, author, durationByMinutes, category);
    }*/

    public void AudioBookItemGenerator(User user) {
        AudioBook.builder().author(this.getAuthor()).isbn(this.getIsbn())
                .title(this.getTitle()).publishDate(this.getPublishDate())
                .publisher(this.getPublisher()).durationByMinutes(this.getDurationByMinutes())
                .category(this.getCategory()).build();
        this.dateBorrowed = LocalDate.now();
        this.dueDate = LocalDate.now().plusDays(10);
        this.userWhoHolds = user;
    }
}
