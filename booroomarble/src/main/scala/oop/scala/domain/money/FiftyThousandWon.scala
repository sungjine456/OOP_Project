package oop.scala.domain.money

object FiftyThousandWon extends Money {
  override val value = 50 * thousand

  def parent: Option[Money] = Some(HundredThousandWon)

  def child: Option[Money] = Some(TenThousandWon)
}
