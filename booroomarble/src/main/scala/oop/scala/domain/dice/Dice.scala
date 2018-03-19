package oop.scala.domain.dice

import scala.util.Random

object Dice {
  def cast: Int = Random.shuffle(1 to 6).head
}
