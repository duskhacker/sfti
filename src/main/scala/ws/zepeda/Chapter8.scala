package ws.zepeda

object Chapter8 {

  class BankAccount(initialBalance: Double) {
    private var balance = initialBalance

    def deposit(amount: Double) = {
      balance += amount
      balance
    }

    def withdraw(amount: Double) = {
      balance -= amount
      balance
    }
  }

  class CheckingAccount(initialBalance: Double) extends BankAccount(initialBalance: Double) {
    final private val fee = 1

    override def deposit(amount: Double) = {
      super.deposit(amount - fee)
    }

    override def withdraw(amount: Double) = {
      super.withdraw(amount + fee)
    }
  }

  class SavingsAccount(initialBalance: Double) extends BankAccount(initialBalance: Double) {
    private var transactionCount = 0
    final private val interestRate = 0.05
    final private val freeTransactionCount = 3
    final private val fee = 1

    override def deposit(amount: Double) = {
      super.deposit(trackFreeTransactions(amount, -fee))
    }

    override def withdraw(amount: Double) = {
      super.withdraw(trackFreeTransactions(amount, fee))
    }

    def trackFreeTransactions(amount: Double, charge: Double): Double = {
      transactionCount += 1
      if (transactionCount > freeTransactionCount) amount + charge else amount
    }

    def earnMonthlyInterest {
      transactionCount = 0
      super.deposit(super.withdraw(0) * interestRate)
    }
  }

  //      public class MountainBike extends Bicycle {
  //
  //        // the MountainBike subclass adds one field
  //        public int seatHeight;
  //
  //        // the MountainBike subclass has one constructor
  //        public MountainBike(int startHeight,
  //          int startCadence,
  //          int startSpeed,
  //          int startGear) {
  //          super(startCadence, startSpeed, startGear);
  //          seatHeight = startHeight;
  //        }
  //
  //        // the MountainBike subclass adds one method
  //        public void setHeight(int newValue) {
  //          seatHeight = newValue;
  //        }
  //      }

  // public class Bicycle {
  // the Bicycle class has three fields
  //      public int cadence;
  //      public int gear;
  //      public int speed;
  //
  //      // the Bicycle class has one constructor
  //      public Bicycle(int startCadence, int startSpeed, int startGear) {
  //        gear = startGear;
  //        cadence = startCadence;
  //        speed = startSpeed;
  //      }
  //
  //      // the Bicycle class has four methods
  //      public void setCadence(int newValue) {
  //        cadence = newValue;
  //      }
  //
  //      public void setGear(int newValue) {
  //        gear = newValue;
  //      }
  //
  //      public void applyBrake(int decrement) {
  //        speed -= decrement;
  //      }
  //
  //      public void speedUp(int increment) {
  //        speed += increment;
  //      }
  //
  //    }
  // }

  class Bicycle(val startCadence: Int, val startGear: Int, val startSpeed: Int) {
    var cadence = startCadence
    var gear = startGear
    var speed = startSpeed

    def applyBrake(decrement: Int) {
      speed -= decrement
    }

    def speedUp(increment: Int) {
      speed += increment
    }
  }

  class MountainBike(override val startCadence: Int,
                     override val startGear: Int,
                     override val startSpeed: Int,
                     var seatHeight: Int)
    extends Bicycle(startCadence, startGear, startSpeed) {

  }


  abstract class Item {
    def price: Double

    def description: String
  }

  class SimpleItem(val price: Double, val description: String) extends Item

  class Bundle(val items: List[SimpleItem] = List.empty[SimpleItem]) extends Item {

    def add(item: SimpleItem) = new Bundle(item :: items)

    def price = {
      def iter(itms: List[SimpleItem]): Double =
        itms match {
          case Nil => 0
          case head :: tail => head.price + iter(tail)
        }
      iter(items)
    }

    def description = items.map(_.description).mkString("\n")
  }

  class Point(val x: Double, val y: Double)

  class LabeledPoint(val label: String, x: Double, y: Double) extends Point(x, y)

  abstract class Shape {
    def centerPoint: Point
  }

  class Rectangle(val vertex: Point, val width: Double, val height: Double) extends Shape {
    def centerPoint = new Point((width / 2) + vertex.x, (height / 2) + vertex.y)
  }

  class Circle(val center: Point, val radius: Double) extends Shape {
    def centerPoint = center
  }

  // Ok, this has only two constructors, but it fulfills the requirements with less code using default
  // arguments.
  class Square(val vertex: Point = new Point(0, 0), width: Int = 0)
    extends java.awt.Rectangle(vertex.x.toInt, vertex.y.toInt, width, width) {

    def this(width: Int) {
      this(new Point(0, 0), width)
    }
  }

  class OriginalCreature {
    System.err.println("OriginalCreature Constructor Called")
    val range: Int = 10
    System.err.println("OriginalCreature#range set to 10, (unless sub-class overrides it)")
    val env: Array[Int] = new Array[Int](range)
    System.err.println("OriginalCreature#env created with size %d".format(range))
  }

  class OriginalAnt extends OriginalCreature {
    System.err.println("OriginalAnt Constructor Called, val range set to 2")
    override val range = 2
  }

  class CreatureWithDef {
    System.err.println("CreatureWithDef Constructor Called")

    def range = {
      System.err.println("CreatureWithDef#range called, returning 10"); 10
    }

    val env: Array[Int] = new Array[Int](range)
    System.err.println("OriginalCreature#env created with size %d".format(range))
  }

  class AntWithDef extends CreatureWithDef {
    System.err.println("AntWithDef Constructor called")

    override def range = {
      System.err.println("AntWithDef#range called, returning 2"); 2
    }
  }

  class AntWithVal extends CreatureWithDef {
    System.err.println("AntWithVal Constructor called")
    override val range = 2
  }

}
