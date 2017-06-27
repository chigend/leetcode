package design_twitter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yejinbiao
 * @create 2017-06-27-16:51
 */

public class Twitter {
    private Map<Integer, HashSet<Integer>> relationShip;
    private Map<Integer, HashSet<Tweet>> userTweets;
    private Integer create = 0;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        relationShip = new HashMap<>();
        userTweets = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        HashSet<Tweet> tweets = userTweets.get(userId);
        if (tweets == null) {
            tweets = new HashSet<>();
        }
        tweets.add(new Tweet(tweetId, ++create));
        userTweets.put(userId,tweets);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        HashSet<Integer> relation = relationShip.get(userId);
        if (relation == null) {
            relation = new HashSet<>();
        }
        relation.add(userId);
        List<Tweet> all = new ArrayList<>();
        for (Integer followeeId : relation) {
            HashSet<Tweet> tweets = userTweets.get(followeeId);
            if (tweets != null) {
                all.addAll(tweets);
            }
        }
        return all.stream().sorted((t1,t2)->t2.create.compareTo(t1.create)).limit(10)
                .map(Tweet::getId).collect(Collectors.toList());
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {

        HashSet<Integer> relation = relationShip.get(followerId);
        if (relation == null) {
            relation = new HashSet<>();
        }
        relation.add(followeeId);
        relationShip.put(followerId, relation);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        HashSet<Integer> relation = relationShip.get(followerId);
        if (relation == null) {
            return;
        }
        relation.remove(followeeId);
    }

    private class Tweet {
        private Integer id;
        private Integer create;

        public Tweet(Integer id, Integer create) {
            this.id = id;
            this.create = create;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getCreate() {
            return create;
        }

        public void setCreate(Integer create) {
            this.create = create;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;

            Tweet tweet = (Tweet) o;

            if (id != null ? !id.equals(tweet.id) : tweet.id != null)
                return false;
            return create != null ? create.equals(tweet.create) : tweet.create == null;
        }

        @Override
        public int hashCode() {
            int result = id != null ? id.hashCode() : 0;
            return result;
        }
    }
}