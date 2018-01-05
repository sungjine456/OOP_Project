package oop.scala.domain.edifice

class Land(override val tollFee: Int) extends Edifice {
  override val price = 20000
  override val increaseRate = 2

  override def upgrade: Option[Edifice] = Some(new Villa(tollFee * increaseRate))
}
