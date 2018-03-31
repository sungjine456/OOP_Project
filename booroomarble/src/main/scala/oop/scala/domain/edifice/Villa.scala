package oop.scala.domain.edifice

case class Villa(override val price: Int) extends Edifice {
  override protected val increaseRate = 2

  override def upgrade: Option[Edifice] = Some(Hotel(price * increaseRate))

  override def subEdifice: Option[Edifice] = Some(Land(0))
}
