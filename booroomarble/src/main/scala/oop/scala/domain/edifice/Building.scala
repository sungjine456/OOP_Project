package oop.scala.domain.edifice

class Building(override val tollFee: Int) extends Edifice {
  override val price = 500000
  override val increaseRate = 0

  override def upgrade: Option[Edifice] = None
}
