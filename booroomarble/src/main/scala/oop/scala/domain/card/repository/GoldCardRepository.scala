package oop.scala.domain.card.repository

import oop.scala.domain.card.GoldCard
import oop.scala.domain.card.event._
import oop.scala.domain.money._

object GoldCardRepository extends Repository[GoldCard] {
  def apply(index: Int): GoldCard = get(index)

  override protected val cards: Seq[GoldCard] = Seq(GoldCard("천원 이득", new ReceiveMoneyFromBankEvent(ThousandWon)),
    GoldCard("오천원 이득", new ReceiveMoneyFromBankEvent(FiveThousandWon)), GoldCard("만원 이득", new ReceiveMoneyFromBankEvent(TenThousandWon)),
    GoldCard("오만원 이득", new ReceiveMoneyFromBankEvent(FiftyThousandWon)), GoldCard("십만원 이득", new ReceiveMoneyFromBankEvent(HundredThousandWon)),
    GoldCard("천원 손해", new PayMoneyToBankEvent(ThousandWon)), GoldCard("오천원 손해", new PayMoneyToBankEvent(FiveThousandWon)),
    GoldCard("만원 손해", new PayMoneyToBankEvent(TenThousandWon)), GoldCard("오만원 손해", new PayMoneyToBankEvent(FiftyThousandWon)),
    GoldCard("십만원 손해", new PayMoneyToBankEvent(HundredThousandWon)))
}
