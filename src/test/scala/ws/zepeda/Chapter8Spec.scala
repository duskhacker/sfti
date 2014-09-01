package ws.zepeda

import org.scalatest.{FreeSpec, Matchers}
import ws.zepeda.Chapter8._

class Chapter8Spec extends FreeSpec with Matchers {
  "Chapter8" - {
    "#1 - Extend the following BankAccount class to a CheckingAccount class that" in {
      // charges $ 1 for every deposit and withdrawal.
      // class BankAccount( initialBalance: Double) {
      //  private var balance = initialBalance
      //  def deposit (amount: Double) = { balance + = amount; balance }
      //  def withdraw( amount: Double ) = { balance -= amount; balance }
      //  def currentBalance = balance
      // }

      val ca = new CheckingAccount(100.0)
      ca.deposit(10.00) should be(109.00)
      ca.withdraw(10.00) should be(98.00)
    }

    "#2 - 2. Extend the BankAccount class of the preceding exercise into a class SavingsAccount that earns" in {
      // interest every month (when a method earnMonthlyInterest is called) and has three free deposits or
      // withdrawals every month. Reset the transaction count in the earnMonthlyInterest method

      val sa = new SavingsAccount(100.0)

      sa.deposit(10.0) should be(110.0)
      sa.withdraw(10.0) should be(100.0)
      sa.deposit(10.0) should be(110.0)
      sa.withdraw(10.0) should be(99.0)
      sa.deposit(10.00) should be(108.0)
      sa.earnMonthlyInterest
      sa.deposit(10.00) should be(123.40)
    }

    "#3 - Consult your favorite Java or C++ textbook that is sure to have an example of a toy" in {
      // inheritance hierarchy, perhaps involving employees, pets , graphical shapes, or the like.
      // Implement the example in Scala.

      val bicycle = new Bicycle(startGear = 5, startCadence = 2, startSpeed = 10 )
      bicycle should have ('speed (10), 'cadence(2), 'gear(5))
      bicycle.speed = 20
      bicycle.gear = 2
      bicycle.cadence = 3
      bicycle should have ('speed (20), 'cadence(3), 'gear(2))

      bicycle.applyBrake(5)
      bicycle.speed should be(15)
      bicycle.speedUp(20)
      bicycle.speed should be(35)

      val mountainBike = new MountainBike(startGear = 5, startCadence = 2, startSpeed = 10, seatHeight = 3 )
      mountainBike should have ('speed (10), 'cadence(2), 'gear(5))
      mountainBike.speed = 20
      mountainBike.gear = 2
      mountainBike.cadence = 3
      mountainBike should have ('speed (20), 'cadence(3), 'gear(2))

      mountainBike.applyBrake(5)
      mountainBike.speed should be(15)
      mountainBike.speedUp(20)
      mountainBike.speed should be(35)
      mountainBike.seatHeight = 5
      mountainBike.seatHeight should be(5)
    }

    "#4 - Define an abstract class Item with methods price and description" in {
      // A SimpleItem is an item whose price and description are specified in the constructor.
      // Take advantage of the fact that a val can override a def. A Bundle is an item that contains other items.
      // Its price is the sum of the prices in the bundle. Also provide a mechanism for adding items to the bundle
      // and a suitable description method.

      val si = new SimpleItem(100.0, "A New Car!")
      si.price should be(100.0)
      si.description should be("A New Car!")

      var bundle = new Bundle
      bundle = bundle.add(si)
      bundle = bundle.add(new SimpleItem(200.00, "A vacation package!"))
      bundle.price should be(300.00)
      bundle.description should be("A vacation package!\nA New Car!")

    }

    "#5 - Design a class Point whose x and y coordinate values can be provided in a" in {
      // constructor. Provide a subclass LabeledPoint whose constructor takes a label value and x and y coordinates,
      // such as new LabeledPoint("Black Thursday", 1929, 230.07)

      val p = new Point(1929, 230.07)
      p.x should be(1929)
      p.y should be(230.07)

      val lp = new LabeledPoint("Black Thursday", 1929, 230.07)
      lp.label should be("Black Thursday")
      lp.x should be(1929)
      lp.y should be(230.07)
    }

    "#6 - Define an abstract class Shape with an abstract method centerPoint and subclasses Rectangle and Circle" in {
      //  Provide appropriate constructors for the subclasses and override the centerPoint method in each subclass.

      val rec = new Rectangle(new Point(10D, 10D), 5, 10)
      rec.centerPoint should have('x(12.5), 'y(15))
      rec.isInstanceOf[Shape] should be(true)

      val circle = new Circle(new Point(10, 10), 5)
      circle.isInstanceOf[Shape] should be(true)
      circle.centerPoint should have('x(10), 'y(10))
    }

    "#7 - Provide a class Square that extends java.awt.Rectangle and has three constructors: one that constructs" in {
      // a square with a given corner point and width, one that constructs a square with corner (0, 0) and a
      // given width, and one that constructs a square with corner (0, 0) and width 0

      val s = new Square
      s should have('getX(0), 'getY(0), 'getWidth(0), 'getHeight(0))

      val s1 = new Square(new Point(1, 1), 5)
      s1 should have('getX(1), 'getY(1), 'getWidth(5), 'getHeight(5))

      val s2 = new Square(5)
      s2 should have('getX(0), 'getY(0), 'getWidth(5), 'getHeight(5))

    }

    "#9 - In the Creature class of Section 8.10 , “ Construction Order and Early Definitions ,”" in {
      //  on page 92

      System.err.println("START: Creating OriginalCreature ---------------")
      (new OriginalCreature).env.size should be(10)
      System.err.println("END Creating OriginalCreature ---------------")

      // The range value is used in the superclass constructor, and the superclass
      // constructor runs _before_ the subclass constructor
      // So, you get broken behavior.
      System.err.println("START: Creating OriginalAnt ---------------")
      (new OriginalAnt).env.size should be(0) // looking for 2.
      System.err.println("END Creating OriginalAnt ---------------")

      // replace val range with a def.
      System.err.println("Creating CreatureWithDef ---------------")
      (new CreatureWithDef).env.size should be(10)
      System.err.println("Creating CreatureWithDef ---------------")


      // What happens when you also use a def in the Ant subclass?
      // A: The correct behavior.
      System.err.println("START: Creating AntWithDef ---------------")
      (new AntWithDef).env.size should be(2)
      System.err.println("END: Creating AntWithDef ---------------")

      System.err.println("Creating AntWitVal ---------------")
      (new AntWithVal).env.size should be(0)
      System.err.println("Creating AntWithVal ---------------")

      // Why?
      // A: The correct behavior is observed when 'def range' is used
      // because the methods are defined at compile time, the range is
      // set to a static value at compile time and returned correctly at
      // at object construction time. When a val is used,
      // the value is set at run-time, when the val is over-ridden in a sub-class, the superclass val
      // is first initialized to zero before the sub-class constructor is called and sets the val
      // and the incorrect behavior is observed.
    }

    "#10 - The file scala/collection/immutable/Stack.scala contains the definition" in {
      // class Stack[A] protected (protected val elems: List[A]) Explain the meanings of the protected keywords.
      // (Hint: Review the discussion of private constructors in Chapter 5 .)

      // The constructor can only be called by Stack and subclasses of Stack because of the first protected statement.
      // The elems entity can only be accessed by Stack and subclasses of Stack because of the second protected
      // statement.
    }
  }
}
