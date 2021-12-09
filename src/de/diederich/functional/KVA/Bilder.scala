package de.diederich.functional.KVA

object Bilder {
  def main(args: Array[String]): Unit =
    println("""zeigeBild(smiley) = """ + "\n" + zeigeBild(smiley))
    println("""zeigeBild(spiegeleS(smiley)) = """ + "\n" + zeigeBild(spiegeleS(smiley)))
    println("""zeigeBild(spiegeleH(smiley)) = """ + "\n" + zeigeBild(spiegeleH(smiley)))
    println("""zeigeBild(drehe180(smiley)) = """ + "\n" + zeigeBild(drehe180(smiley)))
    println("""zeigeBild(drehe90(smiley)) = """ + "\n" +  zeigeBild(drehe90(smiley)))
    println("""zeigeBild(drehe270(smiley)) = """ + "\n" + zeigeBild(drehe270(smiley)))
    println("""zeigeBild(ueber(smiley,leer)) = """ + "\n" + zeigeBild(ueber(smiley,leer)))
    println(zeigeBild(ueber(neben(smiley,leer),neben(leer,smiley))))
    println(zeigeBild(invertiereBild(smiley)))
    println(zeigeBild(brett))
    println(zeigeBild(leeresBild(5,7)))
    println(zeigeOptionalesBild(setze(4,3,smiley,'?')))
    println(zeigeBild(skaliereBild(smiley,3)))
    println(zeigeBild(skaliereBild(nimmOptionalesBild(setze(4,3,smiley,'?')),3)))
    println(zeigeBild(skaliereBild(setze(4,3,smiley,'?').getOrElse(List()),3)))
    println(zeigeBild(skaliereBild(nimmOptionalesBild(setze(4,13,smiley,'?')),3))+"!")
    println(zeigeBild(skaliereBild(setze(4,13,smiley,'?').getOrElse(List()),3))+"!")

  /*
  1) Grundlagen
  =============

  Ein (Raster-)Bild wird dargestellt als Listen gleich langer Zeichenketten.
  "Ordentliche" Bilder sind also rechteckig. Das Zeichen '.' steht fuer ein
  leeres Pixel, das Zeichen '#' fuer ein volles.
   */

  type Bild = List[String]

  // Ein Smiley-Bild im Format 9 mal 12 Pixel:
  val smiley:Bild =
    List("#..##...##..",
      ".####...##..",
      ".....##.....",
      ".....##.....",
      ".....##.....",
      ".#........#.",
      "...##...##..",
      "....####...."
    )

  // Ein leeres Bild im gleichen Format:
  val leer:Bild =
    List("............",
      "............",
      "............",
      "............",
      "............",
      "............",
      "............",
      "............"
    )

  // Damit die Bilder nicht so schmalbruestig erscheinen,
  // setzt die applikative Funktion "breit" vor jedes Zeichen
  // einen zusaetzlichen Zwischenraum:
  def breit(s:String):String =
    if s=="" then "" else " " + s.head + breit(s.tail)

  // "breit(bild)" wendet auf jede Zeile des Bilds "breit(zeile)" an:
  def breit(bild:Bild):Bild = bild.map(z => breit(z))

  // Der Aufruf "zeigeBild(bild) verbreitert das Bild und verbindet
  // mit dem Fold-Operator alle Zeilen mit eingestreuten Zeilen-
  // wechseln zu einem Druckstring:

  def zeigeBild(bild:Bild):String =
    breit(bild).foldRight("")((l:String, r:String) => l + "\n" + r)

  /* Der Aufruf
     println("""zeigeBild(smiley) = """ + "\n" + zeigeBild(smiley))
     ergibt:

   zeigeBild(smiley) =
   # . . # # . . . # # . .
   . # # # # . . . # # . .
   . . . . . # # . . . . .
   . . . . . # # . . . . .
   . . . . . # # . . . . .
   . # . . . . . . . . # .
   . . . # # . . . # # . .
   . . . . # # # # . . . .


  2) Transformationen von Bildern
  ===============================

  a) Spiegelungen und Drehungen
  -----------------------------

  Bei der Spiegelung um die senkrechte Achse wird jede Zeile
  fuer sich umgekehrt:

   */

