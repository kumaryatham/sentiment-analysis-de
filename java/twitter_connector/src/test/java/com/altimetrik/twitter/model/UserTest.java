package com.altimetrik.twitter.model;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTest {
    private static User user;

    @Before
    public void runOnceBeforeTest(){
        user = new User(2, "Test_User", "Sc_Test_User", "India", 15, 12, 8, 20);
    }
    @After
    public void runOnceAfterTest(){
        user = null;
    }

    @Test
    public void testGetId(){
        Assert.assertEquals(2, user.getId());
        user.setId(14);
        Assert.assertEquals(14, user.getId());
    }

    @Test
    public void testGetName(){
        Assert.assertEquals("Test_User", user.getName());
        user.setName("New_Name");
        Assert.assertEquals("New_Name", user.getName());
    }

    @Test
    public void testGetScreenName(){
        Assert.assertEquals("Sc_Test_User", user.getScreenName());
        user.setScreenName("New_SC_Name");
        Assert.assertEquals("New_SC_Name", user.getScreenName());
    }

    @Test
    public void testGetLocation(){
        Assert.assertEquals("India", user.getLocation());
        user.setLocation("UK");
        Assert.assertEquals("UK", user.getLocation());
    }

    @Test
    public void testGetFollowersCount(){
        Assert.assertEquals(15, user.getFollowersCount());
        user.setFollowersCount(20);
        Assert.assertEquals(20, user.getFollowersCount());
    }

    @Test
    public void testGetFriendsCount(){
        Assert.assertEquals(12, user.getFriendsCount());
        user.setFriendsCount(34);
        Assert.assertEquals(34, user.getFriendsCount());
    }

    @Test
    public void testGetListedCount(){
        Assert.assertEquals(8, user.getListedCount());
        user.setListedCount(32);
        Assert.assertEquals(32, user.getListedCount());
    }

    @Test
    public void testGetstatusesCount(){
        Assert.assertEquals(20, user.getStatusesCount());
        user.setStatusesCount(29);
        Assert.assertEquals(29, user.getStatusesCount());
    }
}
