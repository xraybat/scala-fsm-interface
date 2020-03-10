package fsm.interface

import io.undertow.Undertow
import utest._
import upickle.default._
import pprint._

object FsmInterfaceTests extends TestSuite {
  def withServer[T](example: cask.main.Main)(f: String => T): T = {
    val server = Undertow.builder
      .addHttpListener(FsmInterfaceProperties.localPort, FsmInterfaceProperties.localHost)
      .setHandler(example.defaultHandler)
      .build
    server.start()
    
    val res =
      try f(FsmInterfaceProperties.localUrl)
      finally server.stop()

    res

  } // withServer

  val tests = Tests {
    test("echo") - withServer(FsmInterfaceMain) { host =>
      val success = requests.get(s"$host/echo")
      success.statusCode ==> 200
      success.text() ==> ujson.write(ujson.Obj("response" -> ujson.Str("available")))
    }

    test("doesnt-exist") - withServer(FsmInterfaceMain) { host =>
      requests.get(s"$host/doesnt-exist", check = false).statusCode ==> 404
    }

    test("ping") - withServer(FsmInterfaceMain) { host =>
      val success = requests.post(s"$host/ping")
      success.statusCode ==> 200
      success.text() ==> ujson.write(ujson.Obj("response" -> ujson.Str("pinged")))
    }
  } // tests
} // FsmInterfaceTests
