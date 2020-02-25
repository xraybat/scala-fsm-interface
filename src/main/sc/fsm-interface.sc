import $ivy.`com.lihaoyi::requests:0.5.1`
import $ivy.`com.lihaoyi::pprint:0.5.9`, pprint._

// requires fsm-interface.FsmInterface to be up and running
val host = "http://localhost:8080"
val resp = requests.get(s"$host/echo")
pprint.log(resp.statusCode)
pprint.log(resp.text())