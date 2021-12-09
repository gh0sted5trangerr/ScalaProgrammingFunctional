enum Baum:
  case Knoten(wert:Int, li:Baum, re:Baum)
  case Leer()

import Baum.*

val baum = Knoten(5, Knoten(3, Knoten(1, Leer, Leer), Leer), Knoten(7, Knoten(6, Leer, Leer)
  , Knoten(9, Leer, Knoten(11, Leer, Leer))))

def enthaelt (gesucht: Int, b: Baum) : Boolean = {
  b match {
    case Knoten(w,li,re) => {
      if(gesucht == w) true
      else if(gesucht < w) enthaelt(gesucht, li)
      else enthaelt(gesucht, re)
    }
    case Leer() => false
  }
}

enthaelt(4, baum)