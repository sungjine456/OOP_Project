package oop.scala.domain.user

import oop.scala.domain.card.{ CountryCard, CountryCards }
import oop.scala.domain.money.{ MoneyBundle, Wallet }

case class User(id: String) {
  private val wallet: Wallet = new Wallet
  private val countryCards: CountryCards = new CountryCards

  def maxMoney: Int = wallet.maxMoney

  def payMoney(money: MoneyBundle): MoneyBundle = {
    if (money.maxMoney > wallet.maxMoney) {
      if (money.maxMoney > wallet.maxMoney + countryCards.totalValue) return wallet.total
      else {}//TODO: 지갑에 돈이 없어 나라를 팔아야하는 경우
    }
    wallet.give(money)
  }

  def receive(money: MoneyBundle): Unit = wallet.put(money)

  def haveCard(card: CountryCard): Boolean = countryCards.contains(card)

  def addCard(card: CountryCard): Unit = countryCards add card

  def finishPlaying: Boolean = maxMoney <= 0 && countryCards.isEmpty
}
