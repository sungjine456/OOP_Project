package oop.scala.domain.money

object FiveHundredThousandWon extends Money {
  override val value = 500 * thousand

  def parent: Option[Money] = None

  def child: Option[Money]= Some(HundredThousandWon)
}
