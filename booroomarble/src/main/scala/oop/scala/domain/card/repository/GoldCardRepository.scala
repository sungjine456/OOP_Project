package oop.scala.domain.card.repository

import oop.scala.domain.card.GoldCard
import oop.scala.domain.card.event.{ ReceiveMoneyEvent, PayMoneyEvent }
import oop.scala.domain.money._

object GoldCardRepository extends Repository[GoldCard] {
  override protected val cards: Seq[GoldCard] = Seq(GoldCard("천원 이득", new ReceiveMoneyEvent(ThousandWon)),
    GoldCard("오천원 이득", new ReceiveMoneyEvent(FiveThousandWon)), GoldCard("만원 이득", new ReceiveMoneyEvent(TenThousandWon)),
    GoldCard("오만원 이득", new ReceiveMoneyEvent(FiftyThousandWon)), GoldCard("십만원 이득", new ReceiveMoneyEvent(HundredThousandWon)),
    GoldCard("천원 손해", new PayMoneyEvent(ThousandWon)), GoldCard("오천원 손해", new PayMoneyEvent(FiveThousandWon)),
    GoldCard("만원 손해", new PayMoneyEvent(TenThousandWon)), GoldCard("오만원 손해", new PayMoneyEvent(FiftyThousandWon)),
    GoldCard("십만원 손해", new PayMoneyEvent(HundredThousandWon)))
}
