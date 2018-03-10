package oop.scala.domain.user

import oop.scala.domain.card.{ CountryCard, CountryCards }
import oop.scala.domain.money.{ MoneyBundle, Wallet }

case class User(id: String) {
  private val wallet: Wallet = new Wallet
  private val countryCards: CountryCards = new CountryCards

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
    countryCards.contains(card)
  }

  def addCard(card: CountryCard): Unit = {
    countryCards add card
  }

  def finishPlaying: Boolean = maxMoney <= 0 && countryCards.isEmpty
}
