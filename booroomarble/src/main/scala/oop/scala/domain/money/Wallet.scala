package oop.scala.domain.money

/**
 * 돈을 가지고 있기 위한 클래스
 */
class Wallet {
  // 가지고 있는 총 금액
  var maxMoney: Int = 0

  // 각 지폐 별로 가지고 있는 갯수
  private val moneyBundle: MoneyBundle = new MoneyBundle

  // 현재 가지고 있는 지폐 중 제일 최고가인 지폐
  var topBankNote: Money = {
    null
  }

  /**
   * 돈을 받았으면 거슬러 줘야한다.
   * @param giveMoney 내가 받은 금액
   * @param maxMoney 내가 받아야하는 총 금액
   * @return 거슬러 줘야하는 금액
   */
  def put(giveMoney: Int, maxMoney: Int): MoneyBundle = {
    var moneyValue = giveMoney
    
    while (moneyValue > 0) {
      if (moneyValue / 500000 > 0) {
        moneyBundle.put(FiveHundredThousandWon, moneyValue / 500000)
        moneyValue = moneyValue % 500000
      } else if (moneyValue / 100000 > 0) {
        moneyBundle.put(HundredThousandWon, moneyValue / 100000)
        moneyValue = moneyValue % 100000
      } else if (moneyValue / 50000 > 0) {
        moneyBundle.put(FiftyThousandWon, moneyValue / 50000)
        moneyValue = moneyValue % 50000
      } else if (moneyValue / 10000 > 0) {
        moneyBundle.put(TenThousandWon, moneyValue / 10000)
        moneyValue = moneyValue % 10000
      } else if (moneyValue / 5000 > 0) {
        moneyBundle.put(FiveThousandWon, moneyValue / 5000)
        moneyValue = moneyValue % 5000
      } else if (moneyValue / 1000 > 0) {
        moneyBundle.put(ThousandWon, moneyValue / 1000)
        moneyValue = moneyValue % 1000
      }
    }
    moneyBundle
  }

  /**
   * 돈을 줬으면 거슬러 받아야한다.
   * @param wallet 내가 줘야할 금액
   * @return 내가 주는 금액
   */
  def get(wallet: Wallet): Int = {
    0
  }
}
