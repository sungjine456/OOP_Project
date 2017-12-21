package oop.scala.domain.money

import org.scalatest.FlatSpec

class WalletTest extends FlatSpec {
  "maxMoney" should "is the sum of all money in wallet" in {

  }

  "put" should "divide the number into a Money type." in {
    val wallet = new Wallet

    val put = wallet.put(1000, 1000)

    assert(put.moneyBundle(ThousandWon) === 1)
  }
}
