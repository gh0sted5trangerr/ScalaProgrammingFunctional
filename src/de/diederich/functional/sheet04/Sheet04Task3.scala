package de.diederich.functional.sheet04

object Sheet04Task3 {

  def main(args: Array[String]) : Unit = {
    System.out.println(maxSort(List(1,5,33,18,19,27)))
  }

  //task 3 a
  def maxOfList(list: List[Int]) : Int = {
    if(list.isEmpty) 0
    def maxIterator(currentMax: Int, list: List[Int]): Int = {
      list match {
        case List() => currentMax
        case _ => {
          if (list.head > currentMax) maxItterator(list.head, list.tail)
          else maxItterator(currentMax, list.tail)
        }
      }
    }
    maxIterator(0, list)
  }

  //task 3 b
  def streiche(garbage: Int, list: List[Int]) : List[Int] = {
    def streicheListe(number: Int, list: List[Int], garbage: List[Int]) : List[Int] = {
      list match {
        case List() => garbage:::list
        case _ => {
          if(number == list.head) garbage:::list.tail
          else  streicheListe(number, list.tail, garbage ::: List(list.head))
        }
      }
    }
    streicheListe(garbage, list, List())
  }

  //task 3 c
  def maxSort(list: List[Int]) : List[Int] = {
    def pMaxSort(remaining: List[Int], list: List[Int]) : List[Int] = {
      remaining match {
        case List() => list
        case _ => {
          val currentMax = maxOfList(remaining)
          pMaxSort(streiche(currentMax, remaining), currentMax::list)
        }
      }
    }
    pMaxSort(list, List())
  }

}
