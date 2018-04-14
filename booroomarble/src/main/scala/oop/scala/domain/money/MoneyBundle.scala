package oop.scala.domain.money

import oop.scala.domain.bank.Bank

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

  def maxMoney: Int = moneyBundle.map(m => m._1.value * m._2).sum

  val keySet: Seq[Money] = Seq(FiveHundredThousandWon, HundredThousandWon, FiftyThousandWon,
    TenThousandWon, FiveThousandWon, ThousandWon)

  initialize(money)

  def put[A <: Money](money: A): Unit = put(money, 1)

  def put[A <: Money](money: A, value: Int) {
    val updateValue = moneyBundle(money) + value

    moneyBundle = moneyBundle + (money -> updateValue)
  }

  def put(bundle: MoneyBundle): Unit = {
    for (key <- keySet) put(key, bundle.get(key))
  }

  def withdraw[A <: Money](money: A, value: Int): MoneyBundle = {
    if (moneyBundle(money) < value) {
      // 가지고 있는 금액보다 많이 뺄 때
      // TODO: 돈에 대한 상위 개념을 추가하여 가지고 있는 money 보다 들어온 금액이 많을 때
      // TODO: 상위 단위의 돈을 찾을 수 있도록 구조 변경
    }
    val updateValue = moneyBundle(money) - value

    moneyBundle += money -> updateValue

    MoneyBundle(money.value * value)
  }

  def get(moneyKind: Money): Int = moneyBundle(moneyKind)

  def isEmpty: Boolean = maxMoney == 0

  def +(addMoneyBundle: MoneyBundle): MoneyBundle = {
    keySet.foreach(m => moneyBundle += m -> (moneyBundle(m) + addMoneyBundle.moneyBundle(m)))

    this
  }

  // TODO: 돈이 모자를 때에 대한 전반적인 고민이 필요하다....
  def -(minusMoneyBundle: MoneyBundle): MoneyBundle = {
    keySet.foreach(m => {
      def nonEmptyParentMoney(money: Money): Option[Money] = {
        money.parent match {
          case parentMoney if moneyBundle(parentMoney.get) != 0 => parentMoney
          case parentMoney => nonEmptyParentMoney(parentMoney.get)
          case None => None
        }
      }

      def changeMoney(money: Money) {
        moneyBundle += money -> (moneyBundle(money) - 1)
        moneyBundle += money.child.get -> Bank.changeMoney(money).get.moneyBundle(money.child.get)
      }

      val value = moneyBundle(m) - minusMoneyBundle.moneyBundle(m)

      if(value >= 0) {
        moneyBundle += m -> value
      } else {
        def minusMoney(subtractMoney: Money) {
          subtractMoney match {
            case money if money.child.isEmpty => None // 돈이 없을 때
            case money if m != money.child.get =>
              changeMoney(money)
              minusMoney(money.child.get)
            case money =>
              val childMoney = money.child.get
              changeMoney(money)
              moneyBundle += childMoney -> (moneyBundle(childMoney) - minusMoneyBundle.moneyBundle(childMoney))
          }
        }

        nonEmptyParentMoney(m) match {
          case Some(subtractMoney) => minusMoney(subtractMoney)
          case None => None // 돈이 없을 때...
        }
      }
    })

    this
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
  def apply(): MoneyBundle = new MoneyBundle(0)

  def apply(money: Int): MoneyBundle = new MoneyBundle(money)

  def apply(money: Money, value: Int): MoneyBundle = {
    val bundle = MoneyBundle()

    bundle.put(money, value)

    bundle
  }
}
