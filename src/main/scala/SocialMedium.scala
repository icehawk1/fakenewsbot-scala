import java.util.Date

import twitter4j.TwitterFactory

import scala.collection.mutable

/**
  * Created by martin on 28.08.17.
  */
abstract class SocialMedium extends Disconnectable{

}

class TwitterFacade extends SocialMedium {
  val twitter = TwitterFactory.getSingleton();
  val msgQueue = new mutable.PriorityQueue[Message]();
  val seenTweets = new mutable.HashSet[Int]()
  final val REFILL_SIZE = 2

  def refillMessageQueue() = ???

  def retrieveNextMessage():Message = {
    if (msgQueue.size <= REFILL_SIZE) refillMessageQueue();
    return msgQueue.dequeue()
  }

  override def disconnect(): Unit = {
    // Hier gibt es nichts zu tun
  }
}

case class Message(id:Long,username:String,text:String,createdAt:Date, priority:Int) extends Ordered[Message] {
  def compare(that: Message): Int = this.priority compare that.priority
}