package oop.scala.domain.card.event

import oop.scala.domain.money.{ Money, MoneyBundle }
import oop.scala.domain.user.User

class DepositEvent(range: Money) extends Event {
  override def publish(user: User): Unit = {
    user.receive(MoneyBundle(range.value))
  }
}