  def reverse(s:String): String =
    if s=="" then "" else reverse(s.tail)+s.head

  def spiegeleS(bild:Bild):Bild = bild.map(z => reverse(z))

  /* Der Aufruf

  println("""zeigeBild(spiegeleS(smiley)) = """ + "\n" + zeigeBild(spiegeleS(smiley)))

  ergibt:

  zeigeBild(spiegeleS(smiley)) =
   . . # # . . . # # . . #
   . . # # . . . # # # # .
   . . . . . # # . . . . .
   . . . . . # # . . . . .
   . . . . . # # . . . . .
   . # . . . . . . . . # .
   . . # # . . . # # . . .
   . . . . # # # # . . . .

   Bei der Spiegelung um die horizontale Achse wird das
   gesamte Bild (Liste von Strings) umgekehrt:

   */

  def spiegeleH(bild:Bild):Bild = bild.reverse

  /* Der Aufruf

  println("""zeigeBild(spiegeleH(smiley)) = """ + "\n" + zeigeBild(spiegeleH(smiley)))

  ergibt:

  zeigeBild(spiegeleH(smiley)) =
   . . . . # # # # . . . .
   . . . # # . . . # # . .
   . # . . . . . . . . # .
   . . . . . # # . . . . .
   . . . . . # # . . . . .
   . . . . . # # . . . . .
   . # # # # . . . # # . .
   # . . # # . . . # # . .

   Eine Drehung um 180 Grad ergibt sich, wenn man das Bild
   sowohl vertikal als auch horizontal spiegelt:

   */

  def drehe180(bild:Bild):Bild = spiegeleH(spiegeleS(bild))

  def drehe180a(bild:Bild):Bild = spiegeleS(spiegeleH(bild))

  /* Beide Aufrufe

  println("""zeigeBild(drehe180(smiley)) = """ + "\n" + zeigeBild(drehe180(smiley)))
  println("""zeigeBild(drehe180(smiley)) = """ + "\n" + zeigeBild(drehe180a(smiley)))

  ergeben jeweils:

  zeigeBild(drehe180(smiley)) =
   . . . . # # # # . . . .
   . . # # . . . # # . . .
   . # . . . . . . . . # .
   . . . . . # # . . . . .
   . . . . . # # . . . . .
   . . . . . # # . . . . .
   . . # # . . . # # # # .
   . . # # . . . # # . . #

   Die erste Zeile eines um 90 Grad gedrehten Bildes ergibt sich, wenn man
   aus den Listenkoepfen einen String bildet und diesen umdreht. Das um
   90 Grad gedrehte Restbild erhaelt man durch rekursiven Aufruf auf den
   Reststrings, wobei leere Restzeilen ein leeres Restbild ergeben. Die
   beiden Teilergebnisse fuegt man zu einem Bild zusammen:

   */

  def drehe90(bild:Bild):Bild = bild match
    case List() => List()  // leeres Bild und leere Restzeilen ...
    case ""::zs => List()  // ergeben ein leeres Restbild
    case _      =>
      reverse(bild.map((z)=>z.head).mkString) :: // erste Ergebniszeile
        drehe90(bild.map((z)=>z.tail))             // Restbild gedreht


  /* Der Aufruf

  println("""zeigeBild(drehe90(smiley)) = """ + "\n" + zeigeBild(drehe90(smiley)))

  ergibt:

  zeigeBild(drehe90(smiley)) =
   . . . . . . . #
   . . # . . . # .
   . . . . . . # .
   . # . . . . # #
   # # . . . . # #
   # . . # # # . .
   # . . # # # . .
   # . . . . . . .
   . # . . . . # #
   . # . . . . # #
   . . # . . . . .
   . . . . . . . .

  Eine Drehung um 270 Grad ergibt sich aus zwei Drehungen:

  */

