package oop.scala.domain.bank

import oop.scala.domain.exception.WrongPriceException
import oop.scala.domain.money.{ Money, MoneyBundle, MoneyCalculation }
import oop.scala.domain.user.User

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
    if (moneyToReceive >= receivedMoney) moneyToReceive - receivedMoney
    else throw new WrongPriceException
  }

  def changeMoney(money: Money): Option[MoneyBundle] = {
    money.child.map(child => MoneyBundle(child, money.value / child.value))
  }

  // TODO: 사용자가 파산했을 때 시스템에 알릴 수 있는 방안에 대해 생각해보기
  def convertCountryToMoney(user: User, needful: Int): Unit = {
    def countSell(value: Int): Int = {
      val sellCard = user.sellCard

      if (sellCard.totalValueOfEdifice + value >= needful) {
        sellCard.totalValueOfEdifice + value
      } else {
        countSell(sellCard.totalValueOfEdifice)
      }
    }

    user.receive(MoneyBundle(countSell(0)))
  }
}
