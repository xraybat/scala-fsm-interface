package fsm.interface

import utest._
import upickle.default._
import pprint._

object FsmInterfacePropertiesTests extends TestSuite {
    
  val tests = Tests {
    test("localHost") { 
      FsmInterfaceProperties.localHost ==> "http://localhost:8080"
    }
  } // tests
} // FsmInterfacePropertiesTests
