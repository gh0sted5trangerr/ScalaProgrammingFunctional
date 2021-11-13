package de.diederich.functional.sheet05

object Sheet05Task2 {
  def main(args: Array[String]) : Unit = {

  }

  def genericTask() : Unit =  {
    type Kassenzetteleintrag = (Int, String, Double)
    type Kassenzettel = List[Kassenzetteleintrag]

    def kgVergleich[T](a: T, b: T) : Boolean = {
      a <= b
    }

    def kgPostenpreis(a: Kassenzetteleintrag, b: Kassenzetteleintrag) : Boolean = {
      kgVergleich(a._1*a._3, b._1*b._3)
    }

    def kgAnzahl(a: Kassenzetteleintrag, b: Kassenzetteleintrag) : Boolean = {
      kgVergleich(a._1, b._1)
    }

    def kgPreis(a: Kassenzetteleintrag, b: Kassenzetteleintrag) : Boolean = {
      kgVergleich(a._2, b._2)
    }

    def kgName(a: Kassenzetteleintrag, b: Kassenzetteleintrag) : Boolean = {
      kgVergleich(a._3, b._3)
    }
  }

  def genericTask2() : Unit =  {
    type Kassenzettel = List[Kassenzetteleintrag]
    type Kassenzetteleintrag = (Int, String, Double)

    def kgAnzahl(a: Kassenzetteleintrag, b:Kassenzetteleintrag):Boolean = {
      if (a._1 < b._1) true
      else false
    }
  }
}


