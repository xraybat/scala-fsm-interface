package fsm.interface

import io.undertow.Undertow
import utest._

object FsmInterfaceTests extends TestSuite{
  def withServer[T](example: cask.main.Main)(f: String => T): T = {
    val server = Undertow.builder
      .addHttpListener(8080, "localhost")
      .setHandler(example.defaultHandler)
      .build
    server.start()
    
    val res =
      try f("http://localhost:8080")
      finally server.stop()

    res

  } // withServer

  val tests = Tests{
    test("FsmInterface") - withServer(FsmInterfaceMain){ host =>
      val success = requests.get(host)

      success.text() ==> "hello, world!"
      success.statusCode ==> 200

      requests.get(s"$host/doesnt-exist", check = false).statusCode ==> 404
      requests.get(s"$host/do-thing", check = false).statusCode ==> 404

    } // tests.FsmInterface
  } // tests
} // FsmInterfaceTests
