def NAND(a: Boolean, b: Boolean) : Boolean =
  !(a&&b)

def NOT(a: Boolean) : Boolean =
  !a

def AND(a: Boolean, b: Boolean) : Boolean =
  a&&b

def OR(a: Boolean, b: Boolean) : Boolean =
  a||b

def NOR(a: Boolean, b: Boolean) : Boolean =
  !OR(a,b)

