val x = List(1, 2, 3, 4, 5, 6) match {
  case List(x, 2, 4, _) => 1
  case Nil => 2
  case List(x, y, 3, z, 5, _) => 3
  case _ => 42
}

val y = List(1, 2, 3, 4) match {
  case List(_) => 1
  case 1::2::3::4::List() => 2
  case List(_, _, _, _) => 3
  case _ => 42
}
