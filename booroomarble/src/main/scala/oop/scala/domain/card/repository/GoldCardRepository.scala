package oop.scala.domain.card.repository

import oop.scala.domain.card.GoldCard
import oop.scala.domain.card.event.{ DepositEvent, WithdrawEvent }
import oop.scala.domain.money._

object GoldCardRepository extends Repository[GoldCard] {
  override protected val cards: Seq[GoldCard] = Seq(GoldCard("천원 이득", new DepositEvent(ThousandWon)),
    GoldCard("오천원 이득", new DepositEvent(FiveThousandWon)), GoldCard("만원 이득", new DepositEvent(TenThousandWon)),
    GoldCard("오만원 이득", new DepositEvent(FiftyThousandWon)), GoldCard("십만원 이득", new DepositEvent(HundredThousandWon)),
    GoldCard("천원 손해", new WithdrawEvent(ThousandWon)), GoldCard("오천원 손해", new WithdrawEvent(FiveThousandWon)),
    GoldCard("만원 손해", new WithdrawEvent(TenThousandWon)), GoldCard("오만원 손해", new WithdrawEvent(FiftyThousandWon)),
    GoldCard("십만원 손해", new WithdrawEvent(HundredThousandWon)))
}
