package de.diederich.functional.sheet05

object Sheet05Task1 {

  def main(args: Array[String]) : Unit = {
    //task 1 a
    val add: (Int, Int) => Int = _+_
    println(add(1,5))

    def test = curryZweistellligInt((_*_))
  }

  def mult(x: Int) (y:Int) = x*y

  def curryZweistellligInt(f: (Int, Int) => Int) : Int => Int => Int = {
    def curry(x: Int): Int => Int = {
      f(x,_)
    }
    curry(_)
  }

  def unCurryZweistelligInt(f: Int => (Int => Int)) : (Int,Int) => Int = {
    def unCurry(x: Int, y:Int): Int = {
      f(x)(y)
    }
    unCurry(_,_)
  }

  def modifyList(l: List[Int], f: Int => Int): List[Int] = l match {
    case x::xs => f(x) :: modifyList(xs, f)
    case List() => List()
  }

  val l: List[Int] = List(1,2,3,4,5)
  val l2 : List[Int] = modifyList(l, _+5)

  def test = curryZweistellligInt((_+_))
  def untest = unCurryZweistelligInt(test)

}
