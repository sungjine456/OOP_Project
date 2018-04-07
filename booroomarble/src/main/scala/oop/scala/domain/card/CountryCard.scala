package oop.scala.domain.card

import oop.scala.domain.edifice.{ Edifice, Land }

case class CountryCard(name: String, certificatePrice: Int) extends Card {
  private var edifice: Edifice = Land(certificatePrice)

  val edificeUpgradePrice: Int = edifice.price

  def totalTollFee: Int = edifice.tollFee

  def totalValueOfEdifice: Int = {
    def edificeValue(calEdifice: Edifice, price: Int): Int = {
      calEdifice.subEdifice match {
        case Some(subEdifice) => edificeValue(subEdifice, calEdifice.price + price)
        case None => calEdifice.price + price
      }
    }

    edificeValue(edifice, 0)
  }

  // TODO: 가격을 Int 형으로 받는게 맞는건가?
  def edificeUpgrade(price: Int): Option[Int] = {
    if (edifice.upgradeAbility(price)) {
      val upgradeEdifice = edifice.upperEdifice.get

      edifice = upgradeEdifice

      Some(price - upgradeEdifice.price)
    } else None
  }
}
