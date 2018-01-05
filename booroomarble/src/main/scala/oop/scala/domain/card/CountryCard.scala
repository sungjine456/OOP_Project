package oop.scala.domain.card

import oop.scala.domain.edifice.{ Edifice, Land }

case class CountryCard(name: String, private val certificatePrice: Int, private val tollFee: Int) extends Card {
  private var edifice: Edifice = new Land(tollFee)

  val edificeUpgradePrice: Int = edifice.price

  // 통행료
  def totalTollFee: Int = {
    edifice.tollFee
  }

  def edificeUpgrade(): Unit = {
    edifice = edifice.upgrade.get
  }
}
