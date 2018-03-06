package oop.scala.domain.user

import scala.collection.mutable.Set

import oop.scala.domain.card.CountryCard
import oop.scala.domain.money.{ MoneyBundle, Wallet }

case class User(id: String) {
  private val wallet: Wallet = new Wallet
  private val countryCard: Set[CountryCard] = Set.empty
  private var _position: Int = 0

  def maxMoney: Int = {
    wallet.maxMoney
  }

  def payMoney(money: MoneyBundle): Option[MoneyBundle] = {
    if (money.maxMoney > wallet.maxMoney) {
      return None
    }
    Some(wallet.give(money))
  }

  def receive(money: MoneyBundle): Unit = {
    wallet.put(money)
  }

  def haveCard(card: CountryCard): Boolean = {
    countryCard.contains(card)
  }

  def addCard(card: CountryCard): Unit = {
    countryCard add card
  }

  def position_= (position: Int): Unit = {
    _position = position
  }

  def position: Int = _position

  def finishPlaying: Boolean = maxMoney <= 0 && countryCard.isEmpty
}
