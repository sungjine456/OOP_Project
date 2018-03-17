package oop.scala.domain.card.event

import oop.scala.domain.money.Money
import oop.scala.domain.user.User

class ReceiveMoneyFromBankEvent(val range: Money) extends ReceiveMoneyEvent with BankEvent {
  override def publish(user: User): Unit = {
    bank.withdraw(range.value)
    super.publish(user)
  }
}
