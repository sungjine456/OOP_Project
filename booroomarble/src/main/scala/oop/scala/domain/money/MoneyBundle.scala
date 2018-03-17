package oop.scala.domain.money

import scala.collection.mutable.Map

/**
 * 돈을 주고 받을 때 사용하기 위한 클래스
 */
class MoneyBundle(money: Int = 0) {
  var moneyBundle: Map[Money, Int] = Map(
    ThousandWon -> 0,
    FiveThousandWon -> 0,
    TenThousandWon -> 0,
    FiftyThousandWon -> 0,
    HundredThousandWon -> 0,
    FiveHundredThousandWon -> 0
  )

  // 가지고 있는 총 금액
  def maxMoney: Int = {
    moneyBundle.map(m => m._1.value * m._2).sum
  }

  val keySet: List[Money] = List(FiveHundredThousandWon, HundredThousandWon, FiftyThousandWon,
    TenThousandWon, FiveThousandWon, ThousandWon)

  initialize(money)

  def put[A <: Money](money: A) {
    put(money, 1)
  }

  def put[A <: Money](money: A, value: Int) {
    moneyBundle(money) = moneyBundle(money) + value
  }

  def put(bundle: MoneyBundle): Unit = {
    for (key <- keySet) {
      put(key, bundle.get(key))
    }
  }

  def withdraw[A <: Money](money: A, value: Int): Unit = {
    if (false) {
      // 가지고 있는 금액보다 많이 뺄 때
    }
    moneyBundle(money) = moneyBundle(money) - value
  }

  def get(moneyKind: Money): Int = {
    moneyBundle(moneyKind)
  }

  def +(addMoneyBundle: MoneyBundle): MoneyBundle = {
    MoneyBundle(addMoneyBundle.maxMoney + maxMoney)
  }

  def -(minusMoneyBundle: MoneyBundle): MoneyBundle = {
    MoneyBundle(maxMoney - minusMoneyBundle.maxMoney)
  }

  def >=(compareMoneyBundle: MoneyBundle): Boolean = {
    maxMoney >= compareMoneyBundle.maxMoney
  }

  def <=(compareMoneyBundle: MoneyBundle): Boolean = {
    maxMoney <= compareMoneyBundle.maxMoney
  }

  def >(compareMoneyBundle: MoneyBundle): Boolean = {
    maxMoney > compareMoneyBundle.maxMoney
  }

  def <(compareMoneyBundle: MoneyBundle): Boolean = {
    maxMoney < compareMoneyBundle.maxMoney
  }

  private def initialize(money: Int) {
    if (money != 0) put(MoneyCalculation.addValueToMoneyBundle(money))
  }
}

object MoneyBundle {
  def apply: MoneyBundle = new MoneyBundle

  def apply(money: Int): MoneyBundle = new MoneyBundle(money)
}
