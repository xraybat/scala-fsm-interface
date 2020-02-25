import $ivy.`com.lihaoyi::requests:0.5.1`
import pprint._
import upickle.default._

// requires fsm-interface.FsmInterface to be up and running
val host = "http://localhost:8080"

val echo = requests.get(s"$host/echo")
assert(echo.statusCode == 200)
assert(echo.text() == ujson.write(ujson.Obj("response" -> ujson.Str("available"))))
pprint.log(echo.text())

val ping = requests.post(s"$host/ping")
assert(ping.statusCode == 200)
assert(ping.text() == ujson.write(ujson.Obj("response" -> ujson.Str("pinged"))))
pprint.log(ping.text())
