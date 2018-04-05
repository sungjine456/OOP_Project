package oop.scala.domain.edifice

case class Land(override val price: Int) extends Edifice {
  override val increaseRate = 2

  override def upperEdifice: Option[Edifice] = Some(Villa(price * increaseRate))

  override def subEdifice: Option[Edifice] = None
}

object Land {
  val land = new Land(0)
  val increaseRate: Int = land.increaseRate
}
