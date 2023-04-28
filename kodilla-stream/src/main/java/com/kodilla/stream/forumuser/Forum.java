package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forum {

    private final List<ForumUser> theUserList = new ArrayList<>();

    public Forum() {
        theUserList.add(new ForumUser(1, "Patryk", 'M', LocalDate.of(1990, 12, 23), 0));
        theUserList.add(new ForumUser(2, "Maciej", 'm', LocalDate.of(1976, 5, 14), 893));
        theUserList.add(new ForumUser(3, "Matylda", 'F', LocalDate.of(2006, 2, 26), 234));
        theUserList.add(new ForumUser(4, "Ania", 'f', LocalDate.of(1986, 4, 1), 23));
        theUserList.add(new ForumUser(5, "Robert", 'm', LocalDate.of(2014, 9, 6), 3));
        theUserList.add(new ForumUser(6, "Małgorzata", 'F', LocalDate.of(2013, 2, 13), 767));
        theUserList.add(new ForumUser(7, "Franek", 'M', LocalDate.of(1994, 10, 17), 1245));
    }

    public List<ForumUser> getTheUserList() {
        return new ArrayList<>(theUserList);
    }
}
