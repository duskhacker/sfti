package ws.zepeda

import org.scalatest.FreeSpec
import org.scalatest.matchers.ShouldMatchers
import ws.zepeda.Chapter5._

class Chapter5Spec extends FreeSpec with ShouldMatchers {
  "Chapter5" - {
    "#1 - Improve the Counter class in Section 5.1 , “ Simple Classes and Parameterless Methods" in {
      // Why No Multiple Inheritance?,” on page 49 so that it doesn’t turn negative at Int.MaxValue
      val c = new Counter

      c.increment()
      c.current should be(Int.MaxValue)
    }

    "#2 - Write a class BankAccount with methods deposit and withdraw, and a read-only property balance" in {
      val bc = new BankAccount
      bc.deposit(200.00)
      bc.balance should be(200.00)
      bc.withdraw(50.00)
      bc.balance should be(150.00)
      // bc.balance = 1000000.0 will not compile, trust me
    }

    "#3 - Write a class Time with read-only properties hours and minutes" in {
      //  and a method before( other: Time): Boolean that checks whether
      // this time comes before the other. A Time object should be
      // constructed as new Time( hrs, min), where hrs is in military
      // time format (between 0 and 23)

      val t1 = new Time3(21, 30)
      val t2 = new Time3(19, 00)
      val t3 = new Time3(19, 30)

      t2.before(t1) should be(true)
      t1.before(t2) should be(false)
      t3.before(t2) should be(false)
      t2.before(t3) should be(true)
    }

    "#4 - Reimplement the Time class from the preceding exercise so that the internal" in {
      // representation is the number of minutes since midnight (between 0 and 24 × 60 – 1).
      // Do not change the public interface. That is, client code should be unaffected by your change

      val t1 = new Time4(21, 30)
      val t2 = new Time4(19, 00)
      val t3 = new Time4(19, 30)

      t2.before(t1) should be(true)
      t1.before(t2) should be(false)
      t3.before(t2) should be(false)
      t2.before(t3) should be(true)
    }

    "#5 - Make a class Student with read-write JavaBeans properties name" in {
      //  (of type String) and id (of type Long). What methods are
      // generated? (Use javap to check.) Can you call the JavaBeans
      // getters and setters in Scala? Should you?

      val s = new Student

      s.setName("Mariah")
      s.getName should be("Mariah")

      s.setId(2L)
      s.getId should be(2L)

      println("Yes, No")
    }

    "#6 - In the Person class of Section 5.1 , “Simple Classes and Parameterless Methods,”" in {
      // on page 49 , provide a primary constructor that turns negative ages to 0

      val p = new Person(-1)
      p.age should be(0)

      val p2 = new Person(33)
      p2.age should be(33)
    }

    "#7 - Write a class Person with a primary constructor that accepts a string containing" in {
      // a first name, a space, and a last name, such as new Person(" Fred Smith").
      // Supply read-only properties firstName and lastName.
      val p1 = new Person7("Fred Smith")

      p1.firstName should be("Fred")
      p1.lastName should be("Smith")

      // Should the primary constructor
      // parameter be a var, a val, or a plain parameter? Why?
      // Plain parameter, because then it's not accessible from outside the object, and it's simpler than
      // "private val/var"
    }

    "#8 - Make a class Car with read-only properties for manufacturer, model name," in {
      //  and model year, and a read-write property for the license plate.

      val c = new Car8("Scion", "xB")

      c.manufacturer should be("Scion")
      c.modelName should be("xB")
      c.modelYear should be(-1)
      c.licensePlate should be("")

      c.licensePlate = "BR549"
      c.licensePlate should be("BR549")

      val c1 = new Car8("Scion", "xB", 2006)
      c1.manufacturer should be("Scion")
      c1.modelName should be("xB")
      c1.modelYear should be(2006)
      c1.licensePlate should be("")

      val c2 = new Car8("Scion", "xB", 2006, "BR549")
      c2.manufacturer should be("Scion")
      c2.modelName should be("xB")
      c2.modelYear should be(2006)
      c2.licensePlate should be("BR549")

      // Supply four constructors.
      // All require the manufacturer and model name. Optionally, model year and license plate can
      // also be specified in the constructor. If not, the model year is set to -1 and the license
      // plate to the empty string. Which constructor are you choosing as the primary constructor? Why?

      // The empty one, because you asked for 4 constructors. Also, there is less monkeying around with
      // variable names
      //
      // It would be better like this:

      val c8a = new Car8a("Scion", "xB")

      c8a.manufacturer should be("Scion")
      //      c8a.modelName = ""
      c8a.modelName should be("xB")
      c8a.modelYear should be(-1)
      c8a.licensePlate should be("")
      c8a.licensePlate = "BR549"
      c8a.licensePlate should be("BR549")
    }

    "#9 - Reimplement the class of the preceding exercise in Java, C#, or C + + (your choice)." ignore {
      // Just no.
    }

    "#10 - Consider the class, rewrite it." in {
      // Consider the class
      // class Employee( val name: String, var salary: Double) {
      //  def this() { this(" John Q. Public", 0.0) }
      // }
      // Rewrite it to use explicit fields and a default primary constructor. Which form do you prefer? Why?

      val e1 = new Employee10()

      e1.name should be("John Q. Public")
      e1.salary should be (0.0)

      val e2 = new Employee10a()

      e2.name should be("John Q. Public")
      e2.salary should be (0.0)
    }
  }
}
