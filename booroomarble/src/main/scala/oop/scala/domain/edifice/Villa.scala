package oop.scala.domain.edifice

case class Villa(override val tollFee: Int) extends Edifice {
  override val price = 100000
  override protected val increaseRate = 2

  override def upgrade: Option[Edifice] = Some(Hotel(tollFee * increaseRate))

  override def subEdifice: Option[Edifice] = Some(Land(0))
}
