//21.10
def fakultaet(n: Int) : Int =
  if n == 0 then 1
  else n * fakultaet(n-1)


def sum(n: Int) : Int =
  if n == 0 then 0
  else
    n + sum(n-1)

//22.10 sichbarkeit
def test1(n: Int) =
    def test2(n:Int) =
        System.out.println(n)
    test2(n)

test1(1)
sum(9)

//29.10

type Tim = (String, String)

val s : Tim = ("Tim", "ist cool").swap

val listeliste = List(List("Tim "), List("mag ", "gerne "), List("Kekse "))

System.out.println(listeliste.head.head+listeliste.head.head)