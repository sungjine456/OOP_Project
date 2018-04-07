package oop.scala.domain.card

import scala.collection.mutable.Set

class CountryCards {
  private val countryCards: Set[CountryCard] = Set.empty

  def contains(card: CountryCard): Boolean = {
    countryCards.contains(card)
  }

  def add(card: CountryCard): Unit = countryCards add card

  def remove(card: CountryCard): Unit = countryCards remove card

  def isEmpty: Boolean =  countryCards.isEmpty

  def smallWorth: CountryCard =  countryCards.minBy(cc => cc.totalTollFee)

  def totalValue: Int = {
    countryCards.map(c => c.certificatePrice + c.edificeUpgradePrice).sum
  }
}
