package oop.scala.domain.card

import org.scalatest.FlatSpec

class CountryCardTest extends FlatSpec {
  "totalTollFee()" should "have a different amount of money to pay for each edifice" in {
    val country = CountryCard("서울", 1000)

    assert(country.totalTollFee === 3000)

    assert(country.edificeUpgrade(2000).get == 0)

    assert(country.totalTollFee === 6000)

    assert(country.edificeUpgrade(4000).get == 0)

    assert(country.totalTollFee === 12000)

    assert(country.edificeUpgrade(8000).get == 0)

    assert(country.totalTollFee === 24000)
  }

  "totalValueOfEdifice" should "return total value of edifice" in {
    val country = CountryCard("서울", 1000)

    assert(country.totalValueOfEdifice === 1000)

    assert(country.edificeUpgrade(2000).get == 0)

    assert(country.totalValueOfEdifice === 3000)

    assert(country.edificeUpgrade(4000).get == 0)

    assert(country.totalValueOfEdifice === 7000)

    assert(country.edificeUpgrade(8000).get == 0)

    assert(country.totalValueOfEdifice === 15000)
  }

  "edificeUpgrade(Int)" should "return 0 and upgrade to upper edifice if price and upgradePrice are same money" in {
    val country = CountryCard("서울", 1000)

    assert(country.edificeUpgrade(2000).get == 0)
  }

  it should "return number and upgrade to upper edifice if price bigger than upgradePrice" in {
    val country = CountryCard("서울", 1000)

    assert(country.edificeUpgrade(3000).get == 1000)
  }

  it should "return None and upgrade to upper edifice if upgradePrice bigger than price" in {
    val country = CountryCard("서울", 1000)

    assert(country.edificeUpgrade(1000).isEmpty)
  }
}
