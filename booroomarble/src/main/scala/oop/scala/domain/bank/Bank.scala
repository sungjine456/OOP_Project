package oop.scala.domain.bank

import oop.scala.domain.money.{ MoneyBundle, MoneyCalculation }
import oop.scala.domain.exception.WrongPriceException

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
  def withdraw(money: Int): MoneyBundle = MoneyCalculation.addValueToMoneyBundle(money)

  /**
   * 은행에 돈을 내다.
   * @param moneyToReceive 받을 금액
   * @param receivedMoney 받은 금액
   */
  def expenses(moneyToReceive: MoneyBundle, receivedMoney: MoneyBundle): MoneyBundle = {
    if(moneyToReceive.maxMoney >= receivedMoney.maxMoney)
      MoneyBundle(moneyToReceive.maxMoney - receivedMoney.maxMoney)
    else throw new WrongPriceException
  }
}
