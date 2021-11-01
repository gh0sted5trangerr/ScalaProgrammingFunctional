package de.diederich.functional.sheet03

object Sheet03Task5 {
  def main(strgs: Array[String]) : Unit =  {
    c()
  }

  def a() : Unit = {
    def berechneDreieicke(n: Int) : Int  =  {
      def unten(pN: Int) : Int = {
        def hUnten(i : Int) : Int = {
          if(i <= 0) 0
          else (pN+1-2*i)+hUnten(i-1)
        }
        hUnten(n/2)
      }
      if(n == 1) 1
      else {
        val obenNummer = n*(n+1) / 2
        val untenNummer = unten(n)
        berechneDreieicke(n-1)+obenNummer+untenNummer
      }
    }
    System.out.print(berechneDreieicke(5))
  }

  def c() : Unit = {
    def berechneDreieck(n: Int): Int = {
      if(n == 1) 1
      else if(n%2 == 0) berechneDreieck(n-1)+(n+1)+(n-1)
      else berechneDreieck(n-1)+(n+1)+(n-1)
    }
    System.out.print(berechneDreieck(5))
  }

}
