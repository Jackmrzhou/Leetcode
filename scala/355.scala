import scala.collection.mutable
class Twitter() {

    /** Initialize your data structure here. */
    var ts = 0
    case class tweet(tweetId: Int, ts: Int)
    val newsFeeds = mutable.Map[Int, mutable.ListBuffer[tweet]]()
    val userPosts = mutable.Map[Int, mutable.ListBuffer[tweet]]()
    val followers = mutable.Map[Int, mutable.Set[Int]]()
    
    /** Compose a new tweet. */
    def postTweet(userId: Int, tweetId: Int) {
        ts += 1
        val tw = tweet(tweetId, ts)
        if (userPosts.contains(userId)) {
            userPosts(userId) += tw
        } else {
            userPosts += (userId -> (mutable.ListBuffer(tw)))
        }
        newsFeeds.get(userId) match {
            case None => newsFeeds += (userId -> (mutable.ListBuffer(tw)))
            case Some(value) => value += tw
        }
        followers.get(userId).getOrElse(Set()).foreach(user => {
            if (newsFeeds.contains(user)) {
                newsFeeds(user) += tw
            } else {
                newsFeeds += (user -> (mutable.ListBuffer(tw)))
            }
        })
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    def getNewsFeed(userId: Int): List[Int] = {
        if (newsFeeds.contains(userId)) newsFeeds(userId).reverse.slice(0, 10).map(_.tweetId).toList
        else Nil
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    def follow(followerId: Int, followeeId: Int) {
        if (followeeId != followerId) {
            followers.get(followeeId) match {
                case None => followers += (followeeId -> mutable.Set[Int](followerId))
                case Some(value) => if (value.contains(followerId)) return else value += followerId
            }
            userPosts.get(followeeId) match {
                case Some(value) => newsFeeds += (followerId -> (newsFeeds.getOrElse(followerId, new mutable.ListBuffer()) ++ value).sortBy(_.ts))
                case None => ()
            }
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    def unfollow(followerId: Int, followeeId: Int) {
        if (followeeId != followerId) {
            followers.get(followeeId) match {
                case Some(value) => {
                    if (value.contains(followerId)) {
                        value -= followerId
                        val feeds = newsFeeds(followerId)
                        for (tw <- userPosts.getOrElse(followeeId, new mutable.ListBuffer())) {
                            feeds -= tw
                        }
                    }
                }
                case None => ()
            }
        }
    }

}