package de.diederich.functional.sheet02

/**
 * The object handles the third task
 */
object Sheet02Task3 {

  def main(strgs: Array[String]): Unit =
    System.out.println(root(4))

  def istGerade(x: Int) : Boolean =
    if(x == 0) then true
    else
      istUngerade(x-1)

  def istUngerade(x: Int) : Boolean =
    if(x == 0) then false
    else
      istGerade(x-1)

  def newton(x: Float, fx1: Float) : Float =
    if fx1 == 0.0 then 1.0
    else
      val fxi = newton(x, fx1)
      val fxi1 = (fxi + x/fxi)/2
      if fxi >= fxi1 then fxi
      else newton(x,fx1+1)


  def root(x: Float) : Float =
    if x==0 then 0
    else newton(x, 1)

}
