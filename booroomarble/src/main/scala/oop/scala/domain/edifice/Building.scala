package oop.scala.domain.edifice

class Building(override val tollFee: Int) extends Edifice {
  override val price = 500000
  override protected val increaseRate = 0

  override def upgrade: Option[Edifice] = None

  override def subEdifice: Option[Edifice] = Some(new Hotel(0))
}
