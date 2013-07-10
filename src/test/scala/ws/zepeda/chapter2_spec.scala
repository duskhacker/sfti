package ws.zepeda
package specs

import org.scalatest.FreeSpec
import org.scalatest.matchers.ShouldMatchers
import ws.zepeda.Chapter2._

//import ws.zepeda.Chapter2

class Chapter2Spec extends FreeSpec with ShouldMatchers {
  "Chapter2" - {
    "#1 - write a function that computes the signum" in {
      signum(10) should be(0)
      signum(-10) should be(1)
      signum(0) should be(-1)
    }

    "#2 - What is the value and type of an empty block expression?" in {
      println("The value of an empty block is %s, it's type is %s".format({}, {}.getClass.getSimpleName))
    }

    "#3 - make it so that x = y = 1 is valid in Scala." in {
      var x = ()
      var y = 0
      x = y = 1
      x should be()
      y should be(1)
    }

    "#4 - Write an equivalent java loop to" in {
      // for (int i = 10; i > = 0; i--) System.out.println( i);
      for (i <- 10 to 0 by -1) println(i)
    }

    "#5 - Write a procedure countdown( n: Int) that prints the numbers from n to 0." in {
      countDown(5)
    }

    "#6 - Compute the product of unicode letters in a string" in {
      var acc: Long = 1
      for (c <- "Hello") acc *= c
      acc should be(9415087488L)
    }

    "#7 - Solve the preceding exercise without writing a loop" in {
      "Hello".foldLeft(1L)(_ * _) should be(9415087488L)
    }

    "#8 - Write a function product( s : String) that computes the product, as described in the preceding exercises" in {
      product("Hello") should be(9415087488L)
    }

    "#9 - Make the function of the preceding exercise a recursive function" in {
      productR("Hello") should be(9415087488L)
    }

    "#10 - Write a function that computes xn, where n is an integer" in {
      /*
          • xn = y2 if n is even and positive, where y = xn / 2.
          • xn = x·xn – 1 if n is odd and positive.
          • x0 = 1.
          • xn = 1 / x– n if n is negative.
     */
      xToTheN(2,2) should be (0)
      xToTheN(2,-2) should be (2)
      xToTheN(2,0) should be (1)

    }
  }
}
