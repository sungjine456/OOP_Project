package oop.scala.domain.edifice

case class Land(override val price: Int) extends Edifice {
  override val increaseRate = 2

  override def upgrade: Option[Edifice] = Some(Villa(price * increaseRate))

  override def subEdifice: Option[Edifice] = None
}

object Land {
  val increaseRate: Int = increaseRate
}
