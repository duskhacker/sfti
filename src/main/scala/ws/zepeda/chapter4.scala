package ws.zepeda

object Chapter4 {

  def countWords(tokens: Array[String], counts: Map[String, Int]): Map[String, Int] = {
    tokens match {
      case t if t.isEmpty => counts
      case t => {
        countWords(
          t.tail,
          if (counts.contains(t.head))
            counts + (t.head -> (counts(t.head) + 1))
          else
            counts + (t.head -> 1))
      }
    }

  }
  def minmax(a: Array[Int]) = (a.min, a.max)

  def lteggt(a: Array[Int], v: Int) = (a.filter(_ < v).size, a.filter(_ == v).size, a.filter(_ > v).size )

}