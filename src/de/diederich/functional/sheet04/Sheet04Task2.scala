package de.diederich.functional.sheet04

object Sheet04Task2 {

  def main(args: Array[String]) : Unit = {
    guessNumberGamePC()
  }

  //task 2 a
  def guessNumberGamePC(): Unit = {
    def guessNumber(holyNumber: Int, minRange: Int, maxRange: Int) : Int = {
      val m = minRange+(maxRange-minRange)/2
      if(m <= 2) m
      else if(holyNumber == m) m
      else if(holyNumber < m) guessNumber(holyNumber, minRange, m)
      else if(holyNumber > m) guessNumber(holyNumber, m, maxRange)
      else -1
    }
    System.out.println("Wilkommen beim Zahlen raten-Spiel")
    System.out.println("Bitte gebe eine Zahl zwischen 0 und 100 ein:")
    val holyNumber = scala.io.StdIn.readInt()
    System.out.println("berechne...")
    System.out.println(guessNumber(holyNumber, 0, 100))

  }

  //task 2 b
  def guessNumberGame() : Unit = {
    System.out.println("Wilkommen beim Zahlen raten-Spiel")
    def firstInput() : Unit = {
      def rateNumber(holyNumber: Int, minRange: Int, maxRange: Int) : Boolean = {
        def tippAbgabe(minRange: Int, maxRange: Int) : Int = {
          System.out.println("Geben Sie ein Tipp ab zwischen "+minRange+" und "+ maxRange+":")
          val guess = scala.io.StdIn.readInt()
          if(!(holyNumber <= maxRange && minRange <= holyNumber)) {
            System.out.println("Wer lesen kann ist klar im vorteil...")
            tippAbgabe(minRange, maxRange)
          }
          else guess
        }
        if(minRange == maxRange) false
        else {
          val guess = tippAbgabe(minRange, maxRange)
          if(holyNumber == guess) true
          else if(holyNumber < guess) rateNumber(holyNumber, minRange, guess-1)
          else if(holyNumber > guess) rateNumber(holyNumber, guess+1, maxRange)
          else false
        }
      }
      val holyNumber = scala.util.Random.nextInt(100+1)
      if(!(holyNumber <= 100 && 0 <= holyNumber)) guessNumberGame()
      else {
        if(rateNumber(holyNumber, 0, 100)) {
          System.out.println("Herzlichen Glückwunsch du hast gewonnen!")
        } else {
          System.out.println("Looser, spiel das Spiel am besten nicht mehr...")
        }
      }
    }
    firstInput()
  }

}
