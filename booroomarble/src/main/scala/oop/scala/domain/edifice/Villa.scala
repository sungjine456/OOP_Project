package oop.scala.domain.edifice

class Villa(override val tollFee: Int) extends Edifice {
  override val price = 100000
  override val increaseRate = 2

  override def upgrade: Option[Edifice] = Some(new Hotel(tollFee * increaseRate))
}
