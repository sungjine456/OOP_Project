package oop.scala.domain.bank

import oop.scala.domain.card.CountryCard
import oop.scala.domain.money._
import oop.scala.domain.user.User
import org.scalatest.FlatSpec

class BankTest extends FlatSpec {
  "withdraw" should "make MoneyBundle with calculate money" in {
    var bundle = Bank.withdraw(100000)

    assert(bundle.get(HundredThousandWon) === 1)

    bundle = Bank.withdraw(500000)

    assert(bundle.get(FiveHundredThousandWon) === 1)

    bundle = Bank.withdraw(50000)

    assert(bundle.get(FiftyThousandWon) === 1)

    bundle = Bank.withdraw(10000)

    assert(bundle.get(TenThousandWon) === 1)

    bundle = Bank.withdraw(5000)

    assert(bundle.get(FiveThousandWon) === 1)

    bundle = Bank.withdraw(1000)

    assert(bundle.get(ThousandWon) === 1)

    bundle = Bank.withdraw(567000)

    assert(bundle.get(FiveHundredThousandWon) === 1)
    assert(bundle.get(HundredThousandWon) === 0)
    assert(bundle.get(FiftyThousandWon) === 1)
    assert(bundle.get(TenThousandWon) === 1)
    assert(bundle.get(FiveThousandWon) === 1)
    assert(bundle.get(ThousandWon) === 2)
  }

  "changeMoney" should "change the money to ten low money" in {
    var bundle = Bank.changeMoney(TenThousandWon).get

    assert(bundle.get(TenThousandWon) === 0)
    assert(bundle.get(FiveThousandWon) === 2)

    bundle = Bank.changeMoney(FiftyThousandWon).get

    assert(bundle.get(FiftyThousandWon) === 0)
    assert(bundle.get(TenThousandWon) === 5)
  }

  it should "return none if don't have child money" in {
    var bundle = Bank.changeMoney(ThousandWon)

    assert(bundle === None)
  }

  "convertCountryToMoney(User, Int)" should "change country to money by Int" in {
    val user = User("testUser")
    val seoulCard = CountryCard("서울", 10000)
    val busanCard = CountryCard("부산", 10001)
    val daeguCard = CountryCard("대구", 10002)

    user.addCard(seoulCard)
    user.addCard(busanCard)
    user.addCard(daeguCard)
    assert(user.maxMoney === 0)

    Bank.convertCountryToMoney(user, 19000)

    assert(!user.haveCard(seoulCard))
    assert(!user.haveCard(busanCard))
    assert(user.haveCard(daeguCard))
    assert(user.maxMoney === 20000)
  }
}