  def drehe270(bild:Bild):Bild = drehe180(drehe90(bild))

  /* Der Aufruf

  println("""zeigeBild(drehe270(smiley)) = """ + "\n" + zeigeBild(drehe270(smiley)))

  ergibt:

  zeigeBild(drehe270(smiley)) =
   . . . . . . . .
   . . . . . # . .
   # # . . . . # .
   # # . . . . # .
   . . . . . . . #
   . . # # # . . #
   . . # # # . . #
   # # . . . . # #
   # # . . . . # .
   . # . . . . . .
   . # . . . # . .
   # . . . . . . .


  b) Bilder aneinander setzen
  ---------------------------

  Gleich breite Bilder uebereinander setzen ist besonders einfach:

  */

  def ueber(bild1:Bild,bild2:Bild):Bild = bild1:::bild2

  /* Der Aufruf

  println("""zeigeBild(ueber(smiley,leer)) = """ + "\n" + zeigeBild(ueber(smiley,leer)))

  ergibt:

  zeigeBild(ueber(smiley,leer)) =
   # . . # # . . . # # . .
   . # # # # . . . # # . .
   . . . . . # # . . . . .
   . . . . . # # . . . . .
   . . . . . # # . . . . .
   . # . . . . . . . . # .
   . . . # # . . . # # . .
   . . . . # # # # . . . .
   . . . . . . . . . . . .
   . . . . . . . . . . . .
   . . . . . . . . . . . .
   . . . . . . . . . . . .
   . . . . . . . . . . . .
   . . . . . . . . . . . .
   . . . . . . . . . . . .
   . . . . . . . . . . . .

  Um Bilder gleicher Hoehe nebeneinander zu setzen,
  konkateniert man ihre Zeilen rekursiv:

  */

  def neben(bild1:Bild,bild2:Bild):Bild = (bild1,bild2) match
    case (z1::b1r,z2::b2r) => (z1+z2)::neben(b1r,b2r)
    case _                 => List()

  /* Die Auswertung von

  println(zeigeBild(ueber(neben(smiley,leer),neben(leer,smiley))))

  ergibt:

   # . . # # . . . # # . . . . . . . . . . . . . .
   . # # # # . . . # # . . . . . . . . . . . . . .
   . . . . . # # . . . . . . . . . . . . . . . . .
   . . . . . # # . . . . . . . . . . . . . . . . .
   . . . . . # # . . . . . . . . . . . . . . . . .
   . # . . . . . . . . # . . . . . . . . . . . . .
   . . . # # . . . # # . . . . . . . . . . . . . .
   . . . . # # # # . . . . . . . . . . . . . . . .
   . . . . . . . . . . . . # . . # # . . . # # . .
   . . . . . . . . . . . . . # # # # . . . # # . .
   . . . . . . . . . . . . . . . . . # # . . . . .
   . . . . . . . . . . . . . . . . . # # . . . . .
   . . . . . . . . . . . . . . . . . # # . . . . .
   . . . . . . . . . . . . . # . . . . . . . . # .
   . . . . . . . . . . . . . . . # # . . . # # . .
   . . . . . . . . . . . . . . . . # # # # . . . .


  c) Bilder invertieren
  ---------------------

  "Bilder invertieren" bedeutet, ihre leeren und vollen Pixel
  jeweils umzutauschen:

  */

  def invertiere(c:Char):Char = c match
    case '.' => '#'
    case '#' => '.'
    case x   => x


  def invertiereBild(b:Bild):Bild =
    b.map(z => (z.map(c => invertiere(c))))

