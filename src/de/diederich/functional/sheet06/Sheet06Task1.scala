package de.diederich.functional.sheet06

object Sheet06Task1 {

  type Kassenzetteleintrag = (Int, String, Double)
  type Kassenzettel = List[Kassenzetteleintrag]
  val z1 : Kassenzettel = List ((50,"Benzin",1.37),(2,"Scheibenwischer",5.00),(1,"Autowaesche",10.00),(1,"Kaugummi",0.99))

  def main(strgs: Array[String]) : Unit = {
    val list = (1 to 6).toList
    println("Ausgangsliste: "+ list)
    println("Liste + 5: "+map[Int, Int](list)(_+5))
    println("Integerliste zu Stringliste: "+intListToStringList(list))
    println("Ausgangskassenzettel: "+ z1)
    println("Erhöhter zettel: "+ increaseAmountOfProducts(z1))
  }

  /**
   * @title Task 1 a
   */
  def map[A,B](as: List[A])(f: A => B): List[B] = {
    as match {
      case List() => List()
      case x::xs => f(x):: map(xs)(f)
    }
  }
  /**
   * @title Task 1 b
   */
  def intListToStringList(list: List[Int]) : List[String] = {
    list.map(x => x.toString).toList
  }
  /**
   * @title Task 1 c
   */
  def increaseAmountOfProducts(zettel: Kassenzettel) : Kassenzettel = {
    zettel.map(x => (x._1+1,x._2, x._3)).toList
  }



}
