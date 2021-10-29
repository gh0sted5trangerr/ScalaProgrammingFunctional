// b = richtig
def NAND(a: Boolean, b: Boolean) : Boolean =
  !(a&&b)

// c = richtig
def NOT(a: Boolean) : Boolean =
  NAND(a, true)

// d = richtig
def AND(a: Boolean, b: Boolean) : Boolean =
  NOT(NAND(a, b))

// e  = richtig
def OR(a: Boolean, b: Boolean) : Boolean =
  NAND(NOT(a), NOT(b))

def NOR(a: Boolean, b: Boolean) : Boolean =
  AND(NOT(a), NOT(b))

// f = richtig
def XOR(a: Boolean, b: Boolean) : Boolean =
  NOT(OR(AND(a, b), NOR(a, b)))

XOR(true, false)