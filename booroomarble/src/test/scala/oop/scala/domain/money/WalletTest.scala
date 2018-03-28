package oop.scala.domain.money

import org.scalatest.FlatSpec

class WalletTest extends FlatSpec {
  "maxMoney" should "is the sum of all money in wallet" in {
    val wallet = new Wallet

    assert(wallet.maxMoney === 0)

    wallet.put(MoneyBundle(6000))

    assert(wallet.maxMoney === 6000)

    wallet.put(MoneyBundle(70000))

    assert(wallet.maxMoney === 76000)

    wallet.put(MoneyBundle(706000))

    assert(wallet.maxMoney === 782000)
  }

  "put" should "divide the number into a Money type." in {
    var wallet = new Wallet

    assert(wallet.receive(MoneyBundle(1000), MoneyBundle(10000)) === None)
    assert(wallet.topBankNote === None)

    wallet.receive(MoneyBundle(1000), MoneyBundle(1000)).get

    assert(wallet.topBankNote === Option(ThousandWon))
    assert(wallet.maxMoney === 1000)

    wallet.receive(MoneyBundle(5000), MoneyBundle(5000)).get

    assert(wallet.topBankNote === Option(FiveThousandWon))
    assert(wallet.maxMoney === 6000)

    wallet.receive(MoneyBundle(10000), MoneyBundle(10000)).get

    assert(wallet.topBankNote === Option(TenThousandWon))
    assert(wallet.maxMoney === 16000)

    wallet.receive(MoneyBundle(50000), MoneyBundle(50000)).get

    assert(wallet.topBankNote === Option(FiftyThousandWon))
    assert(wallet.maxMoney === 66000)

    wallet.receive(MoneyBundle(100000), MoneyBundle(100000)).get

    assert(wallet.topBankNote === Option(HundredThousandWon))
    assert(wallet.maxMoney === 166000)

    wallet.receive(MoneyBundle(500000), MoneyBundle(500000)).get

    assert(wallet.topBankNote === Option(FiveHundredThousandWon))
    assert(wallet.maxMoney === 666000)

    wallet = new Wallet
    wallet.receive(MoneyBundle(774000), MoneyBundle(774000)).get

    assert(wallet.topBankNote === Option(FiveHundredThousandWon))
    assert(wallet.maxMoney === 774000)
  }

  "topBankNote" should "have the highest banknote" in {
    val wallet = new Wallet
    wallet.put(MoneyBundle(1000))

    assert(wallet.topBankNote === Option(ThousandWon))

    wallet.put(MoneyBundle(5000))

    assert(wallet.topBankNote === Option(FiveThousandWon))

    wallet.put(MoneyBundle(10000))

    assert(wallet.topBankNote === Option(TenThousandWon))

    wallet.put(MoneyBundle(50000))

    assert(wallet.topBankNote === Option(FiftyThousandWon))

    wallet.put(MoneyBundle(100000))

    assert(wallet.topBankNote === Option(HundredThousandWon))

    wallet.put(MoneyBundle(500000))

    assert(wallet.topBankNote === Option(FiveHundredThousandWon))
  }

  "give" should "get money out of moneyBundle" in {
    val wallet = new Wallet

    wallet.put(MoneyBundle(600000))
    val bundle: MoneyBundle = wallet.give(MoneyBundle(600000))

    assert(wallet.maxMoney === 0)
    assert(bundle.maxMoney === 600000)
  }

  "receive" should "not give money, If receive as money as should receive" in {
    val wallet = new Wallet

    assert(wallet.receive(MoneyBundle(), MoneyBundle()).get.maxMoney === 0)
    assert(wallet.maxMoney === 0)
  }

  it should "give money, If receive more money than receive" in {
    val wallet = new Wallet

    assert(wallet.receive(MoneyBundle(1000), MoneyBundle()).get.maxMoney === 1000)
    assert(wallet.maxMoney === 0)
  }

  it should "give money, If receive less money than receive" in {
    val wallet = new Wallet

    assert(wallet.receive(MoneyBundle(0), MoneyBundle(1000)) === None)
  }

  it should "give money after changing money" in {
    val wallet = new Wallet

    wallet.put(MoneyBundle(10000))

    assert(wallet.receive(MoneyBundle(10000), MoneyBundle(5000)).get.maxMoney === 5000)
    assert(wallet.maxMoney === 15000)
  }
}
