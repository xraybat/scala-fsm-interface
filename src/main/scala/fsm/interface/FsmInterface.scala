package fsm.interface

import fsm.machine._
import fsm.machine.pingpong._

// split routes from main
case class FsmInterfaceRoutes()
  (implicit val log: cask.Logger)
    extends cask.Routes {

  @cask.get("/echo")
  def hello() = "{ available }"

  @cask.post("/ping")
  def ping(request: cask.Request) = {
    // specifying 'ac' context explicitly since cask uses castor too.
    val pp = new PingPongPlayer(java.time.Duration.ofMillis(20))(ContextPrefs.ac)
  }

  initialize()

} // FsmInterfaceRoutes

object FsmInterfaceMain extends cask.Main {
  val allRoutes = Seq(FsmInterfaceRoutes())
}