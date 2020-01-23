package com.altimetrik.twitter.model;


import com.google.gson.annotations.SerializedName;

/**
 * Returns the Tweet data points
 */
public class Tweet {

    /**
     * Instance variables:-
     * id
     * createdAt
     * text
     * lang
     * user
     * retweetCount
     * favoritecount
     */
    private long id;
    @SerializedName("created_at")
    private String createdAt;
    private String text;
    private String lang;
    private User user;
    @SerializedName("retweet_count")
    private int retweetCount;
    @SerializedName("favorite_count")
    private int favoriteCount;

    /**
     * Constructor of the Tweet class
     * @param id
     * @param createdAt
     * @param text
     * @param lang
     * @param user
     * @param retweetCount
     * @param favoriteCount
     */
    public Tweet(long id, String createdAt, String text, String lang, User user, int retweetCount, int favoriteCount) {
        this.createdAt = createdAt;
        this.id = id;
        this.text = text;
        this.lang = lang;
        this.user = user;
        this.retweetCount = retweetCount;
        this.favoriteCount = favoriteCount;
    }

    /**
     * Return the Tweet ID
     * @return
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the Tweet ID
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Return the Created Time Stamp
     * @return
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the created timestamp for a tweet
     * @param createdAt
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Return the Text from the tweet
     * @return
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the Tweet content
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Return the language of the tweet
     * @return
     */
    public String getLang() {
        return lang;
    }

    /**
     * Sets the Language of the tweet
     * @param lang
     */
    public void setLang(String lang) {
        this.lang = lang;
    }

    /**
     * Return the User Object
     * @return
     */
    public User getUser() {
        return user;
    }

    /**
     * Set the User Object
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Return the retweet Count
     * @return
     */
    public int getRetweetCount() {
        return retweetCount;
    }

    /**
     * Set the retweet count
     * @param retweetCount
     */
    public void setRetweetCount(int retweetCount) {
        this.retweetCount = retweetCount;
    }

    /**
     * Return the favorite count
     * @return
     */
    public int getFavoriteCount() {
        return favoriteCount;
    }

    /**
     * Set the Favorite count
     * @param favoriteCount
     */
    public void setFavoriteCount(int favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    /**
     * Override version of the Object class toString method
     * @return
     */
    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"createdAt\":\"" + createdAt + '\"' +
                ", \"text\":\"" + text.replace("\n", " ") + '\"' +
                ", \"lang\":\"" + lang + '\"' +
                //", \"user\":" + user +
                ", \"userId\":" + user.getId() +
                ", \"name\":\"" + user.getName() + '\"' +
                ", \"screenName\":\"" + user.getScreenName() + '\"' +
                ", \"location\":\"" + user.getLocation() + '\"' +
                ", \"followersCount\":" + user.getFollowersCount() +
                ", \"listedCount\":" + user.getListedCount() +
                ", \"statusesCount\":" + user.getStatusesCount() +
                ", \"retweetCount\":" + retweetCount +
                ", \"favoriteCount\":" + favoriteCount +
                '}';
    }
}