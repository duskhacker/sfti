/**
 * Created with IntelliJ IDEA.
 * User: dzepeda
 * Date: 7/10/13
 * Time: 9:41 AM
 * To change this template use File | Settings | File Templates.
 */
// #10

/*
• xn = y2 if n is even and positive, where y = xn / 2.
• xn = x·xn – 1 if n is odd and positive.
• x0 = 1.
• xn = 1 / x– n if n is negative.
*/
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

println("blah ")
xToTheN(2,2)
xToTheN(2,-2)
xToTheN(2,0)
/*

// #9

def productR(s: String): Long = if (s.isEmpty) 1 else s.head * productR(s.tail)
productR("Hello")


// #8
def product(s: String) = s.foldLeft(1L)(_ * _)

// #7

"Hello".foldLeft(1L)(_ * _)

// #6
var acc: Long = 1
for (c <- "Hello") acc *= c
acc


// #5
def countDown(n: Int) {
  for (i <- n to 0 by -1) println(i)
}
countDown(5)

// #4

for (i <- 10 to 0 by -1) println(i)


// #3
var x = ()
var y = 0
x = y = 1


// #2
"The value of an empty block is %s, it's type is %s".format({}, {}.getClass.getSimpleName)

// # 1

def signum(n: Int): Int = {
  n match {
    case x: Int if x > 0 => 0
    case x: Int if x < 0 => 1
    case x: Int if x == 0 => -1
  }
}
signum(10)
signum(-10)
signum(0)



























*/