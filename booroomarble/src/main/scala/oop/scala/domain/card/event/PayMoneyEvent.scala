package oop.scala.domain.card.event

import oop.scala.domain.money.MoneyBundle
import oop.scala.domain.user.User

trait PayMoneyEvent extends MoneyEvent {
  override def publish(user: User): Unit = {
    user.payMoney(MoneyBundle(range.value))
  }
}
