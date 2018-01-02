package oop.scala.domain.card

import org.scalatest.FlatSpec

class CountryCardTest extends FlatSpec {
  "price()" should "have a different amount of money to pay for each edifice" in {
    val country = CountryCard("서울", 100000, 20000)

    assert(country.totalTollFee === 20000)
  }
}
