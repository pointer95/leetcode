package designTwitter;

import java.util.*;

/**
 * source: https://leetcode-cn.com/problems/design-twitter/
 * @author: pointer
 * @date: Created on 2020/7/13
 */
class Twitter {

    private static int time = 0;

    private static class User {
        private int userId;
        private Set<Integer> followed;
        private Tweet head;

        public User(int userId) {
            followed = new HashSet<>();
            this.userId = userId;
            this.head = null;
            follow(userId);
        }

        public void follow(int userId) {
            followed.add(userId);
        }

        public void unfollow(int userId) {
            if (this.userId != userId) {
                followed.remove(userId);
            }
        }

        public void post(int tweetId) {
            Tweet tweet = new Tweet(tweetId, time);
            time++;
            tweet.next = head;
            head = tweet;
        }
    }

    private static class Tweet {
        private int tweetId;
        private int time;
        private Tweet next;

        public Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
            this.next = null;
        }
    }

    private Map<Integer, User> userMap = new HashMap<>();

    /** Initialize your data structure here. */
    public Twitter() {

    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            userMap.put(userId, new User(userId));
        }
        User user = userMap.get(userId);
        user.post(tweetId);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if (!userMap.containsKey(userId)) {
            return res;
        }
        Set<Integer> users = userMap.get(userId).followed;
        PriorityQueue<Tweet> priorityQueue =
                new PriorityQueue<>(users.size(), (t1, t2) -> t2.time - t1.time);

        for (int id : users) {
            Tweet tweets = userMap.get(id).head;
            if (tweets == null) {
                continue;
            }
            priorityQueue.add(tweets);
        }
        while(!priorityQueue.isEmpty()) {
            if (res.size() == 10) {
                return res;
            }
            Tweet tweet = priorityQueue.poll();
            res.add(tweet.tweetId);
            if (tweet.next != null) {
                priorityQueue.add(tweet.next);
            }
        }
        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            userMap.put(followerId, new User(followerId));
        }
        if (!userMap.containsKey(followeeId)) {
            userMap.put(followeeId, new User(followeeId));
        }
        userMap.get(followerId).follow(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (userMap.containsKey(followerId)) {
            userMap.get(followerId).unfollow(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
