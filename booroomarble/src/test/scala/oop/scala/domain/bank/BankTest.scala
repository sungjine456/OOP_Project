package oop.scala.domain.bank

import oop.scala.domain.money._
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
}
