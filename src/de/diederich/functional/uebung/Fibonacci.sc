def fibonacci(n: Int, akt: Int, vor: Int) : Int =
  if n == 0 then vor
  else fibonacci(n-1,akt+vor, akt)

def fib(n: Int) : Int =
  fibonacci(n, 1, 1)

fib(5)