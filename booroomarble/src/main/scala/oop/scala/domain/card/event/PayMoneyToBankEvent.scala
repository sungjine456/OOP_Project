package oop.scala.domain.card.event

import oop.scala.domain.money.{ Money, MoneyBundle }
import oop.scala.domain.user.User

class PayMoneyToBankEvent(val range: Money) extends PayMoneyEvent with BankEvent {
  //TODO: 거슬러 받아야한다.
  override def publish(user: User): Unit = {
    bank.expenses(MoneyBundle(range.value))
    super.publish(user)
  }
}
