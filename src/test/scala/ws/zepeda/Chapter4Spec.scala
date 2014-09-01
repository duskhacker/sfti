package ws.zepeda

import org.scalatest.{Matchers, FreeSpec}
import scala.io.Source
import ws.zepeda.Chapter4._
import scala.collection.immutable.SortedMap

class Chapter4Spec extends FreeSpec with Matchers {
  "Chapter4" - {
    "#1 - Set up a map of prices for a number of gizmos that you covet. Then produce a second map with" in {
      // the same keys and the prices at a 10 percent discount
      val gizmos = Map("AR15" -> 4000.00, "10/22" -> 400.00, "G19" -> 650.00)
      val discountedGizmos = for ((gizmo, price) <- gizmos) yield (gizmo, (price - (price * 0.1)))
      discountedGizmos should be(Map("AR15" -> 3600.0, "10/22" -> 360.0, "G19" -> 585.0))
    }

    trait WordTokens {
      val source = Source.fromFile("myfile.txt", "UTF-8")
      val tokens = source.mkString.split("\\W+")
    }

    "#2 - Write a program that reads words from a file. Use a mutable map to count how often each word appears ." in {
      // To read the words, simply use a java.util.Scanner:
      // val in = new java.util.Scanner( new java.io.File(" myfile.txt")) while (in.hasNext()) process in.next()
      // Or look at Chapter 9 for a Scalaesque way. At the end, print out all words and their counts


      new WordTokens {
        val counts = new scala.collection.mutable.HashMap[String, Int]
        tokens foreach {
          token =>
            counts.getOrElseUpdate(token, 0)
            counts(token) += 1
        }

        counts("justo") should be(1)
        counts("amet") should be(4)
        counts("sapien") should be(2)
      }
    }

    "#3 - Repeat the preceding exercise with an immutable map." in {
      new WordTokens {
        val counts = countWords(tokens, Map())

        counts("justo") should be(1)
        counts("amet") should be(4)
        counts("sapien") should be(2)
      }
    }

    "#4 - Repeat the preceding exercise with a sorted map, so that the words are printed in sorted order." in {
      new WordTokens {
        val counts = countWords(tokens, SortedMap())

        counts.head should be("Aliquam" -> 1)
        counts.last should be("vitae" -> 2)
      }
    }

    "#5 - Repeat the preceding exercise with a java.util.TreeMap that you adapt to the Scala API" in {
      new WordTokens {

        import scala.collection.JavaConversions.mapAsScalaMap

        val counts: scala.collection.mutable.Map[String, Int] = new java.util.TreeMap[String, Int]
        tokens foreach {
          token =>
            counts.getOrElseUpdate(token, 0)
            counts(token) += 1
        }

        counts("justo") should be(1)
        counts("amet") should be(4)
        counts("sapien") should be(2)
      }
    }

    "#6 - Define a linked hash map that maps \"Monday\" to java.util.Calendar.MONDAY, and similarly" in {
      // for the other weekdays. Demonstrate that the elements are visited in insertion order
      val weekdays = scala.collection.mutable.LinkedHashMap(
        "Monday" -> java.util.Calendar.MONDAY,
        "Tuesday" -> java.util.Calendar.TUESDAY,
        "Wednesday" -> java.util.Calendar.WEDNESDAY,
        "Thursday" -> java.util.Calendar.THURSDAY,
        "Friday" -> java.util.Calendar.FRIDAY,
        "Saturday" -> java.util.Calendar.SATURDAY,
        "Sunday" -> java.util.Calendar.SUNDAY
      )

      val i = weekdays.iterator
      i.next should be("Monday" -> java.util.Calendar.MONDAY)
      i.next should be("Tuesday" -> java.util.Calendar.TUESDAY)
      i.next should be("Wednesday" -> java.util.Calendar.WEDNESDAY)
      i.next should be("Thursday" -> java.util.Calendar.THURSDAY)
      i.next should be("Friday" -> java.util.Calendar.FRIDAY)
      i.next should be("Saturday" -> java.util.Calendar.SATURDAY)
      i.next should be("Sunday" -> java.util.Calendar.SUNDAY)
    }

    "#7 - Print a table of all Java properties" in {
      import scala.collection.JavaConversions.propertiesAsScalaMap
      val props: scala.collection.Map[String, String] = System.getProperties()
      val pad = props.keySet.map(_.size).max
      for ((k, v) <- props) {
        if (v.size < 50)
          println("%s%s | %s".format(k, " " * (pad - k.size), v))
      }
    }

    "#8 - Write a function minmax( values: Array[ Int]) that returns a pair containing" in {
      // the smallest and largest values in the array

      val a = Array(1,2,3,59, 0)
      minmax(a) should be (0,59)

    }

    "#9 - Write a function lteqgt( values: Array[ Int], v: Int) that returns a triple containing the counts" in {
      //  of values less than v, equal to v, and greater than v

      val a = Array(1,2,5,7,9,11)
      val (lessThan, equalTo, greaterThan) = lteggt(a, 5)

      lessThan should be (2)
      equalTo should be (1)
      greaterThan should be (3)
    }

    "#10 - What happens when you zip together two strings, such as \"Hello\". zip(\"World\")?" in {
      // Come up with a plausible use case

      val zippedWords = "Hello".zip("World")
      for ((first, second) <- zippedWords) {
        println("%s %s".format(first, second))
      }
    }
  }
}
