package oop.scala.domain.card.event

import oop.scala.domain.money.Money
import oop.scala.domain.user.User

class WithdrawEvent(range: Money) extends Event {
  override def publish(user: User): Unit = {
    user.payMoney(range.value)
  }
}
