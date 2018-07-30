package willem.weiyu.scala.traitt

trait PrimarySchool {
  def graduatePrimary: Unit = println("graduate from primary school")
}

trait MiddleSchool {
  def graduateMiddle: Unit = println("graduate from middle school")
}

trait HighSchool {
  def graduateHigh: Unit = println("graduate from high school")

  def goToUniversity:Unit
}

object MultiTraitDemo extends PrimarySchool with MiddleSchool with HighSchool {

  def main(args: Array[String]): Unit = {
    graduatePrimary
    graduateMiddle
    graduateHigh
    goToUniversity
  }

  override def goToUniversity: Unit = println("go to University!")
}
