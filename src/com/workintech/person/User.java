package com.workintech.person;

import com.workintech.media.BookItem;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@EqualsAndHashCode(callSuper = true)
@Data
public class User extends Person {
    private Membership membershipType;
    private int booksBorrowed;
    private final int borrowLimit = 5;
    private List<BookItem> bookBorrowedList = new ArrayList<>();
    private int amountFine;
    @Builder
    public User(String name, Membership membership) {
        super(name);
        this.membershipType = membership;
    }



}
