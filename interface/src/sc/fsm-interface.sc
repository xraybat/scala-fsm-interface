import $ivy.`com.lihaoyi::requests:0.5.1`
import pprint._
import upickle.default._

// requires fsm.interface.FsmInterfaceMain to be up and running via:
//
//   java -cp .../out.jar fsm.interface.FsmInterfaceMain
val localHost = "http://localhost:8080"

val echo = requests.get(s"$localHost/echo")
assert(echo.statusCode == 200)
assert(echo.text() == ujson.write(ujson.Obj("response" -> ujson.Str("available"))))
pprint.log(echo.text())

val ping = requests.post(s"$localHost/ping")
assert(ping.statusCode == 200)
assert(ping.text() == ujson.write(ujson.Obj("response" -> ujson.Str("pinged"))))
pprint.log(ping.text())

// requires remote java -cp ./out.jar fsm.interface.FsmInterfaceMain to be up and running
/*val remoteHost = "http://157.230.34.162:8080"

val echo = requests.get(s"$remoteHost/echo")
assert(echo.statusCode == 200)
assert(echo.text() == ujson.write(ujson.Obj("response" -> ujson.Str("available"))))
pprint.log(echo.text())
*/