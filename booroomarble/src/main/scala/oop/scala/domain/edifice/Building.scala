package oop.scala.domain.edifice

case class Building(override val price: Int) extends Edifice {
  override protected val increaseRate = 0

  override def upgrade: Option[Edifice] = None

  override def subEdifice: Option[Edifice] = Some(Hotel(0))
}
