package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSuite {

    @Test
    void testDefaultSharingStrategies() {
        //Given
        User user1 = new Millenials("John Smith");
        User user2 = new YGeneration("Jan Kowalski");
        User user3 = new ZGeneration("Patryk Potrykus");

        //When
        String user1Publisher = user1.sharePost();
        System.out.println(user1.getUsername() + " uses " + user1Publisher);
        String user2Publisher = user2.sharePost();
        System.out.println(user2.getUsername() + " uses " + user2Publisher);
        String user3Publisher = user3.sharePost();
        System.out.println(user3.getUsername() + " uses " + user3Publisher);

        //Then
        assertEquals("Facebook", user1Publisher);
        assertEquals("Twitter", user2Publisher);
        assertEquals("Snapchat", user3Publisher);
    }

    @Test
    void testIndividualSharingStrategy() {
        //Given
        User user1 = new Millenials("John Smith");

        //When
        String user1Publisher = user1.sharePost();
        System.out.println(user1.getUsername() + " uses " + user1Publisher);
        user1.setSocialPublisher(new TwitterPublisher());
        user1Publisher = user1.sharePost();
        System.out.println(user1.getUsername() + " changed to " + user1Publisher);

        //Then
        assertEquals("Twitter", user1Publisher);
    }
}
