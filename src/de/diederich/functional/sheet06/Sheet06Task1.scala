package de.diederich.functional.sheet06

object Sheet06Task1 {
  def main(strgs: Array[String]) : Unit = {
    list = (1 to 7).toList
    print(map[Int, Int](list, (_+5)))
  }

  def map[A,B](as: List[A])(f: A => B): List[B] = {
    as match {
      case List() => as
      case x::xs => f(x):: map(as)(f)
    }
  }


}
