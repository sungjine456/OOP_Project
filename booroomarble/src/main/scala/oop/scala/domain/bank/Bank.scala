package oop.scala.domain.bank

import oop.scala.domain.money.{ Money, MoneyBundle, MoneyCalculation }

/**
 * 은행은 돈을 무제한으로 가지고 있다고 설정한다.
 * 돈이 무제한이므로 은행은 돈을 가질 필요가 없다.
 */
object Bank {
  /**
   * 인출하다.
   * @param money 인출할 금액
   * @return 인출하는 금액에 맞춰 돈을 준다.
   */
  def withdraw(money: Int): MoneyBundle = {
    MoneyCalculation.addValueToMoneyBundle(money)
  }

  /**
   * 은행은 돈을 무제한으로 가지고 있기 때문에 별 다른 로직은 필요없다.
   * 돈을 사용하는 사용자의 돈만 깍으면 된다.
   */
  def expenses(money: Money): Unit = {}
}
