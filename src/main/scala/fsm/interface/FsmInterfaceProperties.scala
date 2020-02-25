package fsm.interface

import scala.io.Source
import upickle.default._

object FsmInterfaceProperties {
  private val jsonProperties = ujson.read(Source.fromResource("FsmInterface.properties.xml").getLines.mkString)

  val localHost: String = jsonProperties("localHost").str

} // FsmInterfaceProperties