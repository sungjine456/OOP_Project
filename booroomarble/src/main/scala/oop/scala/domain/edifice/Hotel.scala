package oop.scala.domain.edifice

case class Hotel(override val price: Int) extends Edifice {
  override val increaseRate = 2

  override def upgrade: Option[Edifice] = Some(Building(price * increaseRate))

  override def subEdifice: Option[Edifice] = Some(Villa(price / Villa.increaseRate))
}

object Hotel {
  val increaseRate: Int = increaseRate
}
