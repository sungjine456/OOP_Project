package oop.scala.domain.money

object FiveThousandWon extends Money {
  override val value = 5 * thousand

  def parent: Option[Money] = Some(TenThousandWon)

  def child: Option[Money] = Some(ThousandWon)
}
