import mill._, scalalib._

object interface extends ScalaModule{
  def scalaVersion = "2.13.1"

  def ivyDeps = Agg(
    ivy"com.lihaoyi::cask:0.5.6",
    ivy"com.lihaoyi::upickle:0.9.5",
    ivy"com.lihaoyi::requests:0.5.1",
    ivy"com.lihaoyi::pprint:0.5.9",

    ivy"au.com.carringbushsw::fsm-machine:0.0.1"
  )
  
  object test extends Tests{
    def testFrameworks = Seq("utest.runner.Framework")

    def ivyDeps = Agg(
      ivy"com.lihaoyi::utest::0.7.3",
    )
  }
}