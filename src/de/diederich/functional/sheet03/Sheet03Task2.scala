package de.diederich.functional.sheet03

object Sheet03Task2 {

  def main(strgs: Array[String]): Unit =
    a()

  def a() : Unit = {
    def biKoeff(m: Int, n: Int) : Int = {
      if((m < 0 || n < 0) && m > n) 0
      def fakultaet(n: Int) : Int = {
        if(n <= 0) 1
        else n * fakultaet(n-1)
      }
     fakultaet(m)/(fakultaet(n)*fakultaet(m-n))
    }
    System.out.println(biKoeff(4,2))
  }

  def d() : Unit = {
    def biKoeff(m: Int, n: Int) : Int = {
      if(n == 0 || m==n) 1
      else  biKoeff(m-1,n) + biKoeff(m-1, n-1)
    }
    System.out.println(biKoeff(6,3))
  }

}
