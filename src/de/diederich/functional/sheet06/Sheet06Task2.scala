package de.diederich.functional.sheet06

object Sheet06Task2 {
  enum Farbe:
    case Kreuz, Pik, Herz, Karo

  enum Wert:
    case Sieben, Acht, Neun, Bube, Dame, Koenig, Zehn, As

  import Farbe.*, Wert.*
  type Karte = (Farbe, Wert)
  type Stich = (Karte, Karte)
  val karte = (Kreuz, As)
  val karte1 = (Kreuz, Koenig)
  val stichListe = List((karte, karte1), ((Herz, Sieben), (Herz, Acht)))

  def main(args: Array[String]) : Unit = {
    println("Zählwert: "+zaehlwert(Sieben))
    println("Kartenwert: "+kartenwert(karte))
    println("Bekommt Stich: "+meinStich(karte, karte1))
    println("Stichsumme: "+ stichSumme(stichListe))
  }

  def zaehlwert(n: Wert) : Int = {
    n match {
      case Bube => 2
      case Dame => 3
      case Koenig => 4
      case Zehn => 10
      case As => 11
      case _ => 0
    }
  }

  def kartenwert(k: Karte) : Int = {
    zaehlwert(k._2)
  }

  def meinStich(k1: Karte, k2:Karte) : Boolean = {
    def glFarbe(x: Farbe, y: Farbe): Boolean = {
      x.ordinal == y.ordinal
    }
    def klWert(x: Wert, y: Wert) : Boolean = {
      (zaehlwert(x), zaehlwert(y)) match {
        case (0,0) => x.ordinal < y.ordinal
        case (_,0) => false
        case (0,_) => true
        case (x,y) => x < y
      }
    }
    if((glFarbe(k1._1, k2._1) && !klWert(k1._2, k2._2)) || !glFarbe(k1._1,k2._1)) true
    else false
  }

  def stichSumme(x: List[Stich]) : Int = {
    x.map(x => zaehlwert(x._1._2)+zaehlwert(x._2._2)).toList.reduceLeft(_+_)
  }

}
