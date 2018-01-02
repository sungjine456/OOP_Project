package oop.scala.domain.user

import oop.scala.domain.card.CountryCard
import oop.scala.domain.money.MoneyBundle
import org.scalatest.FlatSpec

class UserTest extends FlatSpec {
  "getCard" should "add the card" in {
    val user: User = new User
    val card = CountryCard("서울", 100000, 20000)

    assert(user.containsCard(card) === false)

    user.addCard(card)

    assert(user.containsCard(card) === true)
  }

  "payMoney" should "get money out of wallet" in {
    val user: User = new User
    assert(user.payMoney(1000) === None)

    user.receive(new MoneyBundle(1000))

    assert(user.payMoney(1000).get.maxMoney === 1000)
  }
}
