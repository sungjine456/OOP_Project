package oop.scala.domain.card

class CountryCards {
  private var countryCards: Set[CountryCard] = Set.empty

  def contains(card: CountryCard): Boolean = {
    countryCards.contains(card)
  }

  def add(card: CountryCard): Unit = countryCards += card

  def remove(card: CountryCard): Unit = countryCards -= card

  def isEmpty: Boolean =  countryCards.isEmpty

  def smallWorth: CountryCard =  countryCards.minBy(cc => cc.totalTollFee)

  def totalValue: Int = {
    countryCards.map(c => c.certificatePrice + c.edificeUpgradePrice).sum
  }
}
