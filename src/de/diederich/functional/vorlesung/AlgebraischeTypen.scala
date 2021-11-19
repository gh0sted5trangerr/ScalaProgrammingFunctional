package de.diederich.functional.vorlesung

object AlgebraischeTypen {

  def main(args: Array[String]) : Unit = {
    enum Dreieck:
      case Entartet, Gleichseitig, Gleichschenklig, Normal

    /**
     * Binary trees
     */
    enum Baum:
      case Knoten(wert: Int, li: Baum, re: Baum)
      case Leer()


    import Baum.*
    def hoehe(baum: Baum) : Int = {
      baum match {
        case Leer()=> 0
        case Knoten(i, re, li) => 1+math.max(hoehe(re), hoehe(li))
      }
    }

    def zahlen (b:Baum) : List[Int] = b match
      case Leer()          => List()
      case Knoten(w,li,re) => zahlen(li) ::: w::zahlen(re)

    val baum =
      Knoten(
        3,
        Knoten(1, Leer(), Knoten(2, Leer(), Leer())),
        Knoten(5, Knoten(4, Leer(), Leer()),
          Knoten(7, Knoten(6, Leer(), Leer()), Leer())))
    println(zahlen(baum))
  }


}
