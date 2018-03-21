package oop.scala.domain.money

trait Money {
  val value: Int
  protected val thousand = 1000

  def parent: Option[Money]

  def child: Option[Money]
}
