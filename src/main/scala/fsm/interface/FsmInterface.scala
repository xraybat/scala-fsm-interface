package fsm.interface

// split routes from main
case class FsmInterfaceRoutes()
  (implicit val log: cask.Logger)
    extends cask.Routes {

  @cask.get("/")
  def hello() = "hello, world!"

  @cask.post("/do-thing")
  def doThing(request: cask.Request) = request.text().reverse

  initialize()

} // FsmInterfaceRoutes

object FsmInterfaceMain extends cask.Main {
  val allRoutes = Seq(FsmInterfaceRoutes())
}