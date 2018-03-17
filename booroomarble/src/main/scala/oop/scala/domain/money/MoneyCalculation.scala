package oop.scala.domain.money

object MoneyCalculation {
  private def calcMoney(giveMoney: Int, moneyBundle: Option[MoneyBundle] = None): MoneyBundle = {
    var moneyValue = giveMoney
    val bundle = new MoneyBundle
    for (key <- bundle.keySet) {
      if (moneyValue / key.value > 0) {
        moneyBundle match {
          case Some(mb) => mb.withdraw(key, moneyValue / key.value)
          case None =>
        }
        bundle.put(key, moneyValue / key.value)
        moneyValue = moneyValue % key.value
      }
    }
    bundle
  }

  def addValueToMoneyBundle(giveMoney: Int): MoneyBundle = calcMoney(giveMoney)

  def addValueToMoneyBundle(giveMoney: MoneyBundle): MoneyBundle = calcMoney(giveMoney.maxMoney)

  def minusValueToMoneyBundle(giveMoney: MoneyBundle, moneyBundle: MoneyBundle): MoneyBundle = {
    calcMoney(giveMoney.maxMoney, Some(moneyBundle))
  }
}
