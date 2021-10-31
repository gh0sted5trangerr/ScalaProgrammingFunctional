//b = richtig
def pred(x: Int) : Int = x-1

def succ(x: Int) : Int = x+1

def isZero(x: Int) : Boolean = x == 0

def add(a: Int, b: Int) : Int =
    if (isZero(a)) b
    else add(pred(a), succ(b))

//c = richtig
def mul(a: Int, b:Int) : Int =
    if (isZero(a)) 0
    else add(b, mul(pred(a), b))

//d = richtig
def sumFromTo(a: Int, b: Int) : Int =
    if (a > b) 0
    else
        a + sumFromTo(succ(a),b)

//e = richtig
def newton(x: Float, fx1: Float) : Float =
        if fx1 == 0.0 then 1.0
        else
          val fxi1 = (fx1+(x/fx1))/2
          if fx1 == fxi1 then fx1
          else newton(x, fxi1)


def root(x: Float) : Float =
        if x==0 then 0
        else newton(x, 1)

root(2)