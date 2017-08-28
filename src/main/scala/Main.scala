import ch.qos.logback.classic.Logger
import org.slf4j.{Logger, LoggerFactory}
import twitter4j.TwitterException

import scala.collection.mutable

class Main() {
  val mediaList = buildDatasources()
  val quellenliste = buildFaktenQuellen()
  val watson = connectToWatson()
  val threads = Set[Thread]()
  val logger = LoggerFactory.getLogger("fakenewsbot")

  def buildDatasources():List[SocialMedium] = {
    var result = List[SocialMedium]()
    val adsf = 1 :: 2 :: Nil
    try {
      result = new TwitterFacade() :: Nil
      return result
    } catch {
      case ex:TwitterException => {logger.warn("Konnte TwitterFacade nicht erzeugen", ex);}
    }
    return result
  }

  def connectToWatson():Watson = ???
  def buildFaktenQuellen():mutable.MutableList[Faktenquelle] = ???

  def startMonitoringForFakeNews = {

  }

  def stop = {
    mediaList.foreach { _.disconnect() }
    quellenliste.foreach { _.disconnect() }
    watson.disconnect()
  }
}

trait Disconnectable {
  def disconnect()
}