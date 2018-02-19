package oop.scala.domain.user

import oop.scala.domain.card.CountryCard
import oop.scala.domain.money.MoneyBundle
import org.scalatest.FlatSpec

class UserTest extends FlatSpec {
  "addCard" should "add the card" in {
    val user: User = User("admin")
    val card = CountryCard("서울", 100000, 20000)

    assert(user.haveCard(card) === false)

    user.addCard(card)

    assert(user.haveCard(card) === true)
  }

  "payMoney" should "get money out of wallet" in {
    val user: User = User("admin")
    assert(user.payMoney(MoneyBundle(1000)) === None)

    user.receive(new MoneyBundle(1000))

    assert(user.payMoney(MoneyBundle(1000)).get.maxMoney === 1000)
  }
}
