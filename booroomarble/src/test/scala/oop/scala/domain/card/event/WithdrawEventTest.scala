package oop.scala.domain.card.event

import oop.scala.domain.money.{ MoneyBundle, ThousandWon }
import oop.scala.domain.user.User
import org.scalatest.FlatSpec

class WithdrawEventTest extends FlatSpec {
  "publish()" should "withdraw money" in {
    val user: User = User("test")
    user.receive(MoneyBundle(1000))

    assert(user.maxMoney == 1000)

    val event = new WithdrawEvent(ThousandWon)
    event.publish(user)

    assert(user.maxMoney == 0)
  }
}
