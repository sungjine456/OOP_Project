package oop.scala.domain.dice

import org.scalatest.FlatSpec

class DiceTest extends FlatSpec {
  "The pips of the dice" should "have a value between 1 and 6" in {
    val dice = Dice

    for (i <- 1 to 100) {
      val pip: Int = dice.cast

      if (pip >= 7 || pip <= 0) {
        fail()
      }
    }
    succeed
  }
}
