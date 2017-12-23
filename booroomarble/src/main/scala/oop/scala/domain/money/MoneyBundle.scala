package oop.scala.domain.money

import scala.collection.mutable.Map

/**
 * 돈을 주고 받을 때 사용하기 위한 클래스
 */
class MoneyBundle {
  var moneyBundle: Map[Money, Int] = Map(
    ThousandWon -> 0,
    FiveThousandWon -> 0,
    TenThousandWon -> 0,
    FiftyThousandWon -> 0,
    HundredThousandWon -> 0,
    FiveHundredThousandWon -> 0
  )

  val keySet: List[Money] = List(FiveHundredThousandWon, HundredThousandWon, FiftyThousandWon,
    TenThousandWon, FiveThousandWon, ThousandWon)

  def put[A <: Money](money: A) {
    put(money, 1)
  }

  def put[A <: Money](money: A, value: Int) {
    moneyBundle(money) = moneyBundle(money) + value
  }

  def get(moneyKind: Money): Int = {
    moneyBundle(moneyKind)
  }
}
