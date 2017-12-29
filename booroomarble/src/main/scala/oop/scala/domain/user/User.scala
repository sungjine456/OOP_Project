package oop.scala.domain.user

import oop.scala.domain.card.CountryCard
import oop.scala.domain.money.{ MoneyBundle, Wallet }
import scala.collection.mutable.Set

class User {
  private val wallet: Wallet = new Wallet
  private val countryCard: Set[CountryCard] = Set.empty

  def payMoney(money: Int): Option[MoneyBundle] = {
    // 지불해야하는 금액을 받고 지갑에서 돈을 꺼내 준다.
    None
  }

  def getMoney(money: MoneyBundle): Unit = {
    wallet.put(money)
  }

  def containsCard(card: CountryCard): Boolean = {
    countryCard.contains(card)
  }

  def getCard(card: CountryCard): Unit = {
    countryCard add card
  }
}
