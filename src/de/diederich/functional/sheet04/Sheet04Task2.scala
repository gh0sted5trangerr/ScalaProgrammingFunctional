package de.diederich.functional.sheet04

object Sheet04Task2 {

  def main(args: Array[String]) : Unit = {
    guessNumberGame()
  }

  //task 2 a
  def guessNumberGamePC(): Unit = {
    def guessNumber(number: Int, minRange: Int, maxRange: Int) : Int = {
      val m = minRange+(maxRange-minRange)/2
      if(m == 2) minRange + scala.util.Random.nextInt(2)
      else if(number == m) m
      else if(number < m) guessNumber(number, minRange, m)
      else if(number > m) guessNumber(number, m, maxRange)
      else -1
    }
    System.out.println("Wilkommen beim Zahlen raten-Spiel")
    System.out.println("Bitte gebe eine Zahl zwischen 0 und 100 ein:")
    val holyNumber = scala.io.StdIn.readInt()
    System.out.println("Berechne Nummer...")
    System.out.println(guessNumber(holyNumber, 0, 100))

  }

  //task 2 b
  def guessNumberGame() : Unit = {
    System.out.println("Wilkommen beim Zahlen raten-Spiel")
    def firstInput() : Unit = {
      def rateNumber(number: Int, minRange: Int, maxRange: Int) : Boolean = {
        def tippAbgabe(minRange: Int, maxRange: Int) : Int = {
          System.out.println("Geben Sie ein Tipp ab zwischen "+minRange+" und "+ maxRange+":")
          val guess = scala.io.StdIn.readInt()
          if(!(guess <= maxRange && minRange <= guess)) {
            System.out.println("Wer lesen kann ist klar im Vorteil...")
            tippAbgabe(minRange, maxRange)
          }
          else guess
        }
        if(minRange == maxRange) false
        else {
          val guess = tippAbgabe(minRange, maxRange)
          if(number == guess) true
          else if(number < guess) rateNumber(number, minRange, guess-1)
          else if(number > guess) rateNumber(number, guess+1, maxRange)
          else false
        }
      }
      val holyNumber = scala.util.Random.nextInt(100+1)
      if(!(holyNumber <= 100 && 0 <= holyNumber)) guessNumberGame()
      else {
        if(rateNumber(holyNumber, 0, 100)) {
          System.out.println("Herzlichen Glückwunsch du hast gewonnen!")
        } else {
          System.out.println("Du hast leider verloren...")
        }
      }
    }
    firstInput()
  }

}
