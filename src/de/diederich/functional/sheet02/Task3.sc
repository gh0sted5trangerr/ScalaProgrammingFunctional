//b
def pred(x: Int) : Int = x-1

def succ(x: Int) : Int = x+1

def isZero(x: Int) : Boolean = x == 0

def add(a: Int, b: Int) : Int =
    if (isZero(a)) b
    else add(pred(a), succ(b))

//c
def mul(a: Int, b:Int) : Int =
    if (isZero(a)) 0
    else b + mul(pred(a), b)

//d
def sumFromTo(a: Int, b: Int) : Int =
    if (a > b) 0
    else
        a + sumFromTo(a+1,b)

//e - ERROR -
def newton(x: Float, fx1: Float) : Float =
        if fx1 == 0.0 then 1.0
        else
                val fxi = newton(x, fx1-1)
                val fxi1 = (fxi + x/fxi)/2
                System.out.print(fxi1)
                if fxi >= fxi1 then fxi
                else newton(x,fx1+1)


def root(x: Float) : Float =
        if x==0 then 0
        else newton(x, 1)


root(4)