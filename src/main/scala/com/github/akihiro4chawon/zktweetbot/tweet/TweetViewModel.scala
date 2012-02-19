package com.github.akihiro4chawon.zktweetbot.tweet

import java.util.List
import scala.reflect.BeanProperty
import org.zkoss.bind.annotation.{Command, NotifyChange}

class TweetViewModel {
  private val tweetDao: TweetDAO = new EphimeralTweetDAO()
  
  @BeanProperty
  var selectedTweet: ToDoTweet = _
  
  @BeanProperty
  var newTweet: ToDoTweet = ToDoTweet()
  
  def getTweets = tweetDao.findAll
  
  @Command(Array("add"))
  @NotifyChange(Array("tweets", "newTweet"))
  def add() {
    tweetDao.insert(newTweet)
    newTweet = ToDoTweet()
  }

  @Command(Array("update"))
  @NotifyChange(Array("tweets"))
  def update() {
    tweetDao.update(selectedTweet)
  }
  
  @Command(Array("delete"))
  @NotifyChange(Array("tweets", "selectedTweet"))
  def delete() {
    if (selectedTweet != null) {
      tweetDao.delete(selectedTweet)
      selectedTweet = null
    }
  }
}

