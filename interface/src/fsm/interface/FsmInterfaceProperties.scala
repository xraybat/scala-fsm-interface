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

} // Props

// *qu:* make a json struct based on trait to be fleshed out by FsmInterfaceProperties??

object FsmInterfaceProperties extends Props {
  private val jsonProperties = ujson.read(Source.fromResource("FsmInterface.properties.xml").getLines.mkString)

  val localHost: String = jsonProperties("localHost").str
  override val localPort: Int = jsonProperties("localPort").num.toInt
  val localUrl: String = "http://" + localHost + ":" + localPort

  val remoteHost: String = jsonProperties("remoteHost").str
  override val remotePort: Int = jsonProperties("remotePort").num.toInt
  val remoteUrl: String = "http://" + remoteHost + ":" + remotePort

} // FsmInterfaceProperties