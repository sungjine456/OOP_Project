package oop.scala.domain.edifice

case class Hotel(override val price: Int) extends Edifice {
  override val increaseRate = 2

  override def upperEdifice: Option[Edifice] = Some(Building(price * increaseRate))

  override def subEdifice: Option[Edifice] = Some(Villa(price / Villa.increaseRate))
}

object Hotel {
  val hotel = new Hotel(0)
  val increaseRate: Int = hotel.increaseRate
}
