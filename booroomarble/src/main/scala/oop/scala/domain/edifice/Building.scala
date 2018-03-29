package oop.scala.domain.edifice

case class Building(override val tollFee: Int) extends Edifice {
  override val price = 500000
  override protected val increaseRate = 0

  override def upgrade: Option[Edifice] = None

  override def subEdifice: Option[Edifice] = Some(Hotel(0))
}
