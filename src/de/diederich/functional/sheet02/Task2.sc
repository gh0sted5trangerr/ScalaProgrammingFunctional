// a  = richtig
def sumN(n: Int) : Int =
  if(n < 1) then 0
  else n*(n+1)/2

// b  = richtig
def sumFromTo(a: Int, b: Int) : Int =
    if (b < a) 0
    else
        sumN(b)- sumN(a-1)

// c = richtig
def sumOddN(n: Int) : Int =
  if(n < 0 ) then 1
  else 2*sumN(n)-n

sumN(5)
sumOddN(3)