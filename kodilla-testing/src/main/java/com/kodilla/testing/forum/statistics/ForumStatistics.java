package com.kodilla.testing.forum.statistics;

import java.util.List;

public class ForumStatistics {

    private int userName;
    private int postCount;
    private int commentCount;
    private int postPerUser;
    private int commentsPerUser;
    private int commentsPerPost;


    public int getUserName() {
        return userName;
    }

    public void setUserName(int userName) {
        this.userName = userName;
    }

    public int getPostCount() {
        return postCount;
    }

    public void setPostCount(int postCount) {
        this.postCount = postCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getPostPerUser() {
        return postPerUser;
    }

    public void setPostPerUser(int postPerUser) {
        this.postPerUser = postPerUser;
    }

    public int getCommentsPerUser() {
        return commentsPerUser;
    }

    public void setCommentsPerUser(int commentsPerUser) {
        this.commentsPerUser = commentsPerUser;
    }

    public int getCommentsPerPost() {
        return commentsPerPost;
    }

    public void setCommentsPerPost(int commentsPerPost) {
        this.commentsPerPost = commentsPerPost;
    }

    public void calculateAdvStatistics(Statistics statistics) {
        setUserName(statistics.userName().size());
        setPostCount(statistics.postsCount());
        setCommentCount(statistics.commentsCount());
        System.out.println("Calculate avarge of posts per one usser");
        if (userName != 0 && postCount != 0) {
            setPostPerUser(postCount / userName);
        }
        System.out.println("Calculating average of comments per one user");
        if (userName != 0 && commentCount != 0) {
            setCommentsPerUser(commentCount / userName);
        }
        System.out.println("Calculating average of comments per one post");
        if (postCount != 0 && commentCount != 0) {
            setCommentsPerPost(commentCount / postCount);
        }
    }

    public void showStatistics() {

        System.out.println("User quantity: " + (int) userName);
        System.out.println("Post quantity: " + (int) postCount);
        System.out.println("Comments quantity: " + (int) commentCount);
        System.out.println("Average of posts per one user: " + postPerUser);
        System.out.println("Average of comments per one user: " + commentsPerUser);
        System.out.println("Average of comments per one post: " + commentsPerPost);
    }
}
