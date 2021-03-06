package de.diederich.functional.sheet02

/**
 * The object handles the third task
 */
object Sheet02Task3 {

  def main(strgs: Array[String]): Unit =
    System.out.println(istGerade(3))

  def istGerade(x: Int) : Boolean =
    if(x == 0) then true
    else
      istUngerade(x-1)

  def istUngerade(x: Int) : Boolean =
    if(x == 0) then false
    else
      istGerade(x-1)

}
