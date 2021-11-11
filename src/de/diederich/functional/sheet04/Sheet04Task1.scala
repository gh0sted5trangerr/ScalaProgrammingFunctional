package de.diederich.functional.sheet04

object Sheet04Task1 {

  def main(args: Array[String]) : Unit = {
    println(intersect3(List(1,5,17,27), List(3,5,17,18,27), List(1,5,18,19,27,33)))
  }

  // task 1 a
  def union(a: List[Int], b: List[Int]) : List[Int] = {
    def pUnion(source: List[Int], garbage: List[Int], value: Int) : List[Int] = {
      if(source.isEmpty) garbage:::List(value)
      else {
        if(source.head == value) garbage:::source
        else if(source.head < value) pUnion(source.tail, garbage:::List(source.head), value)
        else if(source.head > value) garbage:::List(value):::source
        else List()
      }
    }
    if(b == List()) a
    else union(pUnion(a, List(), b.head), b.tail)
  }

  //task 1 b
  def intersect(a: List[Int], b:List[Int]) : List[Int] = {
    def pIntersect(a: List[Int], b:List[Int], holyList: List[Int]) : List[Int] = {
      if(a.isEmpty || b.isEmpty) List()
      else {
        if(a.head == b.head) a.head::pIntersect(a.tail, b.tail, holyList)
        else if(a.head < b.head) pIntersect(a.tail, b, holyList)
        else if(a.head > b.head) pIntersect(a, b.tail, holyList)
        else List()
      }
    }
    pIntersect(a, b, List())
  }

  //task 1 c
  def intersect32(a: List[Int], b:List[Int], c:List[Int]) : List[Int] = {
    intersect(intersect(a,b), intersect(b,c))
  }

  def intersect3(a: List[Int], b:List[Int], c:List[Int]) : List[Int] = {
    def pIntersect(a: List[Int], b:List[Int], c:List[Int], holyList: List[Int]) : List[Int] = {
      def isEqual(aInt: Int, bInt: Int, cInt: Int) : Boolean = {
        aInt == bInt && bInt == cInt && aInt == cInt
      }
      if(a.isEmpty || b.isEmpty || c.isEmpty) List()
      else {
        if(isEqual(a.head, b.head, c.head)) a.head::pIntersect(a.tail, b.tail, c.tail, holyList)
        else if(a.head <= b.head && a.head <= c.head) pIntersect(a.tail, b, c, holyList)
        else if(b.head <= a.head && b.head <= c.head) pIntersect(a, b.tail, c, holyList)
        else if(c.head <= a.head && c.head <= b.head) pIntersect(a, b, c.tail, holyList)
        else List()
      }
    }
    pIntersect(a, b, c, List())
  }

}
