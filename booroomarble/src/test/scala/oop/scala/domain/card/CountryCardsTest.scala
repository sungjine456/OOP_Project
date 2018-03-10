package oop.scala.domain.card

import org.scalatest.FlatSpec

class CountryCardsTest extends FlatSpec {
  "smallWorth()" should "return small worth" in {
    val countryCards: CountryCards = new CountryCards

    val countryCardOne = CountryCard("1", 1, 1)
    val countryCardTwo = CountryCard("2", 100, 100)

    countryCards.add(countryCardOne)
    countryCards.add(countryCardTwo)

    assert(countryCards.smallWorth == countryCardOne)
  }
}
