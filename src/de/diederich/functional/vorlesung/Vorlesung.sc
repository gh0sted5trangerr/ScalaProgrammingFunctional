import java.lang.String

def fakultaet(n: Int) : Int =
  if n == 0 then 1
  else n * fakultaet(n-1)


def sum(n: Int) : Int =
  if n == 0 then 0
  else
    n + sum(n-1)

//sichbarkeit
def test1(n: Int) =
    def test2(n:Int) =
        System.out.println(n)
    test2(n)

test1(1)
sum(9)