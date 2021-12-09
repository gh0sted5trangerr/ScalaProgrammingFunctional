def fakultaet(i: Int) : Int = {
  if (i > 1) {
    var m = i: Int; // Fakultätswert
    var c = i: Int; // Counter zu 0
    while (0 < c) {
      c = c - 1
      if(c > 0) {
        m = m * c
      }
    }
    m
  }
  else {
    i
  }
}

fakultaet(3)