package ws.zepeda

import org.scalatest.FreeSpec
import org.scalatest.matchers.ShouldMatchers

class Chapter3Spec extends FreeSpec with ShouldMatchers {
  "Chapter3" - {
    "#1 - Write a code snippet that sets a to an array of n random integers" in {
      import scala.util.Random
      val generator = new Random
      val n = 10

      val a = new Array[Int](10)
      for (i <- 0 until n) a(i) = generator.nextInt(n)
      a.foreach(println(_))
      a.length should be(10)
    }

    "#2 - Write a loop that swaps adjacent elements of an array of integers" in {
      val a = Array(1, 2, 3, 4, 5)

      var b = 0
      for (i <- 0 until a.length - 1 by 2) {
        b = a(i)
        a(i) = a(i + 1)
        a(i + 1) = b
      }
      a should be(Array(2, 1, 4, 3, 5))
    }

    "#3 - Repeat the preceding assignment, but produce a new array with the swapped values. Use for/ yield" in {
      val a = Array(1, 2, 3, 4, 5)
      val b = (for {
        c <- a.grouped(2)
        d <- c.reverse
      } yield d).toArray

      b should be(Array(2, 1, 4, 3, 5))
    }

    "#4 - Given an array of integers, produce a new array that contains all positive values of the original array" in {
      // in their original order, followed by all values that are zero or negative, in their original order
      val a = Array(-1, -9, -3, 0, 5, 3, 1)
      a.filter(_ > 0) ++ a.filter(_ <= 0) should be(Array(5, 3, 1, -1, -9, -3, 0))
    }

    "#5 - How do you compute the average of an Array[Double]?" in {
      val a = Array(1.0, 2.0)
      a.sum / a.length should be(1.5)
    }

    "#6 - How do you rearrange the elements of an Array[ Int] so that they appear in reverse sorted order?" in {
      // How do you do the same with an ArrayBuffer[Int]?
      import scala.collection.mutable.ArrayBuffer
      val a = ArrayBuffer(1, 2, 3)
      val b = Array(1, 2, 3)
      a.reverse should be(ArrayBuffer(3, 2, 1))
      b.reverse should be(Array(3, 2, 1))
    }

    "#7 - Write a code snippet that produces all values from an array with duplicates removed" in {
      Array(1, 1, 2, 2, 3, 3).distinct should be(Array(1, 2, 3))
    }

    "#8 - Rewrite the example at the end of Section 3.4 , “ Transforming Arrays ,” on page 32 ." in {
      // Collect indexes of the negative elements, reverse the sequence, drop the last index,
      // and call a.remove( i) for each index.
      import scala.collection.mutable.ArrayBuffer
      val a = ArrayBuffer(-1, -9, -3, 0, 5, 3, 1)

      val negIndices = (for (i <- a.indices; if a(i) < 0) yield i).reverse.dropRight(1)
      negIndices.foreach(i => a.remove(i))
      a should be(ArrayBuffer(-1, 0, 5, 3, 1))
    }

    "#9 - Make a collection of all time zones returned by java.util.TimeZone.getAvailableIDs that are in America ." in {
      // Strip off the \"America/\" prefix and sort the result.
      val tzs = java.util.TimeZone.getAvailableIDs.filter(p => p.matches("America.*")).map(p => p.replace("America/", "")).sorted
      tzs.head should be ("Adak")
      tzs.last should be ("Yellowknife")
    }

    "#10 - Import java.awt.datatransfer._ and make an object of type SystemFlavorMap with the call" in {
      // val flavors = SystemFlavorMap.getDefaultFlavorMap(). asInstanceOf[ SystemFlavorMap]
      // Then call the getNativesForFlavor method with parameter DataFlavor.imageFlavor and
      // get the return value as a Scala buffer.
      import scala.collection.JavaConversions.asScalaBuffer
      import scala.collection.mutable.Buffer
      import java.awt.datatransfer._
      val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[ SystemFlavorMap]
      val flavor: Buffer[String] = flavors.getNativesForFlavor(DataFlavor.imageFlavor)
      flavor should be (Buffer("TIFF"))
    }
  }
}
