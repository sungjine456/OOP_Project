package oop.scala.domain.edifice

case class Hotel(override val tollFee: Int) extends Edifice {
  override val price = 300000
  override protected val increaseRate = 2

  override def upgrade: Option[Edifice] = Some(Building(tollFee * increaseRate))

  override def subEdifice: Option[Edifice] = Some(Villa(0))
}
