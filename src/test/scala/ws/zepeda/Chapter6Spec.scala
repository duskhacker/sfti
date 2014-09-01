package ws.zepeda

import org.scalatest.{Matchers, FreeSpec}
import ws.zepeda.Chapter6._

class Chapter6Spec extends FreeSpec with Matchers {
  "Chapter6" - {
    "#1 - Write an object Conversions with methods inchesToCentimeters, gallonsToLiters, and milesToKilometers" in {

      Conversions.inchesToCenterimeters should be(())
      Conversions.gallonsToLiters should be(())
      Conversions.milesToKilometers should be(())

    }

    "#2 - Provide a general superclass UnitConversion and define objects InchesToCentimeters, GallonsToLiters" in {
      // and MilesToKilometers that extend it

     InchesToCentimeters.getClass.getSuperclass.getSimpleName should be("UnitConversion")
     GallonsToLiters.getClass.getSuperclass.getSimpleName should be("UnitConversion")
     MilesToKilometers.getClass.getSuperclass.getSimpleName should be("UnitConversion")
    }

    "#3 - Define an Origin object that extends java.awt.Point" in {

      Origin.getClass.getSuperclass.getSimpleName should be("Point")

      // Why is this not actually a good idea?
      // Because it uses setX and getX type method names?

    }

    "#4 - Define a Point class with a companion object so that you can construct Point instances as Point( 3, 4)" in {
      //  without using new

      Point(3,4).isInstanceOf[Point] should be(true)
    }

    "#5 - Write a Scala application, using the App trait, that prints the command-line arguments in reverse order" ignore {
      // separated by spaces. For example, scala Reverse Hello World should print World Hello.

      // use 'sbt "run a b c"' to run this one from the command line.

    }

    "#6 - Write an enumeration describing the four playing card suits so that the toString method returns" in {
      //  ♣, ♦, ♥, or ♠

      CardSuit.clubs.toString should be("♣")
      CardSuit.diamonds.toString should be("♦")
      CardSuit.hearts.toString should be("♥")
      CardSuit.spades.toString should be("♠")
    }

    "#7 - Implement a function that checks whether a card suit value from the preceding exercise is red" in {
      import CardSuit._
      isRed(hearts) should be(true)
      isRed(diamonds) should be(true)
      isRed(clubs) should be(false)
      isRed(spades) should be(false)
    }
  }

  "#8 - Write an enumeration describing the eight corners of the RGB color cube. As IDs, use the color values" in {
    //  (for example, 0xff0000 for Red)

    import ColorCube._

    ColorCube(0xFFFFFF) should be(white)
    ColorCube(0x0000FF) should be(red)
    ColorCube(0x00FF00) should be(green)
    ColorCube(0xFF0000) should be(blue)
    ColorCube(0xFFFF00) should be(cyan)
    ColorCube(0xFF00FF) should be(magenta)
    ColorCube(0x00FFFF) should be(yellow)
    ColorCube(0x000000) should be(black)
  }
}
