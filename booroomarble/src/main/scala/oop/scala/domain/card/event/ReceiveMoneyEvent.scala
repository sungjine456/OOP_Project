package oop.scala.domain.card.event

import oop.scala.domain.money.MoneyBundle
import oop.scala.domain.user.User

trait ReceiveMoneyEvent extends MoneyEvent {
  override def publish(user: User): Unit = {
    user.receive(MoneyBundle(range.value))
  }
}
