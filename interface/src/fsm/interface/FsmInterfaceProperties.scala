package fsm.interface

import scala.io.Source
import upickle.default._

trait FsmInterfaceProps {
  val localHost: String
  val localPort: Int = 8080
  val localUrl: String

  val remoteHost: String
  val remotePort: Int = 8080
  val remoteUrl: String
}

abstract class JsonProps {
  protected val json: ujson.Value.Value
}
 
object FsmInterfaceProperties extends JsonProps with FsmInterfaceProps {
  // inlined constants, order-dependent, these need to come first
  final private val _Http: String = "http://"
  final private val _Delim: String = ":"

  final override protected val json = ujson.read(Source.fromResource("FsmInterface.properties.xml").getLines.mkString)

  val localHost = json("localHost").str
  override val localPort: Int = json("localPort").num.toInt
  val localUrl: String = mkUrl(localHost, localPort)

  val remoteHost: String = json("remoteHost").str
  override val remotePort: Int = json("remotePort").num.toInt
  val remoteUrl: String = mkUrl(remoteHost, remotePort)

  private def mkUrl(host: String, port: Int): String = _Http + host + _Delim + port

} // FsmInterfaceProperties