  /* Die Auswertung von

  println(zeigeBild(invertiereBild(smiley)))

  ergibt:

   . # # . . # # # . . # #
   # . . . . # # # . . # #
   # # # # # . . # # # # #
   # # # # # . . # # # # #
   # # # # # . . # # # # #
   # . # # # # # # # # . #
   # # # . . # # # . . # #
   # # # # . . . . # # # #


  Wir bauen ein Schachbrett mit Felder der Laenge 3:

  */

  val weiss:Bild =
    List("...",
      "...",
      "...")

  val schwarz = invertiereBild(weiss)

  val ws = neben(weiss,schwarz)

  val halb = neben(ws,ws)

  val zeile = neben(halb,halb)

  val zz = ueber(zeile,invertiereBild(zeile))

  val oben = ueber(zz,zz)

  val brett = ueber(oben,oben)

  /* Die Auswertung von

  println(zeigeBild(brett))

  ergibt:

   . . . # # # . . . # # # . . . # # # . . . # # #
   . . . # # # . . . # # # . . . # # # . . . # # #
   . . . # # # . . . # # # . . . # # # . . . # # #
   # # # . . . # # # . . . # # # . . . # # # . . .
   # # # . . . # # # . . . # # # . . . # # # . . .
   # # # . . . # # # . . . # # # . . . # # # . . .
   . . . # # # . . . # # # . . . # # # . . . # # #
   . . . # # # . . . # # # . . . # # # . . . # # #
   . . . # # # . . . # # # . . . # # # . . . # # #
   # # # . . . # # # . . . # # # . . . # # # . . .
   # # # . . . # # # . . . # # # . . . # # # . . .
   # # # . . . # # # . . . # # # . . . # # # . . .
   . . . # # # . . . # # # . . . # # # . . . # # #
   . . . # # # . . . # # # . . . # # # . . . # # #
   . . . # # # . . . # # # . . . # # # . . . # # #
   # # # . . . # # # . . . # # # . . . # # # . . .
   # # # . . . # # # . . . # # # . . . # # # . . .
   # # # . . . # # # . . . # # # . . . # # # . . .
   . . . # # # . . . # # # . . . # # # . . . # # #
   . . . # # # . . . # # # . . . # # # . . . # # #
   . . . # # # . . . # # # . . . # # # . . . # # #
   # # # . . . # # # . . . # # # . . . # # # . . .
   # # # . . . # # # . . . # # # . . . # # # . . .
   # # # . . . # # # . . . # # # . . . # # # . . .


  3) Bilder erzeugen, bearbeiten und skalieren
  ============================================

  a) Leere Bilder erzeugen
  ------------------------

  Ein leeres Bild mit m mal n Pixeln erzeugen:

  */

  def leeresBild(m:Int,n:Int):Bild =
    if m == 0 then List()
    else ("."*n)::leeresBild(m-1,n)

  /* Die Auswertung von

  leeresBild(5,7)

  ergibt:

  List(......., ......., ......., ......., .......)

  und die Auswertung von

  println(zeigeBild(leeresBild(5,7)))

  daher:

   . . . . . . .
   . . . . . . .
   . . . . . . .
   . . . . . . .
   . . . . . . .


  b) Pixel bearbeiten
  -------------------

  Der Aufruf "hole(i,j,bild)" gibt das im bild in
  der Zeile i und der Spalte j befindliche Zeichen
  zur�ck, wobei in Bildern Zeilen und Spalten ab 1
  gez�hlt werden - anders als in Listen, wo stets
  0 der erste Index ist.
  Beschreibt das Indexpaar (i,j) eine Position im
  Bild, dann wird "Some(a)" zur�ckgegeben, liegt es
  au�erhalb des Bildes, dann "None".

  */

  def hole(i:Int,j:Int,b:Bild):Option[Char] =
    if i<1 || i>b.length then None
    else
      val zeile = b.drop(i-1).head
      if j<1 || j>zeile.length then None
      else Some(zeile.drop(j-1).head)


