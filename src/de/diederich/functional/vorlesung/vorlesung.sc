def fakultaet(n: Int) : Int =
  if n == 0 then 1
  else n * fakultaet(n-1)


def sum(n: Int) : Int =
  if n == 0 then 0
  else
    n + sum(n-1)

sum(9)