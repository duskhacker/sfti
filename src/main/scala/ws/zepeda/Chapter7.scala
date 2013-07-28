package ws.zepeda

object Chapter7 {

}

object Chapter7Number9 extends App {
  import java.lang.System._

  val username = getProperty("user.name")
  val password = Console.readLine("Enter password: ")
  if (password == "secret")
    println("By your command " + username)
  else
    err.println("Exterminate!")
}

object Chapter7Number6 extends App {

  import java.util.{HashMap => JavaHashMap}
  import scala.collection.mutable.{HashMap => ScalaHashMap}

  def copyHashMap[K, V](javaHashMap: JavaHashMap[K, V]): ScalaHashMap[K, V] = {
    val map = ScalaHashMap.empty[K, V]
    for (ks <- javaHashMap.keySet().toArray; k = ks.asInstanceOf[K]) {
      map += (k -> javaHashMap.get(k))
    }
    map
  }
}

package object random {
  private var previous: Double = 0

  private def next = {
    previous = (previous * 1664525 + 10139042231013904223D) % (math pow(2, 32))
    previous
  }

  def nextInt: Int = next.toString.split("\\.")(0).toInt // Lame

  def nextDouble: Double = next

  def setSeed(seed: Int) {
    previous = seed
  }
}

package random {}

package com {
  object Foo {
    def bar {
      ()
    }
  }
}

/*
Chapter 7 - #1

package com {
  package horstmann {
    object Foo {
      def bar {
        println("You called com.horstmann.Foo.bar")
      }
    }
  }
}

Won't compile
package com.horstmann.impatient {
  object Foo extends App {
    horstmann.Foo.bar
  }
}
*/