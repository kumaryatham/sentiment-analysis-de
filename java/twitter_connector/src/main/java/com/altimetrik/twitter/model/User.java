package com.altimetrik.twitter.model;

import com.google.gson.annotations.SerializedName;

/**
 * Return the User details in a tweet in JSon format
 */
public class User {

    /**
     * Instance Variables
     * id
     * name
     * screenName
     * location
     * followersCount
     * friendsCount
     * listedCount
     * statusesCount
     */
    private long id;
    private String name;
    @SerializedName("screen_name")
    private String screenName;
    private String location;
    @SerializedName("followers_count")
    private int followersCount;
    @SerializedName("friends_count")
    private int friendsCount;
    @SerializedName("listed_count")
    private int listedCount;
    @SerializedName("statuses_count")
    private int statusesCount;

    /**
     * Constructor of the User class
     * @param id
     * @param name
     * @param screenName
     * @param location
     * @param followersCount
     * @param friendsCount
     * @param listedCount
     * @param statusesCount
     */
    public User(long id, String name, String screenName, String location, int followersCount, int friendsCount, int listedCount, int statusesCount) {
        this.id = id;
        this.name = name;
        this.screenName = screenName;
        this.location = location;
        this.followersCount = followersCount;
        this.friendsCount = friendsCount;
        this.listedCount = listedCount;
        this.statusesCount = statusesCount;
    }

    /**
     * Returns the User Id
     * @return
     */
    public long getId() {
        return id;
    }

    /**
     * Set the UserId for User
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Return the name of the User
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Set the Name for the User
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return the screen name of the user
     * @return
     */
    public String getScreenName() {
        return screenName;
    }

    /**
     * set the screen name for the user
     * @param screenName
     */
    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    /**
     * Return the location of the user
     * @return
     */
    public String getLocation() {
        return location;
    }

    /**
     * Set the location for user
     * @param location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Return the follower count of the user
     * @return
     */
    public int getFollowersCount() {
        return followersCount;
    }

    /**
     * Set the follower count for the user
     * @param followersCount
     */
    public void setFollowersCount(int followersCount) {
        this.followersCount = followersCount;
    }

    /**
     * return the friends count of the user
     * @return
     */
    public int getFriendsCount() {
        return friendsCount;
    }

    /**
     * Set the Friends count for the user
     * @param friendsCount
     */
    public void setFriendsCount(int friendsCount) {
        this.friendsCount = friendsCount;
    }

    /**
     * Return the Listed count of the user
     * @return
     */
    public int getListedCount() {
        return listedCount;
    }

    /**
     * Sets the Listed count for the user
     * @param listedCount
     */
    public void setListedCount(int listedCount) {
        this.listedCount = listedCount;
    }

    /**
     * Return the Statuses count of the User
     * @return
     */
    public int getStatusesCount() {
        return statusesCount;
    }

    /**
     * Sets the Statuses count for the user
     * @param statusesCount
     */
    public void setStatusesCount(int statusesCount) {
        this.statusesCount = statusesCount;
    }

    /**
     * Overridden version of the toString Method for User object
     * @return
     */
    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"name\":\"" + name + '\"' +
                ", \"screenName\":\"" + screenName + '\"' +
                ", \"location\":\"" + location + '\"' +
                ", \"followersCount\":" + followersCount +
                ", \"friendsCount\":" + friendsCount +
                ", \"listedCount\":" + listedCount +
                ", \"statusesCount\":" + statusesCount +
                '}';
    }
}