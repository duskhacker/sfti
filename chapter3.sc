import scala.collection.JavaConversions.asScalaBuffer
import scala.collection.mutable.Buffer
import java.awt.datatransfer._
val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[ SystemFlavorMap]
val flavor: Buffer[String] = flavors.getNativesForFlavor(DataFlavor.imageFlavor)







/*
java.util.TimeZone.getAvailableIDs.filter(p => p.matches("America.*")).map(p => p.replace("America/", "")).sorted.foreach(println(_))
*/

/* import scala.collection.mutable.ArrayBuffer
val a = ArrayBuffer(-1, -9, -3, 0, 5, 3, 1)

val negIndices = (for (i <- a.indices; if a(i) < 0) yield i).reverse.dropRight(1)
negIndices.foreach( i => a.remove(i))
a
*/



/*
val a = Array(1,1,2,2,3,3)
a.distinct
*/

/* import scala.collection.mutable.ArrayBuffer
val a = ArrayBuffer(1,2,3)
val b = Array(1,2,3)
a.reverse
b.reverse
*/


/* val a = Array(1.0, 2.0)
a.sum / a.length
*/

/*
val a = Array(-1, -9, -3, 0, 5, 3, 1)
a.filter(_ > 0) ++ a.filter(_ <= 0)
*/


/* val a = Array(1, 2, 3, 4, 5)
var b = 0
for (i <- 0 until a.length - 1 by 2) {
  b = a(i)
  a(i) = a(i + 1)
  a(i + 1) = b
}
a
a.length

val c = (for (i <- 0 until a.length) yield {
  if (i + 1 > a.length - 1)
    a(i)
  else {
    a(i + 1)
    a(i)
  }
}).toArray
*/

/* import scala.util.Random
val generator = new Random
val n = 10

val a = new Array[Int](10)
a.length
for( i <- 0 until n ) a(i) = generator.nextInt(n)
a
*/


/*
• xn = y2 if n is even and positive, where y = xn / 2.
• xn = x·xn – 1 if n is odd and positive.
• x0 = 1.
• xn = 1 / x– n if n is negative.
*/
/*
def xToTheN(x: Int, n: Int) = {
  if (n > 0 && (n%2 ==0))
    (x*n/2)^2
  else if (n > 0 && (n%2==0))
    x * x * n - 1
  else if (n == 0)
    1
  else if (n < 0)
    1 / x - n
  else
    ()
}
xToTheN(2,2)
xToTheN(2,-2)
xToTheN(2,0)
*/

/*
def signum(n: Int): Int = {
  n match {
    case x: Int if x > 0 => 0
    case x: Int if x < 0 => 1
    case x: Int if x == 0 => -1
  }
}
println(signum(10))
println(signum(-10))
println(signum(0))
val sy = {}
var x: Unit = ()
println(s"myX: $x ")
var y: Int = 2
x = y = 1

def countDown(n: Int) {
  for (i <- n to 0 by -1) println(i)
}
countDown(5)
*/
/*
def unicodeProduct(s: String): Long = {
  var tot: Long = 1
  for (c <- s) tot *= c.toLong
  tot
}
unicodeProduct("Hello")
def unicodeProductR(s: String, acc: Long = 1): Long = {
  if (s.isEmpty) acc else unicodeProductR(s.tail, acc * s.head.toLong)
}
unicodeProductR("Hello")
*/

































