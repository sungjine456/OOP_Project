package oop.scala.domain.money

import org.scalatest.FlatSpec

class MoneyBundleTest extends FlatSpec {
  "put(money: A, value: Int)" should "add money as much as value" in {
    val moneyBundle: MoneyBundle = MoneyBundle()

    moneyBundle.put(ThousandWon, 10)

    assert(moneyBundle.maxMoney == 10000)
  }

  "put(money: A)" should "add money as much as value" in {
    val moneyBundle: MoneyBundle = MoneyBundle()

    moneyBundle.put(ThousandWon)

    assert(moneyBundle.maxMoney == 1000)
  }

  "withdraw(Money, Int)" should "withdraw money by int and return moneyBundle" in {
    val moneyBundle = MoneyBundle(10000)

    assert(moneyBundle.withdraw(TenThousandWon, 1).maxMoney === 10000)
    assert(moneyBundle.maxMoney === 0)
  }
}
