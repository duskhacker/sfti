package ws.zepeda

import org.scalatest.{FreeSpec, Matchers}

class Chapter7Spec extends FreeSpec with Matchers {
  "Chapter7" - {
    "#1 - Write an example program to demonstrate that" ignore {
      // package com.horstmann.impatient
      // is not the same as
      // package com
      // package horstmann
      // package impatient

      // Answer commented out because it won't compile.

    }

    "#2 - Write a puzzler that baffles your Scala friends, using a package com that isn’t at the top level" in {
      com.Foo.bar should be(())
    }

    "#3 - Write a package random with functions nextInt(): Int, nextDouble(): Double," in {
      // and setSeed( seed: Int): Unit. To generate random numbers, use the linear congruential generator
      // next = previous × a + b mod 2^n, where a = 1664525, b = 10139042231013904223, and n = 32.
      ws.zepeda.random.setSeed(55)

      ws.zepeda.random.nextInt should be(3)
      ws.zepeda.random.nextInt should be(9)
      ws.zepeda.random.nextInt should be(9)

      ws.zepeda.random.setSeed(55)

      ws.zepeda.random.nextDouble should be(3.015278592E9)
      ws.zepeda.random.nextDouble should be(9.34285312E8)
      ws.zepeda.random.nextDouble should be(9.49313536E8)
    }

    "#4 - Why do you think the Scala language designers provided the package object syntax instead of simply" ignore {
      //  letting you add functions and variables to a package?

      // Because the JVM doesn't allow that.
    }

    "#5 - 5. What is the meaning of private[ com] def giveRaise( rate: Double)? Is it useful?" ignore {
      // It makes giveRaise visible to the enclosing 'com' package.
      // I could see it being useful for getting around some visibility problem in code you cannot modify
    }

    "#6 - Write a program that copies all elements from a Java hash map into a Scala hash map. Use imports to" in {
      // rename both classes

      val javaHashMap = new java.util.HashMap[String, Double]
      javaHashMap.put("Zara", 3434.34)
      javaHashMap.put("Qadir", -19.08);

      val scalaHashMap = ws.zepeda.Chapter7Number6.copyHashMap(javaHashMap)
      scalaHashMap.isInstanceOf[scala.collection.mutable.HashMap[String, Double]] should be(true)
      scalaHashMap("Zara") should be(3434.34)
      scalaHashMap("Qadir") should be(-19.08)
    }

    "#8 -  What is the effect of import java._ import javax._ Is this a good idea?" in {; // It works. The effect is pulling in all of java + java "extensions."

      // Not being a java programmer, I really don't know, nor do I care to find out
      // 'cause it's probably peripheral to learning Scala.
    }

    "#9 - Write a program that imports the java.lang.System class, reads the user name from the user.name system" ignore {
      // property, reads a password from the Console object, and prints a message to the standard error stream
      // if the password is not \"secret\". Otherwise, print a greeting to the standard output stream.
      // Do not use any other imports, and do not use any qualified names (with dots)."
    }
  }
}
