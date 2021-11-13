package de.diederich.functional.sheet05

object Sheet05Task2 {
  def main(args: Array[String]) : Unit = {
    genericTask()
  }

  def genericTask() : Unit =  {
    type Kassenzetteleintrag = (Int, String, Double)
    type Kassenzettel = List[Kassenzetteleintrag]

    def gleich(a : Kassenzetteleintrag, b : Kassenzetteleintrag) : Boolean = a == b
    def gleichKassenzettel(a : Kassenzettel, b : Kassenzettel) : Boolean = a == b
    def kgAnzahl(a : Kassenzetteleintrag, b : Kassenzetteleintrag) : Boolean = a._1 <= b._1
    def kgName(a : Kassenzetteleintrag, b : Kassenzetteleintrag) : Boolean = a._2 <= b._2
    def kgPreis(a : Kassenzetteleintrag, b : Kassenzetteleintrag) : Boolean = a._3 <= b._3
    def kgPostenpreis(a : Kassenzetteleintrag, b : Kassenzetteleintrag) : Boolean = a._1*a._3<=b._1*b._3
    def kgGesamtPreis(a: Kassenzettel, b: Kassenzettel) : Boolean = {
      def pGesamtPreis(list: Kassenzettel): Double = {
        if list.length == 0 then 0
        else list.head._1*list.head._3+ pGesamtPreis(list.tail)
      }
      val ap = pGesamtPreis(a)
      val bp = pGesamtPreis(b)
      if (ap < bp) true
      else if(ap == bp) a.length<=b.length
      else false
    }

    def maxSort[T](k: (T,T) => Boolean) (list: List[T]) : List[T] = {
      def streiche[T](y: T, list: List[T]) : List[T] ={
        if (list.length == 0) List()
        else if (list.head == y) list.tail
        else list.head :: streiche(y, list.tail)
      }
      def maxOfList[T](k: (T,T) => Boolean) (list:List[T]) : T = {
        if list.length == 1 then list.head
        else if k(list.head, list.tail.head) then maxOfList(k)(list.tail)
        else maxOfList(k)(list.head :: list.tail.tail)
      }

      if (list.length <= 1) list
      else{
        val max = maxOfList[T](k)(list)
        val listNew = streiche[T](max, list)
        maxSort(k)(listNew) ::: List(max)
      }
    }

    def kPostenpreis(a : Kassenzetteleintrag, b : Kassenzetteleintrag) : Boolean = a._1*a._3<b._1*b._3

    def kPostenpreisListe(a : Kassenzettel, b : Kassenzettel) : Boolean = {
      def gesamtPreis(list: Kassenzettel) : Double = {
        if list.length == 0 then 0
        else list.head._1 * list.head._3 + gesamtPreis(list.tail)
      }
      gesamtPreis(a) < gesamtPreis(b)
    }

    val z1 : Kassenzettel = List ((50,"Benzin",1.37),(2,"Scheibenwischer",5.00),(1,"Autowaesche",10.00),(1,"Kaugummi",0.99))
    val z2 : Kassenzettel = List ((3,"Mars",0.80),(1,"Kaffee",1.60),(10,"Scheibenwischer",1.59))
    val z3 : Kassenzettel = List ((5,"Mars",0.80),(10,"Scheibenwischer",1.59))
    val l1 : List[Kassenzettel] = List(z1, z2, z3)
    def maxSortKassenZettelEintraege = maxSort[Kassenzetteleintrag](kPostenpreis(_,_))_
    def maxSortKassenZettelListe = maxSort[Kassenzettel](kPostenpreisListe(_,_))_
    println(maxSortKassenZettelListe(l1))
    println(maxSortKassenZettelEintraege(z1))
    println(maxSortKassenZettelEintraege(z2))
    println(maxSortKassenZettelEintraege(z3))
  }

}


