package oop.scala.domain.edifice

class Hotel(override val tollFee: Int) extends Edifice {
  override val price = 300000
  override protected val increaseRate = 2

  override def upgrade: Option[Edifice] = Some(new Building(tollFee * increaseRate))
}
