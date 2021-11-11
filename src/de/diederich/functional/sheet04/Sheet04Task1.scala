package de.diederich.functional.sheet04

object Sheet04Task1 {

  def main(args: Array[String]) : Unit = {
    println(union(List(1,5,17), List(3,5,18)))
  }

  def union(a: List[Int], b: List[Int]) : List[Int] = {
    def pUnion(source: List[Int], garbage: List[Int], value: Int) : List[Int] = {
      if(source.isEmpty) garbage:::List(value)
      else {
        if(source.head == value) source:::garbage
        else if(source.head < value) pUnion(source.tail, source.head::garbage, value)
        else if(source.head > value) garbage:::List(value):::source
        else List()
      }
    }
    if(b == List()) a
    else union(pUnion(a, List(), b.head), b.tail)
  }

}
