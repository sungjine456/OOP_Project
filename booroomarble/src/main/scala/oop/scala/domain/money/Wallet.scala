package oop.scala.domain.money

class Wallet {
  // 가지고 있는 총 금액
  var maxMoney: Int = 0

  // 각 지폐 별로 가지고 있는 갯수
  private val wallet: Map[Money, Int] = Map (
    ThousandWon -> 0,
    FiveThousandWon -> 0,
    TenThousandWon -> 0,
    FiftyThousandWon -> 0,
    HundredThousandWon -> 0,
    FiveHundredThousandWon -> 0
  )

  // 현재 가지고 있는 지폐 중 제일 최고가인 지폐
  var topBankNote: Money = {
    null
  }

  /**
   * 돈을 받았으면 거슬러 줘야한다.
   * @param wallet 내가 받은 금액
   * @return 거슬러 줘야하는 금액
   */
  def put(wallet: Wallet): Int = {

    0
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
