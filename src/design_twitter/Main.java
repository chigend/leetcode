package design_twitter;

/**
 * @author yejinbiao
 * @create 2017-06-27-17:33
 */

public class Main {
    public static void main(String[] args) {
        //case1
//        Twitter2 twitter = new Twitter2();
//
//        // User 1 posts a new tweet (id = 5).
//        twitter.postTweet(1, 5);
//
//        // User 1's news feed should return a list with 1 tweet id -> [5].
//        System.out.println(twitter.getNewsFeed(1));
//
//        // User 1 follows user 2.
//        twitter.follow(1, 2);
//
//        // User 2 posts a new tweet (id = 6).
//        twitter.postTweet(2, 6);
//
//        // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
//        // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
//        System.out.println(twitter.getNewsFeed(1));
//
//        // User 1 unfollows user 2.
//        twitter.unfollow(1, 2);
//
//        // User 1's news feed should return a list with 1 tweet id -> [5],
//        // since user 1 is no longer following user 2.
//        System.out.println(twitter.getNewsFeed(1));

        //case 2
//        twitter.postTweet(1,5);
//        twitter.postTweet(2,3);
//        twitter.postTweet(1,101);
//        twitter.postTweet(2,13);
//        twitter.postTweet(2,10);
//        twitter.postTweet(1,2);
//        twitter.postTweet(1,94);
//        twitter.postTweet(2,505);
//        twitter.postTweet(1,333);
//        twitter.postTweet(2,22);
//        twitter.postTweet(1,11);
//        twitter.postTweet(1,205);
//        twitter.postTweet(2,203);
//        twitter.postTweet(1,201);
//        twitter.postTweet(2,213);
//        twitter.postTweet(1,200);
//        twitter.postTweet(2,202);
//        twitter.postTweet(1,204);
//        twitter.postTweet(2,208);
//        twitter.postTweet(2,233);
//        twitter.postTweet(1,222);
//        twitter.postTweet(2,211);
//        System.out.println(twitter.getNewsFeed(1));
//        twitter.follow(1,2);
//        System.out.println(twitter.getNewsFeed(1));

        //case 3
        Twitter2 twitter = new Twitter2();
        twitter.postTweet(2, 5);
        twitter.postTweet(1, 3);
        twitter.postTweet(1, 101);
        twitter.postTweet(2, 13);
        twitter.postTweet(2, 10);
        twitter.postTweet(1, 2);
        twitter.postTweet(2, 94);
        twitter.postTweet(2, 505);
        twitter.postTweet(1, 333);
        twitter.postTweet(1, 22);
        System.out.println(twitter.getNewsFeed(2));
        twitter.follow(2,1);
        System.out.println(twitter.getNewsFeed(2));
    }
}
