package com.gome.bigData.demo.clazz

package object Math {
  val PI = 3.141592653
  val THETA = 2.0
  val SIGMA = 1.9
}

class Coputation{
  def computeArea(r : Double)= Math.PI*r*r
}

object PackageObjectDemo {

  def main(args: Array[String]): Unit = {
    val coputation = new Coputation()
    println(coputation.computeArea(2))
  }
}
