package oop.scala.domain.money

object TenThousandWon extends Money {
  override val value = 10 * thousand

  def parent: Option[Money] = Some(FiftyThousandWon)

  def child: Option[Money] = Some(FiveThousandWon)
}
