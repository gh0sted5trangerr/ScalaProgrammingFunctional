// a
def sumN(n: Int) : Int =
    n*(n+1)/2

// b
def sumFromTo(a: Int, b: Int) : Int =
    if (b < a) 0
    else
        sumN(b)- sumN(a-1)

// c
def sumOddN(n: Int) : Int =
    2*sumN(n)-n

sumN(5)
sumOddN(3)