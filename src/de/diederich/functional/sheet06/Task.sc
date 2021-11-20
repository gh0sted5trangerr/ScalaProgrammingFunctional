//C
//TADA
type Kassenzetteleintrag = (Int, String, Double)
type Kassenzettel = List[Kassenzetteleintrag]
val z1 : Kassenzettel = List ((50,"Benzin",1.37),(2,"Scheibenwischer",5.00),(1,"Autowaesche",10.00),(1,"Kaugummi",0.99))
z1.map
//B
(50 to 55).toList.map(x => x.toString).toList

//a
val list = (61 to 66).map(x => x.toChar).toList

def kg(a: Char) : Int = {
  a.toInt
}

def map[A,B](as: List[A])(f: A => B): List[B] = {
  as match {
    case List() => List()
    case x::xs => f(x):: map(xs)(f)
  }
}

map[Char, Int](list)(kg)