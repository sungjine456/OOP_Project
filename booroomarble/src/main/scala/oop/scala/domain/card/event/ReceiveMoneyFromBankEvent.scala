package oop.scala.domain.card.event

import oop.scala.domain.bank.Bank
import oop.scala.domain.money.Money
import oop.scala.domain.user.User

case class ReceiveMoneyFromBankEvent(range: Money) extends ReceiveMoneyEvent {
  override def publish(user: User): Unit = {
    Bank.withdraw(range.value)
    super.publish(user)
  }
}
