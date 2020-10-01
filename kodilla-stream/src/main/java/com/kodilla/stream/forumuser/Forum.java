package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
public final class Forum {
    private final List<ForumUser> forumUserList = new ArrayList<>();

    public Forum(){
        forumUserList.add(new ForumUser(1, "Bartek", 'M',LocalDate.of(1995,8,21), 5));
        forumUserList.add(new ForumUser(2, "Bożena", 'F', LocalDate.of(1998,12,2), 23));
        forumUserList.add(new ForumUser(3, "Antek", 'M', LocalDate.of(1997,6,1), 21));
        forumUserList.add(new ForumUser(4, "Ilona", 'F', LocalDate.of(2000,7,12), 15));
        forumUserList.add(new ForumUser(5, "Matrta", 'F', LocalDate.of(1991,1,28), 52));
        forumUserList.add(new ForumUser(6, "Zbyszek", 'M', LocalDate.of(1993,8,4), 2));
        forumUserList.add(new ForumUser(7, "Marcin", 'M', LocalDate.of(2002,11,14), 48));
        forumUserList.add(new ForumUser(8, "Piotrek", 'M', LocalDate.of(2001,10,2), 7));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(forumUserList);
    }

}
