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

  "+" should "add each value" in {
    val moneyBundle: MoneyBundle = MoneyBundle()
    moneyBundle.put(ThousandWon)
    moneyBundle.put(ThousandWon)
    moneyBundle.put(ThousandWon)
    moneyBundle.put(TenThousandWon)
    moneyBundle.put(FiveThousandWon)

    val addMoneyBundle: MoneyBundle = MoneyBundle()
    addMoneyBundle.put(ThousandWon)
    addMoneyBundle.put(ThousandWon)
    addMoneyBundle.put(TenThousandWon)
    addMoneyBundle.put(FiveThousandWon)
    addMoneyBundle.put(FiveThousandWon)

    val newMoneyBundle = moneyBundle + addMoneyBundle
    assert(newMoneyBundle.get(FiveHundredThousandWon) === 0)
    assert(newMoneyBundle.get(HundredThousandWon) === 0)
    assert(newMoneyBundle.get(FiftyThousandWon) === 0)
    assert(newMoneyBundle.get(TenThousandWon) === 2)
    assert(newMoneyBundle.get(FiveThousandWon) === 3)
    assert(newMoneyBundle.get(ThousandWon) === 5)
  }
}
