import com.mashape.unirest.http.exceptions.UnirestException
import com.mashape.unirest.http.{HttpResponse, JsonNode, Unirest}
import org.slf4j.LoggerFactory

class Watson extends Disconnectable {
  val logger = LoggerFactory.getLogger("fakenewsbot")
  val apiversion = "2017-05-26"
  val user = ""
  val password = ""

  def retrieveWorkspaces():List[String] = {
    try {
      val response: HttpResponse[JsonNode] = Unirest.get("https://gateway.watsonplatform.net/conversation/api/v1/workspaces?version="
        + apiversion).basicAuth(user, password).asJson();
      val body: String = response.getBody().toString();
      val jsonArray = response.getBody().getArray().getJSONArray(0);
      return null;
    } catch {
      case ex:UnirestException => logger.warn("Konnte Workspaces nicht lesen",ex);
    }
    return Nil
  }

  override def disconnect(): Unit = ???
}
