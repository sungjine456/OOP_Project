package oop.scala.domain.edifice

case class Villa(override val price: Int) extends Edifice {
  override val increaseRate = 2

  override def upgrade: Option[Edifice] = Some(Hotel(price * increaseRate))

  override def subEdifice: Option[Edifice] = Some(Land(price / Land.increaseRate))
}

object Villa {
  val increaseRate: Int = increaseRate
}
