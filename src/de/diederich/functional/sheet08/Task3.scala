package de.diederich.functional.sheet08

object Task3 {

  enum Baum[A, B]:
    case Knoten(value: A, li: Baum[A, B], re: Baum[A, B])
    case Blatt(value: B)

  enum Inhalt[A,B]:
    case KnotenInhalt(value: A)
    case BlattInhalt(Value: B)

  enum Op:
    case Plus, Mal

  import Op.*
  import Baum.*
  import Inhalt.*

  type ArithBaum = Baum[Op, Int]

  def main(args: Array[String]) : Unit = {
    val baum : ArithBaum = Knoten(Mal, Knoten(Plus, Blatt(3), Blatt(7)), Knoten(Mal, Blatt(6), Knoten(Plus, Blatt(5), Blatt(2))))
    println(baum)
    println(zeigeBaum(baum))
    println(toList(Knoten(Mal, Knoten(Plus, Blatt(3), Blatt(7)), Knoten(Mal, Blatt(6), Knoten(Plus, Blatt(5), Blatt(2))))))
    println(opAnzahl(baum))
    def evalTest(w: Op, li : Int, re: Int) : Int = {
      w match {
        case Plus => (li+re)
        case Mal => li*re
      }
    }
    println(eval(baum, evalTest))
  }

  def eval(b : ArithBaum) : Int = {
    def evalTest(w: Op, li : Int, re: Int) : Int = {
      w match {
        case Plus => (li + re)
        case Mal => li * re
      }
    }
    eval(b, evalTest)
  }

  def eval[A,B] (b : Baum[A,B], f: (A,B,B) => B) : B = {
    b match {
      case Knoten(w, li, re) => f(w, eval(li, f), eval(re, f))
      case Blatt(w) => w
    }
  }

  def opAnzahl(b: ArithBaum) : Int = {
    toListArith(b).filter(x => {
      x match {
        case KnotenInhalt(_) => true
        case BlattInhalt(_) => false
      }
    }).length
  }

  def toListArith(b: ArithBaum) : List[Inhalt[Op, Int]] = {
    b match {
      case Knoten(w, li, re) => {
        toList(li) ::: List(KnotenInhalt(w)) ::: toList(re)
      }
      case Blatt(w) => {
        List(BlattInhalt(w))
      }
    }
  }

  def toList[A,B] (b: Baum[A, B]) : List[Inhalt[A,B]] = {
    b match {
      case Knoten(w, li, re) => {
        toList(li) ::: List(KnotenInhalt(w)) ::: toList(re)
      }
      case Blatt(w) => {
        List(BlattInhalt(w))
      }
    }
  }

  def zeigeBaum(b: ArithBaum) : String = {
    def pZeigeBaum(i : Int, baum: ArithBaum) : String = {
      baum match {
        case Knoten(w , li, re) => {
          w match {
            case Mal => "*\t"+ pZeigeBaum(i+1, li)+"\n"+"\t"*(i+1)+pZeigeBaum(i+1, re)
            case Plus => "+\t"+ pZeigeBaum(i+1, li)+"\n"+"\t"*(i+1)+pZeigeBaum(i+1, re)
          }
        }
        case Blatt(v)=> v+""
        case _ => ""
      }
    }
    pZeigeBaum(0, b)
  }

}
