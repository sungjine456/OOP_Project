package oop.scala.domain.card

import oop.scala.domain.card.event.{ DepositEvent, WithdrawEvent }
import oop.scala.domain.money.ThousandWon

object CardRepository {
  private val goldCardRepository = {
    val list: List[GoldCard] = List(GoldCard("천원 이득", new DepositEvent(ThousandWon)))
    list :+ GoldCard("천원 손해", new WithdrawEvent(ThousandWon))
  }

  def getGoldCardList: List[GoldCard] = {
    goldCardRepository
  }
}
