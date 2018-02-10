package oop.scala.domain.card.event

import oop.scala.domain.money.{ MoneyBundle, ThousandWon }
import oop.scala.domain.user.User
import org.scalatest.FlatSpec

class DepositEventTest extends FlatSpec {
  "publish()" should "deposit money" in {
    val user: User = User("test")
    user.receive(MoneyBundle(1000))

    assert(user.maxMoney == 1000)

    val event = new DepositEvent(ThousandWon)
    event.publish(user)

    assert(user.maxMoney == 2000)
  }
}