  /* Ein paar Aufrufe und ihre Ergebnisse:

  hole(6,11,smiley) ergibt Some(#)
  hole(6,12,smiley) ergibt Some(.)
  hole(6,13,smiley) ergibt None

  Analog zu "hole(i,j,bild)" setzt "setze(i,j,bild)"
  ein Zeichen an die Position. Wenn das  Indexpaar (i,j)
  eine Position im Bild beschreibt, dann wird "Some(b)"
  zur�ckgegeben, sonst "None".

  */

  def setze(i:Int,j:Int,b:Bild,c:Char):Option[Bild] =
    if i<1 || i>b.length then None
    else
      val vor   = b.take(i-1)
      val zeile = b.drop(i-1).head
      val nach  = b.drop(i)
      if j<1 || j>zeile.length then None
      else Some(vor:::((zeile.take(j-1)+c+zeile.drop(j))::nach))

  // Hilfsfunktion zur Anzeige optionaler Bilder:

  def zeigeOptionalesBild(b:Option[Bild]):String = b match
    case None    => "kein zulässiges Bild!"
    case Some(b) => zeigeBild(b)


  /* Ein Aufruf und sein Ergebnis:

  println(zeigeOptionalesBild(setze(4,3,smiley,'?'))) ergibt

   # . . # # . . . # # . .
   . # # # # . . . # # . .
   . . . . . # # . . . . .
   . . ? . . # # . . . . .
   . . . . . # # . . . . .
   . # . . . . . . . . # .
   . . . # # . . . # # . .
   . . . . # # # # . . . .

  println(zeigeOptionalesBild(setze(4,13,smiley,'?'))) ergibt

  kein zulässiges Bild!


  c) Bilder skalieren
  -------------------

  Wir skalieren Bilder, indem wir jedes Zeichen faktor mal
  horizontal und vertikal wiederholen.

  */

  def skaliereString(s:String,faktor:Int):String =
    s.flatMap(z => z.toString*faktor)

  def skaliereBild(b:Bild,faktor:Int):Bild =
    def repeat(el:String,i:Int):List[String] =
      if i==0 then List()
      else el::repeat(el,i-1)

    b match
      case List() => List()
      case z::zs  => repeat(skaliereString(z,faktor),faktor):::
        skaliereBild(zs,faktor)



  // Wenn man optionale Bilder weiteverarbeiten möchte,
  // ist folgende Hilfsfunktion nützlich:

  def nimmOptionalesBild(b:Option[Bild]):Bild = b match
    case None    => List()
    case Some(b) => b


