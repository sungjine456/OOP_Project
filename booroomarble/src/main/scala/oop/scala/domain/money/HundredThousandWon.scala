package oop.scala.domain.money

object HundredThousandWon extends Money {
  override val value = 100 * thousand

  def parent: Option[Money] = Some(FiveHundredThousandWon)

  def child: Option[Money] = Some(FiftyThousandWon)
}
