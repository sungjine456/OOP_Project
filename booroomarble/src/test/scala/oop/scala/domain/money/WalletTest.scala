package oop.scala.domain.money

import org.scalatest.FlatSpec

class WalletTest extends FlatSpec {
  "maxMoney" should "is the sum of all money in wallet" in {
    val wallet = new Wallet

    assert(wallet.maxMoney === 0)

    wallet.put(6000)

    assert(wallet.maxMoney === 6000)

    wallet.put(70000)

    assert(wallet.maxMoney === 76000)

    wallet.put(706000)

    assert(wallet.maxMoney === 782000)
  }

  "put" should "divide the number into a Money type." in {
    var wallet = new Wallet
    var put = wallet.receive(1000, 1000)

    assert(put.get(ThousandWon) === 1)

    put = wallet.receive(10000, 1000)

    assert(put.get(TenThousandWon) === 1)

    put = wallet.receive(100000, 1000)

    assert(put.get(HundredThousandWon) === 1)

    put = wallet.receive(5000, 1000)

    assert(put.get(FiveThousandWon) === 1)

    put = wallet.receive(50000, 1000)

    assert(put.get(FiftyThousandWon) === 1)

    put = wallet.receive(500000, 1000)

    assert(put.get(FiveHundredThousandWon) === 1)

    wallet = new Wallet
    put = wallet.receive(774000, 1000)

    assert(put.get(ThousandWon) === 4)
    assert(put.get(FiveThousandWon) === 0)
    assert(put.get(TenThousandWon) === 2)
    assert(put.get(FiftyThousandWon) === 1)
    assert(put.get(HundredThousandWon) === 2)
    assert(put.get(FiveHundredThousandWon) === 1)
  }
}
