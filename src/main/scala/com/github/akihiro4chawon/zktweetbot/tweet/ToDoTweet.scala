package com.github.akihiro4chawon.zktweetbot.tweet

import java.util.Date
import scala.reflect.BeanProperty
import scala.collection.JavaConverters._

case class ToDoTweet(
  @BeanProperty var status: String,
  @BeanProperty var date: Date,
  @BeanProperty var id: Long)

object ToDoTweet {
  def apply(): ToDoTweet = new ToDoTweet("", new Date, 0L)
}

abstract class TweetDAO {
  def findAll(): java.util.List[ToDoTweet]
  def delete(tw: ToDoTweet): Boolean
  def insert(tw: ToDoTweet): Boolean
  def update(tw: ToDoTweet): Boolean
}

class EphimeralTweetDAO extends TweetDAO {
  private val nextId = Iterator.iterate(1L)(1 +) //Iterator.from(1)
  private val tweets = collection.mutable.Map.empty[Long, ToDoTweet]
  
  def findAll() = tweets.values.toBuffer.asJava
  def delete(tw: ToDoTweet) = tweets.remove(tw.id).nonEmpty
  def insert(tw: ToDoTweet) = {
    tw.id = nextId.next
    tweets(tw.id) = tw.copy()
    true
  }
  def update(tw: ToDoTweet) = {
    val ret = tweets.contains(tw.id)
    if (ret)
      tweets(tw.id) = tw.copy()
    ret
  }
}

