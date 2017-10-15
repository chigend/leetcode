package design_twitter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.UIDefaults;

public class Twitter2 {
    private Map<Integer, User> users;

    private int created = 0;

    /**
     * Initialize your data structure here.
     */
    public Twitter2() {
        users = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        if (!users.containsKey(userId)) {
            users.put(userId, new User(userId));
        }
        users.get(userId).postTweet(tweetId);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        if (!users.containsKey(userId)) {
            return result;
        }
        Set<Integer> followees = users.get(userId).followees;
        MaxHeap maxHeap = new MaxHeap();
        if (users.get(userId).head != null) {
            maxHeap.add(users.get(userId).head);
        }
        for (int user : followees) {
            Tweet head = users.get(user).head;
            if (head != null) {
                maxHeap.add(head);
            }
        }

        while (!maxHeap.isEmpty() && result.size() < 10) {
            Tweet max = maxHeap.getMax();
            result.add(max.id);
        }
        return result;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (followeeId == followerId) {
            return;
        }
        if (!users.containsKey(followerId)) {
            users.put(followerId, new User(followerId));
        }
        if (!users.containsKey(followeeId)) {
            users.put(followeeId, new User(followeeId));
        }
        users.get(followerId).follow(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (users.containsKey(followerId)) {
            users.get(followerId).unfollow(followeeId);
        }
    }

    class User {
        int id;
        HashSet<Integer> followees;
        Tweet head;

        public User(int id) {
            this.id = id;
            this.followees = new HashSet<>();
        }

        public void follow(int followee) {
            followees.add(followee);
        }

        public void unfollow(int followee) {
            followees.remove(followee);
        }

        public void postTweet(int tweetId) {
            Tweet tweet = new Tweet(tweetId, ++created);
            tweet.next = head;
            head = tweet;
        }
    }

    class Tweet {
        Integer id;
        int created;
        Tweet next;

        public Tweet(Integer id, int created) {
            this.id = id;
            this.created = created;
        }
    }

    class MaxHeap {
        Tweet[] heap;
        int size = 0;

        public MaxHeap() {
            this.heap = new Tweet[1000];
        }

        public void add(Tweet tweet) {
            heap[size++] = tweet;
            siftUp(size - 1);
        }

        private void siftUp(int i) {
            if (i > 0) {
                int parent = (i - 1) >>> 1;
                if (heap[i].created > heap[parent].created) {
                    swap(i, parent);
                    siftUp(parent);
                }
            }
        }

        public Tweet getMax() {
            Tweet max = heap[0];
            swap(0, size - 1);
            size--;
            siftDown(0);
            if (max.next != null) {
                add(max.next);
            }
            return max;
        }

        private void swap(int i, int j) {
            Tweet tweet = heap[i];
            heap[i] = heap[j];
            heap[j] = tweet;
        }

        private void siftDown(int i) {
            int l = 2 * i + 1;
            int r = 2 * i + 2;
            if (l >= size) {
                return;
            }
            if (r < size && heap[r].created > heap[l].created) {
                l = r;
            }
            if (heap[i].created < heap[l].created) {
                swap(i, l);
                siftDown(l);
            }
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }

}
