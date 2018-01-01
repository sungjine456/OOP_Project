package oop.scala.domain.user

import oop.scala.domain.card.CountryCard
import oop.scala.domain.money.{ MoneyBundle, Wallet }
import scala.collection.mutable.Set

class User {
  private val wallet: Wallet = new Wallet
  private val countryCard: Set[CountryCard] = Set.empty

  def maxMoney: Int = {
    wallet.maxMoney
  }

  def payMoney(money: Int): Option[MoneyBundle] = {
    if (money > wallet.maxMoney) {
      return None
    }
    Some(wallet.give(money))
  }

  def receive(money: MoneyBundle): Unit = {
    wallet.put(money)
  }

  def containsCard(card: CountryCard): Boolean = {
    countryCard.contains(card)
  }

  def addCard(card: CountryCard): Unit = {
    countryCard add card
  }
}
