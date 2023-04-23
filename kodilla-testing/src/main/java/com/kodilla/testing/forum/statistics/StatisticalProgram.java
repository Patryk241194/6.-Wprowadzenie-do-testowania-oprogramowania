package com.kodilla.testing.forum.statistics;

public class StatisticalProgram {

    private int usersCount;
    private int postsCount;
    private int commentsCount;
    private double avgPostsPerUser;
    private double avgCommentsPerUser;
    private double avgCommentsPerPost;

    public void calculateAdvStatistics(Statistics statistics) {
        usersCount = statistics.usersNames().size();
        postsCount = statistics.postsCount();
        commentsCount = statistics.commentsCount();

        if (usersCount > 0) {
            avgPostsPerUser = (double) postsCount / usersCount;
            if (postsCount > 0) {
                avgCommentsPerUser = (double) commentsCount / usersCount;
                avgCommentsPerPost = (double) commentsCount / postsCount;
            }
        } else {
            avgPostsPerUser = 0;
            avgCommentsPerUser = 0;
            avgCommentsPerPost = 0;
        }
    }


    public double getAvgPostsPerUser() {
        return avgPostsPerUser;
    }

    public double getAvgCommentsPerUser() {
        return avgCommentsPerUser;
    }

    public double getAvgCommentsPerPost() {
        return avgCommentsPerPost;
    }

    public void showStatistics() {
        System.out.println("Forum statistics:");
        System.out.println("Number of users: " + usersCount);
        System.out.println("Number of posts: " + postsCount);
        System.out.println("Number of comments: " + commentsCount);
        System.out.println("Average number of posts per user: " + avgPostsPerUser);
        System.out.println("Average number of comments per user: " + avgCommentsPerUser);
        System.out.println("Average number of comments per post: " + avgCommentsPerPost);
    }

}
