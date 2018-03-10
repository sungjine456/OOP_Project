package oop.scala.domain.card

import scala.collection.mutable.Set

class CountryCards {
  private val countryCards: Set[CountryCard] = Set.empty

  def contains(card: CountryCard): Boolean = {
    countryCards.contains(card)
  }

  def add(card: CountryCard): Unit = {
    countryCards add card
  }

  def isEmpty: Boolean = {
    countryCards.isEmpty
  }

  def smallWorth: CountryCard = {
    countryCards.minBy(cc => cc.totalTollFee)
  }
}
