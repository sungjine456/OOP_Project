package oop.scala.domain.money

/**
 * 돈을 가지고 있기 위한 클래스
 */
class Wallet {
  // 가지고 있는 총 금액
  def maxMoney: Int = {
    moneyBundle.moneyBundle.map(m => m._1.value * m._2).sum
  }

  // 각 지폐 별로 가지고 있는 갯수
  private val moneyBundle: MoneyBundle = new MoneyBundle

  // 현재 가지고 있는 지폐 중 제일 최고가인 지폐
  var topBankNote: Money = {
    null
  }

  /**
   * 지갑에 돈을 넣기 위한 함수
   * @param giveMoney 지갑에 넣을 금액
   */
  def put(giveMoney: Int) {
    addValueToMoneyBundle(giveMoney)
  }

  /**
   * 돈을 받았으면 거슬러 줘야한다.
   * @param giveMoney 내가 받은 금액
   * @param maxMoney 내가 받아야하는 총 금액
   * @return 거슬러 줘야하는 금액
   */
  def receive(giveMoney: Int, maxMoney: Int): MoneyBundle = {
    val backMoney = giveMoney - maxMoney

    if (backMoney < 0) {
      // 받아야 하는 돈보다 적게 받았을 때 처리
    }

    addValueToMoneyBundle(giveMoney)

    moneyBundle
  }

  /**
   * 돈을 줬으면 거슬러 받아야한다.
   * @param money 내가 줘야할 금액
   * @return 내가 주는 금액
   */
  def give(money: Int) {

  }

  private def addValueToMoneyBundle(giveMoney: Int) {
    var moneyValue = giveMoney
    for (key <- moneyBundle.keySet) {
      if (moneyValue / key.value > 0) {
        moneyBundle.put(key, moneyValue / key.value)
        moneyValue = moneyValue % key.value
      }
    }
  }
}
