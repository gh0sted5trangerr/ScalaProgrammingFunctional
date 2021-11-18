(1 to 20).map(i => BigInt(i)).reduceLeft(_*_)

(1 to 6).foldLeft(1)(_*_)