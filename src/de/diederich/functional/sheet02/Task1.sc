// b
def NAND(a: Boolean, b: Boolean) : Boolean =
  !(a&&b)

// c
def NOT(a: Boolean) : Boolean =
  NAND(a, a)

// d
def AND(a: Boolean, b: Boolean) : Boolean =
  NOT(NAND(a, b))

// e
def OR(a: Boolean, b: Boolean) : Boolean =
  NAND(NOT(a), NOT(b))

def NOR(a: Boolean, b: Boolean) : Boolean =
  AND(NOT(a), NOT(b))

// f
def XOR(a: Boolean, b: Boolean) : Boolean =
  NOT(OR(AND(a, b), NOR(a, b)))