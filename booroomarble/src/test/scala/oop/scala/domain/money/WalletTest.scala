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

    assert(wallet.receive(MoneyBundle(1000), 10000) === None)
    assert(wallet.topBankNote === None)

    wallet.receive(MoneyBundle(1000), 1000).get

    assert(wallet.topBankNote === Option(ThousandWon))
    assert(wallet.maxMoney === 1000)

    wallet.receive(MoneyBundle(5000), 5000).get

    assert(wallet.topBankNote === Option(FiveThousandWon))
    assert(wallet.maxMoney === 6000)

    wallet.receive(MoneyBundle(10000), 10000).get

    assert(wallet.topBankNote === Option(TenThousandWon))
    assert(wallet.maxMoney === 16000)

    wallet.receive(MoneyBundle(50000), 50000).get

    assert(wallet.topBankNote === Option(FiftyThousandWon))
    assert(wallet.maxMoney === 66000)

    wallet.receive(MoneyBundle(100000), 100000).get

    assert(wallet.topBankNote === Option(HundredThousandWon))
    assert(wallet.maxMoney === 166000)

    wallet.receive(MoneyBundle(500000), 500000).get

    assert(wallet.topBankNote === Option(FiveHundredThousandWon))
    assert(wallet.maxMoney === 666000)

    wallet = new Wallet
    wallet.receive(MoneyBundle(774000), 774000).get

    assert(wallet.topBankNote === Option(FiveHundredThousandWon))
    assert(wallet.maxMoney === 774000)
  }

  "topBankNote" should "have the highest banknote" in {
    val wallet = new Wallet
    wallet.put(1000)

    assert(wallet.topBankNote === Option(ThousandWon))

    wallet.put(5000)

    assert(wallet.topBankNote === Option(FiveThousandWon))

    wallet.put(10000)

    assert(wallet.topBankNote === Option(TenThousandWon))

    wallet.put(50000)

    assert(wallet.topBankNote === Option(FiftyThousandWon))

    wallet.put(100000)

    assert(wallet.topBankNote === Option(HundredThousandWon))

    wallet.put(500000)

    assert(wallet.topBankNote === Option(FiveHundredThousandWon))
  }

  "give" should "give money and get change" in {
    val wallet = new Wallet
    val otherWallet = new Wallet

    wallet.put(600000)
    wallet.give(600000, otherWallet)

    assert(wallet.maxMoney === 0)
    assert(otherWallet.maxMoney === 600000)
  }
}
