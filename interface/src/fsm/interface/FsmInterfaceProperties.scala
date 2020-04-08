package fsm.interface

import scala.io.Source
import upickle.default._

trait Props {
  val localHost: String
  val localPort: Int = 8080
  val localUrl: String

  val remoteHost: String
  val remotePort: Int = 8080
  val remoteUrl: String
}

// *qu:* make a json struct based on trait to be fleshed out by FsmInterfaceProperties??
abstract class JsonProps {
  protected val jsonProperties: ujson.Value.Value
}
 
object FsmInterfaceProperties extends JsonProps with Props {
  // order-dependent: these need to come first
  final private val _Http: String = "http://"
  final private val _Delim: String = ":"

  final override protected val jsonProperties: ujson.Value.Value = ujson.read(Source.fromResource("FsmInterface.properties.xml").getLines.mkString)

  val localHost: String = jsonProperties("localHost").str
  override val localPort: Int = jsonProperties("localPort").num.toInt
  val localUrl: String = mkUrl(localHost, localPort)

  val remoteHost: String = jsonProperties("remoteHost").str
  override val remotePort: Int = jsonProperties("remotePort").num.toInt
  val remoteUrl: String = mkUrl(remoteHost, remotePort)

  private def mkUrl(host: String, port: Int): String = _Http + host + _Delim + port

} // FsmInterfaceProperties