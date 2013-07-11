package ws.zepeda

object Chapter2 {

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

  def productR(s: String): Long = if (s.isEmpty) 1 else s.head * productR(s.tail)

  def product(s: String) = s.foldLeft(1L)(_ * _)

  def countDown(n: Int) {
    for (i <- n to 0 by -1) println(i)
  }

  def signum(n: Int): Int = {
    n match {
      case x if x > 0 => 0
      case x if x < 0 => 1
      case x if x == 0 => -1
    }
  }

}