package ws.zepeda

import scala.io.Source
import java.io.PrintWriter

object Chapter9 {

  class Reverser(filename: String) {
    val source = Source.fromFile(filename, "UTF-8")
    val lines = source.getLines.toArray
    source.close()

    def write() {
      val writer = new java.io.PrintWriter(filename)
      writer.println(lines.reverse.mkString("\n"))
      writer.close()
    }
  }

  class TabReplacer(filename: String) {
    val source = Source.fromFile(filename, "UTF-8")
    val lines = source.getLines.toArray
    source.close()

    def write() {
      val writer = new java.io.PrintWriter(filename)
      writer.println(replace.mkString("\n"))
      writer.close()
    }

    def replace = {
      val matcher = """\t""".r
      lines.map(matcher.replaceAllIn(_, " "))
    }
  }

  class WordSizeCounter(filename: String) {
    val source = Source.fromFile(filename, "UTF-8")
    val tokens = source.mkString.split("\\s+")
    source.close()

    def words = tokens.filter(_.size > 12)

    def write() {
      println(words.mkString(" "))
    }
  }

  class Calculator(filename: String) {
    val source = Source.fromFile(filename, "UTF-8")
    val values = source.mkString.split("\\s+").map(_.toDouble)
    source.close()

    def sum = values.sum

    def average = values.sum / values.size

    def maximum = values.max

    def minimum = values.min

    def write() {
      println("Sum: %f, Average: %f, Maximum: %f, Minimum: %f".format(sum, average, maximum, minimum))
    }
  }

  object ExponentAndReciprocals {
    def write(filename: String) {
      val out = new PrintWriter(filename)
      for (i <- 1 to 20) {
        out.println("%7d %f".format(Math.pow(2, i).toInt, Math.pow(2, -i)))
      }
      out.close
    }
  }

  class QuotedStringSearcher(filename: String) {
    val source = Source.fromFile(filename)
    val lines = source.getLines.mkString
    source.close()

    def quotedStrings = {
      val matcher = """".*"""".r
      matcher.findAllIn(lines)
    }

    def write() {
      for (l <- quotedStrings) {
        println(l)
      }
    }
  }

  class NotFloatingPoint(filename: String) {
    val source = Source.fromFile(filename)
    val tokens = source.mkString.split( """\s+""")
    source.close()

    def search = {
      val matcher = """[^\d+\.^d+]""".r
      tokens.filter(matcher.findFirstIn(_).nonEmpty)
    }

    def write() {
      println(search.mkString(" "))
    }
  }

  class SourceExtractor(url: String) {
    val source = Source.fromURL(url)
    val lines = source.getLines.mkString
    source.close()


    def extract = {
      val matcher = """<img.*?src="(.*?)"""".r
      (for (matcher(src) <- matcher.findAllIn(lines)) yield src).mkString
    }

    def write() {
      println(extract)
    }
  }

  class ClassFileCounter(dirName: String) {
    val directory = new java.io.File(dirName)
    val matcher = """.*\.class$""".r
    val filter = new java.io.FilenameFilter {
      def accept(p1: java.io.File, p2: String): Boolean = matcher.findFirstIn(p2).nonEmpty
    }

    def count = directory.listFiles(filter).size
  }

  case class Person(name: String, friends: Array[Person])


}

























