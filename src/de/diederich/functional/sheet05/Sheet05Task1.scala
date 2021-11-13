package de.diederich.functional.sheet05

object Sheet05Task1 {

  def main(args: Array[String]) : Unit = {
    //task 1 a
    val add: (Int, Int) => Int = _+_
    println(add(1,5))
  }

  def mult(x: Int) (y:Int) = x*y


}
