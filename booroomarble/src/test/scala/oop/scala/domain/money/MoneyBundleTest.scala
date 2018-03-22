package oop.scala.domain.money

import org.scalatest.FlatSpec

class MoneyBundleTest extends FlatSpec {
  "put(money: A, value: Int)" should "add money as much as value" in {
    val moneyBundle: MoneyBundle = MoneyBundle(0)

    moneyBundle.put(ThousandWon, 10)

    assert(moneyBundle.maxMoney == 10000)
  }

  "put(money: A)" should "add money as much as value" in {
    val moneyBundle: MoneyBundle = MoneyBundle(0)

    moneyBundle.put(ThousandWon)

    assert(moneyBundle.maxMoney == 1000)
  }
}
