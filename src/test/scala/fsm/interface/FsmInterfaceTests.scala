package fsm.interface

import io.undertow.Undertow
import utest._

object FsmInterfaceTests extends TestSuite {
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

  val tests = Tests {
    test("echo") - withServer(FsmInterfaceMain) { host =>
      val success = requests.get(s"$host/echo")
      success.text() ==> "{ available }"
      success.statusCode ==> 200
    }

    test("doesnt-exist") - withServer(FsmInterfaceMain) { host =>
      requests.get(s"$host/doesnt-exist", check = false).statusCode ==> 404
    }
  } // tests
} // FsmInterfaceTests
