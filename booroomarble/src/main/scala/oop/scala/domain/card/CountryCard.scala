package oop.scala.domain.card

import oop.scala.domain.edifice.{ Edifice, Land }

case class CountryCard(name: String, certificatePrice: Int, private val tollFee: Int) extends Card {
  private var edifice: Edifice = Land(tollFee)

  val edificeUpgradePrice: Int = edifice.price

  // 통행료
  def totalTollFee: Int = edifice.tollFee

  // TODO: 가격보다 높은 돈을 넘겨받을 때 처리 방법 생각하기.
  // TODO: 가격을 Int 형으로 받는게 맞는건가?
  def edificeUpgrade(price: Int): Boolean = {
    val upgradeEdifice = edifice.upgrade.get

    var result = false

    if(upgradeEdifice.price == price){
      edifice = upgradeEdifice

      result = true
    }

    result
  }
}
