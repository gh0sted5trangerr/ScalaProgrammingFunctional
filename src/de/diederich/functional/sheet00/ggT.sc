def ggT(first: BigInt, second: BigInt): BigInt =
  if first == 0 then
    return second
  else if second == 0 then
    return first
  else if first > second then
    return ggT(first % second, second)
  else if first < second then
    return ggT(first, second % first)

  return -1

ggT(54,78)