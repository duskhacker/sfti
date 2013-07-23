package ws.zepeda


object CardSuit extends Enumeration {
  type CardSuit = Value
  val clubs = Value("♣")
  val diamonds = Value("♦")
  val hearts = Value("♥")
  val spades = Value("♠")
}

object Chapter6 {

  object ColorCube extends Enumeration {
    type ColorCube = Value

    val white = Value(0xFFFFFF)
    val red = Value(0x0000FF)
    val green = Value(0x00FF00)
    val blue = Value(0xFF0000)
    val cyan =  Value(0xFFFF00)
    val magenta =  Value(0xFF00FF)
    val yellow =  Value(0x00FFFF)
    val black =  Value(0x000000)
  }
  
  import CardSuit._
  def isRed(suit: CardSuit): Boolean = {
    if (suit == diamonds || suit == hearts)
      true
    else
      false
  }


  object Conversions extends UnitConversion {
    def inchesToCenterimeters = ()

    def gallonsToLiters = ()

    def milesToKilometers = ()
  }

  class UnitConversion

  object InchesToCentimeters extends UnitConversion {}

  object GallonsToLiters extends UnitConversion {}

  object MilesToKilometers extends UnitConversion {}

  object Origin extends java.awt.Point {}

  class Point(val x: Int, val y: Int)

  object Point {
    def apply(x: Int, y: Int): Point = {
      new Point(x, y)
    }
  }


}

object ReverseArgs extends App {
  for (arg <- args.reverse)
    println(arg)
}
