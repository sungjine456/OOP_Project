package oop.scala.domain.card.repository

import oop.scala.domain.card.GoldCard
import oop.scala.domain.card.event._
import oop.scala.domain.money._

object GoldCardRepository extends Repository[GoldCard] {
  def apply(index: Int): GoldCard = get(index)

  override protected val cards: Seq[GoldCard] = Seq(GoldCard("천원 이득", ReceiveMoneyFromBankEvent(ThousandWon)),
    GoldCard("오천원 이득", ReceiveMoneyFromBankEvent(FiveThousandWon)), GoldCard("만원 이득", ReceiveMoneyFromBankEvent(TenThousandWon)),
    GoldCard("오만원 이득", ReceiveMoneyFromBankEvent(FiftyThousandWon)), GoldCard("십만원 이득", ReceiveMoneyFromBankEvent(HundredThousandWon)),
    GoldCard("천원 손해", PayMoneyToBankEvent(ThousandWon)), GoldCard("오천원 손해", PayMoneyToBankEvent(FiveThousandWon)),
    GoldCard("만원 손해", PayMoneyToBankEvent(TenThousandWon)), GoldCard("오만원 손해", PayMoneyToBankEvent(FiftyThousandWon)),
    GoldCard("십만원 손해", PayMoneyToBankEvent(HundredThousandWon)))
}
