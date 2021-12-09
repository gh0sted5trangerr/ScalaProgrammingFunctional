package de.diederich.functional.sheet07


object Task1 {


  enum Baum[T]:
    case Knoten(wert: T, li:Baum[T], re:Baum[T])
    case Leer()

  import Baum.*
/*
  def main(args: Array[String]) : Unit = {
    val baum : Baum[Int] = Knoten(5, Knoten(3, Knoten(1, Leer(), Leer()), Leer()), Knoten(7, Knoten(6, Leer(), Leer())
      , Knoten(9, Leer(), Knoten(11, Leer(), Leer()))))

    val greater : (Int, Int) => Boolean = _ > _
    println(enthaelt[Int](greater)(4, baum))
    println(liste[Int](baum))
  }

  def enthaelt[T] (f: (T, T) => Boolean)(gesucht: T, b: Baum[T]) : Boolean = {
    b match {
      case Knoten(w,li,re) => {
        if(f(w, gesucht)) enthaelt[T](f)(gesucht, re)
        else if(f(gesucht,w)) enthaelt[T](f)(gesucht, li)
        else true
      }
      case Leer() => false
    }
  }

  def liste[T](b: Baum[T]) : List[T] = {
    b match {
      case Knoten(w, li, re) => liste(li) ::: List(w) ::: liste(re)
      case Leer() => List()
    }
  }

  def einL[T](gt:(T,T) => Boolean) (l : List[T], b: Baum[T]) : Baum[T] = {
    l match {
      case List() => b
      case x::xs => einL(gt)(xs, ein[T](gt)(x,b))
    }
  }

  def ein[T] (gt:(T,T) => Boolean)(value: T, b: Baum[T]) : Baum[T] = {
    b match {
      case Knoten(w, li, re) => {
        if (gt(value, w)) Knoten(w, ein(gt)(value, li), re)
        else if (gt(value, w)) {
          Knoten(w, li, ein(gt)(value, re))
        } else {
          b
        }
      }
      case Leer => Knoten(value, Leer(), Leer())
    }
  }
*/
}
