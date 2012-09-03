package test

object Test {

  def sum(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int =
      if (a > b) 0 else f(a) + sumF(a + 1, b)
    sumF
  }

  def sumSquares = sum(x => x * x)

  def matchTest(x: Any): Any = x match {
    case 1 => "one"
    case "two" => 2
    case y: Int => "scala.Int"
    case _ => "unknown"
  }
  println(matchTest("two"))

  val xml = <a><b>123</b><c>Works</c></a>
  def matchXML = xml match {
    case <a><b>123</b><c>{ x }</c></a> => println(x)
    case _ => println("Not match")
  }
  matchXML //result = Works
  def main(args: Array[String]) {
    println(sumSquares(2, 5)) ///result = 54
  }

  def loop(body: => Unit): LoopUnlessCond =
    new LoopUnlessCond(body)
  protected class LoopUnlessCond(body: => Unit) {
    def unless(cond: => Boolean) {
      body
      if (!cond) unless(cond)
    }
  }
  var i = 10
  loop {
    println("i = " + i)
    i -= 1
  } unless (i == 0)
}