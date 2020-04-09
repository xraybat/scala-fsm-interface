package fsm.interface

import utest._
import upickle.default._
import pprint._

object FsmInterfacePropertiesTests extends TestSuite {
    
  val tests = Tests {
    test("localHost") { 
      FsmInterfaceProperties.localHost ==> "localhost"
    }
    test("localPort") { 
      FsmInterfaceProperties.localPort ==> 8080
    }
    test("localUrl") { 
      FsmInterfaceProperties.localUrl ==> "http://localhost:8080"
    }

    test("remoteHost") { 
      assert(FsmInterfaceProperties.remoteHost.length > 0)
    }
    test("remotePort") { 
      FsmInterfaceProperties.remotePort ==> 8080
    }
    test("remoteUrl") { 
      FsmInterfaceProperties.remoteUrl ==>
        "http://" + 
        FsmInterfaceProperties.remoteHost +
        ":" +
        FsmInterfaceProperties.remotePort
    }
  } // tests
} // FsmInterfacePropertiesTests
