package oop.scala.domain.card

import oop.scala.domain.edifice.{ Edifice, Land }

case class CountryCard(name: String, private val certificatePrice: Int, private val tollFee: Int) extends Card {
  val edifice: Edifice = new Land(tollFee)

  // 통행료
  def totalTollFee: Int = {
    edifice.tollFee
  }

  def edificeUpgrade(price: Int): Unit = {
    // 건물을 짓는데 정해진 가격 혹은 그 이상을 내야한다.
    if (edifice.price >= price) {

    }
  }
}