  /* Der Aufruf

  println(zeigeBild(skaliereBild(smiley,3)))

  ergibt

   # # # . . . . . . # # # # # # . . . . . . . . . # # # # # # . . . . . .
   # # # . . . . . . # # # # # # . . . . . . . . . # # # # # # . . . . . .
   # # # . . . . . . # # # # # # . . . . . . . . . # # # # # # . . . . . .
   . . . # # # # # # # # # # # # . . . . . . . . . # # # # # # . . . . . .
   . . . # # # # # # # # # # # # . . . . . . . . . # # # # # # . . . . . .
   . . . # # # # # # # # # # # # . . . . . . . . . # # # # # # . . . . . .
   . . . . . . . . . . . . . . . # # # # # # . . . . . . . . . . . . . . .
   . . . . . . . . . . . . . . . # # # # # # . . . . . . . . . . . . . . .
   . . . . . . . . . . . . . . . # # # # # # . . . . . . . . . . . . . . .
   . . . . . . . . . . . . . . . # # # # # # . . . . . . . . . . . . . . .
   . . . . . . . . . . . . . . . # # # # # # . . . . . . . . . . . . . . .
   . . . . . . . . . . . . . . . # # # # # # . . . . . . . . . . . . . . .
   . . . . . . . . . . . . . . . # # # # # # . . . . . . . . . . . . . . .
   . . . . . . . . . . . . . . . # # # # # # . . . . . . . . . . . . . . .
   . . . . . . . . . . . . . . . # # # # # # . . . . . . . . . . . . . . .
   . . . # # # . . . . . . . . . . . . . . . . . . . . . . . . # # # . . .
   . . . # # # . . . . . . . . . . . . . . . . . . . . . . . . # # # . . .
   . . . # # # . . . . . . . . . . . . . . . . . . . . . . . . # # # . . .
   . . . . . . . . . # # # # # # . . . . . . . . . # # # # # # . . . . . .
   . . . . . . . . . # # # # # # . . . . . . . . . # # # # # # . . . . . .
   . . . . . . . . . # # # # # # . . . . . . . . . # # # # # # . . . . . .
   . . . . . . . . . . . . # # # # # # # # # # # # . . . . . . . . . . . .
   . . . . . . . . . . . . # # # # # # # # # # # # . . . . . . . . . . . .
   . . . . . . . . . . . . # # # # # # # # # # # # . . . . . . . . . . . .


  Die Aufrufe

  println(zeigeBild(skaliereBild(nimmOptionalesBild(setze(4,3,smiley,'?')),3)))
  println(zeigeBild(skaliereBild(setze(4,3,smiley,'?').getOrElse(List()),3)))

  ergeben jeweils

   # # # . . . . . . # # # # # # . . . . . . . . . # # # # # # . . . . . .
   # # # . . . . . . # # # # # # . . . . . . . . . # # # # # # . . . . . .
   # # # . . . . . . # # # # # # . . . . . . . . . # # # # # # . . . . . .
   . . . # # # # # # # # # # # # . . . . . . . . . # # # # # # . . . . . .
   . . . # # # # # # # # # # # # . . . . . . . . . # # # # # # . . . . . .
   . . . # # # # # # # # # # # # . . . . . . . . . # # # # # # . . . . . .
   . . . . . . . . . . . . . . . # # # # # # . . . . . . . . . . . . . . .
   . . . . . . . . . . . . . . . # # # # # # . . . . . . . . . . . . . . .
   . . . . . . . . . . . . . . . # # # # # # . . . . . . . . . . . . . . .
   . . . . . . ? ? ? . . . . . . # # # # # # . . . . . . . . . . . . . . .
   . . . . . . ? ? ? . . . . . . # # # # # # . . . . . . . . . . . . . . .
   . . . . . . ? ? ? . . . . . . # # # # # # . . . . . . . . . . . . . . .
   . . . . . . . . . . . . . . . # # # # # # . . . . . . . . . . . . . . .
   . . . . . . . . . . . . . . . # # # # # # . . . . . . . . . . . . . . .
   . . . . . . . . . . . . . . . # # # # # # . . . . . . . . . . . . . . .
   . . . # # # . . . . . . . . . . . . . . . . . . . . . . . . # # # . . .
   . . . # # # . . . . . . . . . . . . . . . . . . . . . . . . # # # . . .
   . . . # # # . . . . . . . . . . . . . . . . . . . . . . . . # # # . . .
   . . . . . . . . . # # # # # # . . . . . . . . . # # # # # # . . . . . .
   . . . . . . . . . # # # # # # . . . . . . . . . # # # # # # . . . . . .
   . . . . . . . . . # # # # # # . . . . . . . . . # # # # # # . . . . . .
   . . . . . . . . . . . . # # # # # # # # # # # # . . . . . . . . . . . .
   . . . . . . . . . . . . # # # # # # # # # # # # . . . . . . . . . . . .
   . . . . . . . . . . . . # # # # # # # # # # # # . . . . . . . . . . . .


  Die Aufrufe

  println(zeigeBild(skaliereBild(nimmOptionalesBild(setze(4,13,smiley,'?')),3)))
  println(zeigeBild(skaliereBild(setze(4,13,smiley,'?').getOrElse(List()),3)))

  ergeben jeweils kein (sichtbares) Resultat.

  */

}
