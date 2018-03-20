package oop.scala.domain.money

/**
 * 돈을 가지고 있기 위한 클래스
 */
class Wallet {
  private val moneyBundle: MoneyBundle = new MoneyBundle

  def maxMoney: Int = moneyBundle.maxMoney

  def topBankNote: Option[Money] = {
    moneyBundle.keySet.find(key => moneyBundle.get(key) > 0)
  }

  /**
   * 지갑에 돈을 넣기 위한 함수
   * @param bundle 지갑에 넣을 금액
   */
  def put(bundle: MoneyBundle): Unit = moneyBundle.put(bundle)

  /**
   * 돈을 받았으면 거슬러 줘야한다.
   * @param receiveMoney 내가 받은 금액
   * @param maxMoney 내가 받아야하는 총 금액
   * @return 거슬러 줘야하는 금액
   */
  def receive(receiveMoney: MoneyBundle, maxMoney: MoneyBundle): Option[MoneyBundle] = {
    val backMoney = receiveMoney.maxMoney - maxMoney.maxMoney

    // 받을 금액보다 조금 받았을 때
    if (backMoney < 0) {
      return None
    }

    moneyBundle.put(receiveMoney)

    if (backMoney == 0) Some(MoneyBundle.apply)
    else Option(MoneyCalculation.minusValueToMoneyBundle(MoneyBundle(backMoney), moneyBundle))
  }

  /**
   * 돈을 줘야하는 금액만큼 돈 뭉치에 돈을 넣어 돈 뭉치를 준다.
   * @param giveMoney 내가 줘야할 금액
   * @return 내가 주는 돈
   */
  def give(giveMoney: MoneyBundle): MoneyBundle = {
    MoneyCalculation.minusValueToMoneyBundle(giveMoney, moneyBundle)
  }

  def total: MoneyBundle = moneyBundle
}
