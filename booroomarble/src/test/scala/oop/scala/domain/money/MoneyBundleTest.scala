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

    assert(moneyBundle.withdraw(TenThousandWon, 1).get.maxMoney === 10000)
    assert(moneyBundle.maxMoney === 0)
  }

  it should "after changing money with an int, withdraw money by int and return moneyBundle" in {
    val moneyBundle = MoneyBundle(10000)

    assert(moneyBundle.withdraw(FiveThousandWon, 1).get.maxMoney === 5000)
    assert(moneyBundle.maxMoney === 5000)
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
    addMoneyBundle.put(FiftyThousandWon)
    addMoneyBundle.put(HundredThousandWon)
    addMoneyBundle.put(FiveHundredThousandWon)

    val newMoneyBundle = moneyBundle + addMoneyBundle
    assert(newMoneyBundle.get(FiveHundredThousandWon) === 1)
    assert(newMoneyBundle.get(HundredThousandWon) === 1)
    assert(newMoneyBundle.get(FiftyThousandWon) === 1)
    assert(newMoneyBundle.get(TenThousandWon) === 2)
    assert(newMoneyBundle.get(FiveThousandWon) === 3)
    assert(newMoneyBundle.get(ThousandWon) === 5)
  }

  "-" should "subtract each value" in {
    val moneyBundle: MoneyBundle = MoneyBundle()
    moneyBundle.put(ThousandWon)
    moneyBundle.put(ThousandWon)
    moneyBundle.put(ThousandWon)
    moneyBundle.put(ThousandWon)
    moneyBundle.put(ThousandWon)
    moneyBundle.put(TenThousandWon)
    moneyBundle.put(FiveThousandWon)
    moneyBundle.put(FiveThousandWon)
    moneyBundle.put(FiftyThousandWon)
    moneyBundle.put(HundredThousandWon)
    moneyBundle.put(FiveHundredThousandWon)

    val subtractMoneyBundle: MoneyBundle = MoneyBundle()
    subtractMoneyBundle.put(TenThousandWon)
    subtractMoneyBundle.put(FiveThousandWon)

    val newMoneyBundle = moneyBundle - subtractMoneyBundle
    assert(newMoneyBundle.get(FiveHundredThousandWon) === 1)
    assert(newMoneyBundle.get(HundredThousandWon) === 1)
    assert(newMoneyBundle.get(FiftyThousandWon) === 1)
    assert(newMoneyBundle.get(TenThousandWon) === 0)
    assert(newMoneyBundle.get(FiveThousandWon) === 1)
    assert(newMoneyBundle.get(ThousandWon) === 5)
  }

  it should "subtract upper value when each value is small" in {
    val moneyBundle: MoneyBundle = MoneyBundle()
    moneyBundle.put(TenThousandWon)

    val subtractMoneyBundle: MoneyBundle = MoneyBundle()
    subtractMoneyBundle.put(ThousandWon)
    subtractMoneyBundle.put(ThousandWon)

    val newMoneyBundle = moneyBundle - subtractMoneyBundle
    assert(newMoneyBundle.get(FiveHundredThousandWon) === 0)
    assert(newMoneyBundle.get(HundredThousandWon) === 0)
    assert(newMoneyBundle.get(FiftyThousandWon) === 0)
    assert(newMoneyBundle.get(TenThousandWon) === 0)
    assert(newMoneyBundle.get(FiveThousandWon) === 1)
    assert(newMoneyBundle.get(ThousandWon) === 3)
  }
}
