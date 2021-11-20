package de.diederich.functional.sheet06

object Sheet06Task1 {
  def main(strgs: Array[String]) : Unit = {
   list: List[Int] = (1,2,3,4,5,6)
    print(map[Int, Int](list, (_+5)))*/
  }

  def map[A,B](as: List[A])(f: A => B): List[B] = {
    as match {
      case List() => List()
      case x::xs => f(x):: map(as)(f)
    }
  }


}
