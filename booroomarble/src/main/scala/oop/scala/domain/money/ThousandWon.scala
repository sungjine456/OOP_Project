package oop.scala.domain.money

object ThousandWon extends Money {
  override val value = thousand

  def parent: Option[Money] = Some(FiveThousandWon)

  def child: Option[Money] = None
}
