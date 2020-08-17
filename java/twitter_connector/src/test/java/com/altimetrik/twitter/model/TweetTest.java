package com.altimetrik.twitter.model;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TweetTest {
    private static Tweet tweet;
    private static User user;

    @Before
    public void runOnceBeforeTest(){
     user = new User(2, "Test_User", "Sc_Test_User", "India", 15, 12, 8, 20);
     tweet = new Tweet(1, "2020-01-23 10:10:10", "Test Tweet", "en", user, 3, 10);
    }

    @Test
    public void testGetId(){
        Assert.assertEquals(1, tweet.getId());
        tweet.setId(15);
        Assert.assertEquals(15, tweet.getId());
    }

    @Test
    public void testGetCreatedAt(){
        Assert.assertEquals("2020-01-23 10:10:10", tweet.getCreatedAt());
        tweet.setCreatedAt("2020-01-23 10:10:15");
        Assert.assertEquals("2020-01-23 10:10:15", tweet.getCreatedAt());
    }

    @Test
    public void testGetText(){
        Assert.assertEquals("Test Tweet", tweet.getText());
        tweet.setText("New Tweet");
        Assert.assertEquals("New Tweet", tweet.getText());
    }

    @Test
    public void testGetLang(){
        Assert.assertEquals("en", tweet.getLang());
        tweet.setLang("hi");
        Assert.assertEquals("hi", tweet.getLang());
    }

    @Test
    public void testGetRetweetCount(){
        Assert.assertEquals(3, tweet.getRetweetCount());
        tweet.setRetweetCount(10);
        Assert.assertEquals(10, tweet.getRetweetCount());
    }

    @Test
    public void testGetfavoriteCount(){
        Assert.assertEquals(10, tweet.getFavoriteCount());
        tweet.setFavoriteCount(15);
        Assert.assertEquals(15, tweet.getFavoriteCount());
    }

    @After
    public void runOnceAfterTest(){
        tweet = null;
        user = null;
    }
}
