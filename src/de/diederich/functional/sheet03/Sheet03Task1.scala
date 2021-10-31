package de.diederich.functional.sheet03

object Sheet03Task1 {

  def main(strgs: Array[String]): Unit =
    c()

  def a() : Unit =
    type Kontakt = (String, List[String], List[String])
    type KontaktListe = (List[Kontakt])

    val liste : KontaktListe = (List(("Günter Schulz", List("günterschulz@gmail.com"), List("016748634"))
    ,("Max Mustermann", List("maxmustermann@outlook.com"), List("014747143"))))

  def b() : Unit = {
    type Kontakt = (String, List[String], List[String])
    type KontaktListe = (List[Kontakt])

    val liste : KontaktListe = (List(("Günter Schulz", List("günterschulz@gmail.com", "günterschulz3@gmail.com", "günter.schulz@gmail.com"), List("016748634"))
      ,("Max Mustermann", List("maxmustermann@outlook.com", "maxmusterman4n@outlook.com"), List("014747143"))))

    def returnEmailList(neueListe: KontaktListe) : String = {
      def returnEmailKontakts(list : List[Kontakt]) : String =  {
        def returnEmailofKontakt(personalList : List[String]) : String = {
          if(personalList.tail == List()) {
            personalList.head
          } else {
            personalList.head+"\n"+returnEmailofKontakt(personalList.tail)
          }
        }
        if(list.tail == List()) {
          returnEmailofKontakt(list.head._2)+"\n"
        } else {
          returnEmailofKontakt(list.head._2)+"\n"+returnEmailKontakts(list.tail)
        }
      }
      returnEmailKontakts(neueListe)
    }
    System.out.print(returnEmailList(liste))
  }

  def c() : Unit = {
    type Kontakt = (String, List[String], List[String])
    type KontaktListe = (List[Kontakt])

    val liste : KontaktListe = (List(("Günter Schulz", List("günterschulz@gmail.com", "günterschulz3@gmail.com", "günter.schulz@gmail.com"), List("016748634"))
      ,("Max Mustermann", List("maxmustermann@outlook.com", "maxmusterman4n@outlook.com"), List("014747143"))))

    def findeKontaktName(gtelefonNummer : String, neueListe: List[Kontakt]) : String = {
      if(neueListe.length == 0 ) "Ein Kontakt mit der angegebenen Telefonnummer konte nicht ermittelt werden."
      def durchsucheListe(gtelefonNummer : String, liste: List[Kontakt]) : String = {
        def durchsucheKontakt(gtelefonNummer : String, name: String, telefonListe : List[String]) : (Boolean, String) = {
          if(telefonListe.length == 0) (false, name)
          else if(telefonListe.head.equals(gtelefonNummer)) (true, name)
          else durchsucheKontakt(gtelefonNummer, name, telefonListe.tail)
        }
        val currentKontakt : (Boolean, String) = durchsucheKontakt(gtelefonNummer, liste.head._1, liste.head._3)
        if(liste.length == 0) "Ein Kontakt mit der angegebenen Telefonnummer konte nicht ermittelt werden."
        else if(currentKontakt._1) currentKontakt._2
        else durchsucheListe(gtelefonNummer, liste.tail)
      }
      durchsucheListe(gtelefonNummer, neueListe)
    }
    System.out.print(findeKontaktName("014747143",liste))
  }

}
