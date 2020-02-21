package fsm.interface

import fsm.machine.pingpong._

// split routes from main
case class FsmInterfaceRoutes()
  (implicit val log: cask.Logger)
    extends cask.Routes {

  @cask.get("/echo")
  def echo() = "{ available }" // qu: use upickle for these responses??

  @cask.post("/ping")
  def ping(request: cask.Request) = {
    val pp = new PingPongPlayer(java.time.Duration.ofMillis(20))
    assert(pp.initialState == pp.Idle())
    pp.send(Ping())
    /*Thread.sleep(200)
    assert(pp.state == pp.AwaitingReturn()) // straight away?? NO!!
    */
    "{ pinged }"
  }

  initialize()

} // FsmInterfaceRoutes

object FsmInterfaceMain extends cask.Main {
  val allRoutes = Seq(FsmInterfaceRoutes())
}