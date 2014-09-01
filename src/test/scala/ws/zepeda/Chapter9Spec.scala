package ws.zepeda

import java.io._

import org.scalatest.{FreeSpec, Matchers}
import ws.zepeda.Chapter9._

import scala.io.Source

class Chapter9Spec extends FreeSpec with Matchers {
  "Chapter9" - {

    trait File4Chap9Num1 {
      val filename = "/tmp/file4Chap9num1.txt"
      val out = new PrintWriter(filename)
      out.println("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam feugiat ligula vitae lacinia accumsan.")
      out.println("Etiam at mauris non tortor lobortis pretium at sagittis erat. Proin pulvinar sapien ullamcorper tempor aliquam.")
      out.println("Curabitur id dignissim odio, ac tempor elit. Aliquam tincidunt erat quis sapien ullamcorper condimentum.")
      out.println("  Donec eros justo, molestie non posuere sit amet, faucibus non dui. Curabitur eleifend et felis id mollis.")
      out.println("Fusce sit amet ipsum vitae eros imperdiet aliquet. Etiam accumsan diam sit amet eros sodales sollicitudin")
      out.close()
    }

    "#1 - Write a Scala code snippet that reverses the lines in a file" in {
      //  (making the last line the first one, and so on)

      new File4Chap9Num1 {

        val r = new Reverser(filename)

        r.write()

        val source = Source.fromFile(filename, "UTF-8")
        val reversedLines = source.getLines.toArray
        source.close

        reversedLines.head should startWith("Fusce sit amet")
      }
    }

    trait File4Chap9Num2 {
      val filename = "/tmp/file4chap9num2.txt"
      val out = new PrintWriter(filename)
      out.println("abc\tcde\t\tefg")
      out.close()

    }

    "#2 - Write a Scala program that reads a file with tabs, replaces each tab with spaces so that" in {
      // tab stops are at n-column boundaries, and writes the result to the same file.

      new File4Chap9Num2 {

        val t = new TabReplacer(filename)
        t.write()

        val source = Source.fromFile(filename, "UTF-8")
        val lines = source.getLines.toArray
        source.close

        lines.head should equal("abc cde  efg")
      }
    }

    trait File4Chap9Num3 {
      val filename = "/tmp/file4chap9number3.txt"
      val out = new PrintWriter(filename)
      out.println("counterrevolutionaries and SUBDERMATOGLYPHIC")
      out.close()
    }


    "#3 - Write a Scala code snippet that reads a file and prints all words with more than 12 characters" in {
      //  to the console. Extra credit if you can do this in a single line.
      new File4Chap9Num3 {

        val w = new WordSizeCounter(filename)
        w.words should be(Array("counterrevolutionaries", "SUBDERMATOGLYPHIC"))
        w.write()
      }
    }

    trait File4Number4 {
      val filename = "/tmp/file4number4.txt"
      val out = new PrintWriter(filename)
      out.println("1.0 10.1 55.6 12.1 99.5 104.5")
      out.close()
    }

    "#4 - Write a Scala program that reads a text file containing only floating-point numbers" in {
      // Print the sum, average, maximum, and minimum of the numbers in the file.
      new File4Number4 {
        val c = new Calculator(filename)

        c.sum should equal(282.8)
        c.average should equal(47.13333333333333)
        c.maximum should equal(104.5)
        c.minimum should equal(1.0)
        c.write()
      }
    }

    "#5- Write a Scala program that writes the powers of 2 and their reciprocals to a file, with the exponent" in {
      // ranging from 0 to 20. Line up the columns.

      val filename = "/tmp/exponents_and_reciprocals.txt"
      ExponentAndReciprocals.write(filename)

      val source = Source.fromFile(filename, "UTF-8")
      val lines = source.getLines.toArray
      source.close()

      lines(0) should equal("      2 0.500000")
      lines(19) should equal("1048576 0.000001")

    }

    trait File4Chap9Num6 {
      val filename = "/tmp/file4chap9num6.txt"
      val out = new PrintWriter(filename, "UTF-8")
      out.println("unquoted string")
      out.println( """"quoted string\""""")
      out.println("last unquoted string")
      out.close()
    }

    "#6 - Make a regular expression searching for quoted strings" in {
      //  "like this , maybe with \" or \\" in a source file.

      new File4Chap9Num6 {
        val q = new QuotedStringSearcher(filename)

        q.quotedStrings.mkString should equal( """"quoted string\""""")
        q.write()
      }
    }

    trait File4Chap9Num7 {
      val filename = "/tmp/file4chap9num7.txt"
      val out = new PrintWriter(filename)
      out.println("We are 2.5 not 1.0 floating 5.1 point numbers")
      out.close()
    }

    "#7 - Write a Scala program that reads a text file and prints all tokens in the file that are not" in {
      // floating-point numbers. Use a regular expression.
      new File4Chap9Num7 {

        val n = new NotFloatingPoint(filename)

        n.search.mkString(" ") should equal ("We are not floating point numbers")
        n.write()
      }
    }

    "#8 - Write a Scala program that prints the src attributes of all img tags of a web page" in {
      //  Use regular expressions and groups.

      val url = "http://google.com"
      val s = new SourceExtractor(url)

      s.extract should equal("/intl/en_ALL/images/srpr/logo9w.png")
      s.write()
    }

    "#9 - Write a Scala program that counts how many files with .class extension are in a given directory" in {
      //  and its subdirectories

      val dirName = "/Users/dzepeda/Projects/sfti/target/scala-2.10/test-classes/ws/zepeda"
      val c = new ClassFileCounter(dirName)
      c.count should be >(1)
    }

    "#10 - Expand the example with the serializable Person class that stores a collection of friends" in {
      // Construct a few Person objects, make some of them friends of another, and then save an
      // Array[ Person] to a file. Read the array back in and verify that the friend relations are intact

      val butch = new Person("Butch", Array.empty)
      val bubba = new Person("Bubba", Array(butch))
      val tony = new Person("Tony", Array(butch, bubba))

      val people = Array(butch, bubba, tony)

      val filename = "/tmp/file4Chap9Num10.obj"
      val out = new ObjectOutputStream( new FileOutputStream(filename))
      out.writeObject( people)
      out.close()

      val in = new ObjectInputStream( new FileInputStream(filename))
      val savedPeople= in.readObject(). asInstanceOf[ Array[Person]]

      savedPeople(0).friends should be (Array())
      savedPeople(1).friends.map(_.name) should be (Array("Butch"))
      savedPeople(2).friends.map(_.name) should be (Array("Butch", "Bubba"))
    }
  }
}















