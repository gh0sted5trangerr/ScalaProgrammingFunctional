def ggT(first: BigInt, second: BigInt): BigInt =
  if first == 0 then
    second
  else if second == 0 then
    first
  else if first > second then
    ggT(first % second, second)
  else if first < second then
    ggT(first, second % first)
  else
    -1

ggT(54,78)