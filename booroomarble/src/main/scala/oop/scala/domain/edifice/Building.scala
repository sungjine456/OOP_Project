package oop.scala.domain.edifice

case class Building(override val price: Int) extends Edifice {
  override val increaseRate = 0

  override def upperEdifice: Option[Edifice] = None

  override def subEdifice: Option[Edifice] = Some(Hotel(price / Hotel.increaseRate))
}
