package com.kodilla.testing.forum.statistics;

import com.kodilla.testing.library.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StatisticalProgramTestSuite {

    @Mock
    private Statistics statisticsMock;
    StatisticalProgram statisticalProgram = new StatisticalProgram();


    private List<String> generateListOfNUsers(int usersQuantity) {
        List<String> resultListOfNUsers = new ArrayList<>();
        for (int n = 1; n <= usersQuantity; n++) {
            String userN = "user " + n;
            resultListOfNUsers.add(userN);
        }
        return resultListOfNUsers;
    }

    @BeforeEach
    public void before() {

        List<String> listOfUsersNames = generateListOfNUsers(100);
        int quantityOfPosts = 200;
        int quantityOfComments = 1000;

        when(statisticsMock.usersNames()).thenReturn(listOfUsersNames);
        when(statisticsMock.postsCount()).thenReturn(quantityOfPosts);
        when(statisticsMock.commentsCount()).thenReturn(quantityOfComments);
    }

    @DisplayName("When the number of posts = 0")
    @Test
    void testCalculateAdvStatisticsWhenPostsCountIsZero() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(0);

        //When
        statisticalProgram.calculateAdvStatistics(statisticsMock);
        double averagePostsPerUser = statisticalProgram.getAvgPostsPerUser();
        double averageCommentsPerUser = statisticalProgram.getAvgCommentsPerUser();
        double averageCommentsPerPost = statisticalProgram.getAvgCommentsPerPost();

        //Then
        assertEquals(0, averagePostsPerUser);
        assertEquals(0, averageCommentsPerUser);
        assertEquals(0, averageCommentsPerPost);

    }

    @DisplayName("When the number of posts = 1000")
    @Test
    void testCalculateAdvStatisticsWhenPostsCountIsThousand() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(1000);

        //When
        statisticalProgram.calculateAdvStatistics(statisticsMock);
        double averagePostsPerUser = statisticalProgram.getAvgPostsPerUser();
        double averageCommentsPerUser = statisticalProgram.getAvgCommentsPerUser();
        double averageCommentsPerPost = statisticalProgram.getAvgCommentsPerPost();

        //Then
        assertEquals(10, averagePostsPerUser);
        assertEquals(10, averageCommentsPerUser);
        assertEquals(1, averageCommentsPerPost);

    }

    @DisplayName("When the number of comments = 0")
    @Test
    void testCalculateAdvStatisticsWhenCommentsCountIsZero() {
        //Given
        when(statisticsMock.commentsCount()).thenReturn(0);

        //When
        statisticalProgram.calculateAdvStatistics(statisticsMock);
        double averagePostsPerUser = statisticalProgram.getAvgPostsPerUser();
        double averageCommentsPerUser = statisticalProgram.getAvgCommentsPerUser();
        double averageCommentsPerPost = statisticalProgram.getAvgCommentsPerPost();

        //Then
        assertEquals(2, averagePostsPerUser);
        assertEquals(0, averageCommentsPerUser);
        assertEquals(0, averageCommentsPerPost);

    }

    @DisplayName("When number of comments < number of posts")
    @Test
    void testCalculateAdvStatisticsWhenCommentsCountIsLessThanPostsCount() {
        //Given
        when(statisticsMock.commentsCount()).thenReturn(100);

        //When
        statisticalProgram.calculateAdvStatistics(statisticsMock);
        double averagePostsPerUser = statisticalProgram.getAvgPostsPerUser();
        double averageCommentsPerUser = statisticalProgram.getAvgCommentsPerUser();
        double averageCommentsPerPost = statisticalProgram.getAvgCommentsPerPost();

        //Then
        assertEquals(2, averagePostsPerUser);
        assertEquals(1, averageCommentsPerUser);
        assertEquals(0.5, averageCommentsPerPost);

    }

    @DisplayName("When number of comments > number of posts")
    @Test
    void testCalculateAdvStatisticsWhenCommentsCountIsHigherThanPostsCount() {
        //Given

        //When
        statisticalProgram.calculateAdvStatistics(statisticsMock);
        double averagePostsPerUser = statisticalProgram.getAvgPostsPerUser();
        double averageCommentsPerUser = statisticalProgram.getAvgCommentsPerUser();
        double averageCommentsPerPost = statisticalProgram.getAvgCommentsPerPost();

        //Then
        assertEquals(2, averagePostsPerUser);
        assertEquals(10, averageCommentsPerUser);
        assertEquals(5, averageCommentsPerPost);

    }

    @DisplayName("When number of users = 0")
    @Test
    void testCalculateAdvStatisticsWhenUsersCountIsZero() {
        //Given
        List<String> resultListOfZeroUsers = new ArrayList<>();
        when(statisticsMock.usersNames()).thenReturn(resultListOfZeroUsers);

        //When
        statisticalProgram.calculateAdvStatistics(statisticsMock);
        double averagePostsPerUser = statisticalProgram.getAvgPostsPerUser();
        double averageCommentsPerUser = statisticalProgram.getAvgCommentsPerUser();
        double averageCommentsPerPost = statisticalProgram.getAvgCommentsPerPost();

        //Then
        assertEquals(0, resultListOfZeroUsers.size());
        assertEquals(0, averagePostsPerUser);
        assertEquals(0, averageCommentsPerUser);
        assertEquals(0, averageCommentsPerPost);

    }

    @DisplayName("When number of users = 100")
    @Test
    void testCalculateAdvStatisticsWhenUsersCountIsHundred() {
        //Given

        //When
        statisticalProgram.calculateAdvStatistics(statisticsMock);
        double averagePostsPerUser = statisticalProgram.getAvgPostsPerUser();
        double averageCommentsPerUser = statisticalProgram.getAvgCommentsPerUser();
        double averageCommentsPerPost = statisticalProgram.getAvgCommentsPerPost();

        //Then
        assertEquals(2, averagePostsPerUser);
        assertEquals(10, averageCommentsPerUser);
        assertEquals(5, averageCommentsPerPost);

    }
}



