type Snake = List[Int]
val snake = List(3, 2, 2, 3, 2, 3, 2, 2, 3, 3, 2, 2, 2, 3, 3, 3, 3)

type Direction = (Int, Int, Int)
type Position = (Int, Int, Int)
type Section List[Position]
type Solution = List[Section]


def inCube(n: Int)(pos: Position) : Boolean = {
  def inRange(current: Int) : Boolean = {
    1 <= n && current <= n
  }
  inRange(pos(0)) && inRange(pos(1)) && inRange(pos(2))
}

def inCube4 = inCube(3)_

val pos1 : Position = (1,2,3)
inCube4(pos1)