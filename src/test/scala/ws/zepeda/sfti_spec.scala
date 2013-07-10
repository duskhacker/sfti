package ws.zepeda 


import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers

class ExampleSpec extends FunSpec with ShouldMatchers{

  describe("A Stack") {

    it("should pop values in last-in-first-out order") (pending)

    it("should throw NoSuchElementException if an empty stack is popped") (pending)
  }
  
  describe("MyClass") {
    it("should have first as Int") {
      val mc = MyClass(first = 1)
      assert(mc.first === 1)
    }
    
    
    it("should work with matchers") {
      val mc = MyClass(first = 1)
      mc.first should equal(1)
      
      mc should have ('first (1))
    }
  }
}
