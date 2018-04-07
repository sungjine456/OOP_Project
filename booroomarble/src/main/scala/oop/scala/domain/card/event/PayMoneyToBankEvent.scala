package oop.scala.domain.card.event

import oop.scala.domain.bank.Bank
import oop.scala.domain.money.{ Money, MoneyBundle }
import oop.scala.domain.user.User

case class PayMoneyToBankEvent(range: Money) extends PayMoneyEvent {
  //TODO: 잘못된 가격의 금액을 줬을 경우에 대한 대비가 필요하다.
  override def publish(user: User): Unit = {
    val payMoney = user.payMoney(MoneyBundle(range.value))

    val change = Bank.expenses(MoneyBundle(range.value), payMoney)

    user.receive(change)
  }
}
