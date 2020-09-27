package com.kodilla.testing.forum.statistics;

import com.kodilla.testing.forum.ForumComment;
import com.kodilla.testing.forum.ForumPost;
import com.kodilla.testing.forum.ForumUser;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Test for Forum Statistic")
public class ForumStatisticsTestSuite {

    int testCounter = 0;

    @BeforeEach
    public void beforeEveryTest(){
        testCounter++;
        System.out.println("Preparing test no. #" + testCounter + " start");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("Test no. #" + testCounter + " finish");
    }

    @Mock
    private Statistics statisticsMock;

    private List<String> generateUsers(int users) {
        List<String> usersList = new ArrayList<>();
        for (int i = 0; i < users; i++) {
            ForumUser user = new ForumUser("User " + i, "Name " + i);
            String name = user.getName();
            usersList.add(name);
        }
        return usersList;
    }

    private int generatePosts(int posts){
        List<ForumPost> postList = new ArrayList<>();
        for(int i = 0; i < posts; i++){
            ForumPost forumPost = new ForumPost("Post Body" + i, "Name" +i);
            postList.add(forumPost);
        }
        return postList.size();
    }

    private int generateComments(int comments){
        List<ForumComment> postComments = new ArrayList<>();
        for(int i = 0; i < comments; i++){
            ForumComment comment = new ForumComment(new ForumPost("Post Body" + i, "Name" + i), "Comment" + i, "Name"  + i);
            postComments.add(comment);
        }
        return postComments.size();
    }

    @Test
    void testIfNoAnyPost(){
        //Given
        ForumStatistics forumStatistics = new ForumStatistics();
        List<String> users = generateUsers(50);
        when(statisticsMock.userName()).thenReturn(users);
        when(statisticsMock.commentsCount()).thenReturn(0);
        when(statisticsMock.postsCount()).thenReturn(0);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        forumStatistics.showStatistics();

        //Then
        Assertions.assertEquals(50, forumStatistics.getUserName());
        Assertions.assertEquals(0, forumStatistics.getPostCount());
        Assertions.assertEquals(0, forumStatistics.getCommentCount());
        Assertions.assertEquals(0, forumStatistics.getPostPerUser());
        Assertions.assertEquals(0, forumStatistics.getCommentsPerUser());
        Assertions.assertEquals(0, forumStatistics.getCommentsPerPost());
    }

    @Test
    void testIf1000Post(){
        //Given
        ForumStatistics forumStatistics = new ForumStatistics();
        List<String> users = generateUsers(50);
        when(statisticsMock.userName()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(generatePosts(1000));
        when(statisticsMock.commentsCount()).thenReturn(generateComments(5000));
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        forumStatistics.showStatistics();
        //Then
        Assertions.assertEquals(50, forumStatistics.getUserName());
        Assertions.assertEquals(1000, forumStatistics.getPostCount());
        Assertions.assertEquals(5000, forumStatistics.getCommentCount());
        Assertions.assertEquals(20, forumStatistics.getPostPerUser());
        Assertions.assertEquals(100, forumStatistics.getCommentsPerUser());
        Assertions.assertEquals(5, forumStatistics.getCommentsPerPost());
    }

    @Test
    void testIfNoComments(){
        //Given
        ForumStatistics forumStatistics = new ForumStatistics();
        List<String> users = generateUsers(50);
        when(statisticsMock.userName()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(generatePosts(1000));
        when(statisticsMock.commentsCount()).thenReturn(generateComments(0));
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        forumStatistics.showStatistics();
        //Then
        Assertions.assertEquals(50, forumStatistics.getUserName());
        Assertions.assertEquals(1000, forumStatistics.getPostCount());
        Assertions.assertEquals(0, forumStatistics.getCommentCount());
        Assertions.assertEquals(20, forumStatistics.getPostPerUser());
        Assertions.assertEquals(0, forumStatistics.getCommentsPerUser());
        Assertions.assertEquals(0, forumStatistics.getCommentsPerPost());
    }

    @Test
    void testIfMoreCommentsThePosts(){
        //Given
        ForumStatistics forumStatistics = new ForumStatistics();
        List<String> users = generateUsers(50);
        when(statisticsMock.userName()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(generatePosts(1000));
        when(statisticsMock.commentsCount()).thenReturn(generateComments(5000));
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        forumStatistics.showStatistics();
        //Then
        Assertions.assertEquals(50, forumStatistics.getUserName());
        Assertions.assertEquals(1000, forumStatistics.getPostCount());
        Assertions.assertEquals(5000, forumStatistics.getCommentCount());
        Assertions.assertEquals(20, forumStatistics.getPostPerUser());
        Assertions.assertEquals(100, forumStatistics.getCommentsPerUser());
        Assertions.assertEquals(5, forumStatistics.getCommentsPerPost());
    }

    @Test
    void testIfMorePostThenComments(){
        //Given
        ForumStatistics forumStatistics = new ForumStatistics();
        List<String> users = generateUsers(50);
        when(statisticsMock.userName()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(generatePosts(1000));
        when(statisticsMock.commentsCount()).thenReturn(generateComments(500));
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        forumStatistics.showStatistics();
        //Then
        Assertions.assertEquals(50, forumStatistics.getUserName());
        Assertions.assertEquals(1000, forumStatistics.getPostCount());
        Assertions.assertEquals(500, forumStatistics.getCommentCount());
        Assertions.assertEquals(20, forumStatistics.getPostPerUser());
        Assertions.assertEquals(10, forumStatistics.getCommentsPerUser());
        Assertions.assertEquals(0, forumStatistics.getCommentsPerPost());
    }

    @Test
    void testIfNoAnyUsers(){
        //Given
        ForumStatistics forumStatistics = new ForumStatistics();
        List<String> users = new ArrayList<>();
        when(statisticsMock.userName()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(0);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        forumStatistics.showStatistics();
        //Then
        Assertions.assertEquals(0, forumStatistics.getUserName());
        Assertions.assertEquals(0, forumStatistics.getPostCount());
        Assertions.assertEquals(0, forumStatistics.getCommentCount());
        Assertions.assertEquals(0, forumStatistics.getPostPerUser());
        Assertions.assertEquals(0, forumStatistics.getCommentsPerUser());
        Assertions.assertEquals(0, forumStatistics.getCommentsPerPost());
    }

    @Test
    void testIf100Users(){
        //Given
        ForumStatistics forumStatistics = new ForumStatistics();
        List<String> users = generateUsers(100);
        when(statisticsMock.userName()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(generatePosts(1000));
        when(statisticsMock.commentsCount()).thenReturn(generateComments(5000));
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        forumStatistics.showStatistics();
        //Then
        Assertions.assertEquals(100, forumStatistics.getUserName());
        Assertions.assertEquals(1000, forumStatistics.getPostCount());
        Assertions.assertEquals(5000, forumStatistics.getCommentCount());
        Assertions.assertEquals(10, forumStatistics.getPostPerUser());
        Assertions.assertEquals(50, forumStatistics.getCommentsPerUser());
        Assertions.assertEquals(5, forumStatistics.getCommentsPerPost());
    }
}
