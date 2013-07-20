package ws.zepeda

import scala.beans.BeanProperty

object Chapter5 {

  class Employee10( val name: String, var salary: Double) {
    def this() { this("John Q. Public", 0.0) }
  }

  class Employee10a( val name:String = "John Q. Public", val salary: Double = 0.0)

  class Car8a(private val mfg: String,
              private val model: String,
              private val year: Int = -1,
              var licensePlate:String = "") {
    def manufacturer = mfg
    def modelName = model
    def modelYear = year
  }

  class Car8 {

    private var mfg: String = _
    private var model: String = _
    private var year: Int = _
    var licensePlate: String = _

    def this(mfg: String, model: String) {
      this()
      this.mfg = mfg
      this.model = model
      this.year = -1
      this.licensePlate = ""
    }

    def this(mfg: String, model: String, year: Int) {
      this(mfg, model)
      this.year = year
    }

    def this(mfg: String, model: String, year: Int, licensePlate: String) {
      this(mfg, model, year)
      this.licensePlate = licensePlate
    }

    def manufacturer = mfg

    def modelName = model

    def modelYear = year
  }

  class Person7(fullName: String) {
    private val Array(first, last) = fullName.split("\\s+")

    def firstName = first

    def lastName = last
  }

  class Person(a: Int) {
    var age = if (a > 0) a else 0
  }

  class Student {
    @BeanProperty var name: String = _
    @BeanProperty var id: Long = _
  }

  class Counter {
    private var value = Int.MaxValue

    def increment() {
      if (value < Int.MaxValue)
        value += 1
    }

    def current = value
  }

  class BankAccount {
    private var currentBalance = 0.0

    def deposit(amount: Double) {
      currentBalance += amount
    }

    def withdraw(amount: Double) {
      currentBalance -= amount
    }

    def balance = currentBalance
  }

  class Time3(val hrs: Int, val min: Int) {
    def before(o: Time3) = if (o.hrs > hrs || (o.hrs == hrs && o.min > min)) true else false
  }

  class Time4(val hrs: Int, val min: Int) {
    val time = (hrs * 60 - 1) + min

    def before(o: Time4) = if (o.time > time) true else false
  }

}