package oop.scala.domain.edifice

case class Land(override val tollFee: Int) extends Edifice {
  override val price = 20000
  override protected val increaseRate = 2

  override def upgrade: Option[Edifice] = Some(Villa(tollFee * increaseRate))

  override def subEdifice: Option[Edifice] = None
}
