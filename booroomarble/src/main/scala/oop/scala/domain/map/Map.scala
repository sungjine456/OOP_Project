package oop.scala.domain.map

import oop.scala.domain.card.CardRepository
import oop.scala.domain.user.User

object Map {
  // 시작 칸
  // 땅 칸
  // 황금 카드를 뽑을 수 있는 칸
  // 각각의 칸을 담고 있을 하나의 리스트를 가진다.
  // 리스트로 하되 리스트의 크기를 넘어가면 0으로 돌아가게...
  private val map: Seq[Piece] = Seq(new StartPiece)
  private val MaxMapSize = 12

  initialized()

  def initialized(): Unit = {
    for (i <- 0 until MaxMapSize) {
      map :+ CountryPiece(CardRepository.getCountryCard(i))
      if (i != 0 && i % 3 == 0) {
        map :+ GoldCardPiece(CardRepository.getGoldCard(i / 3 - 1))
      }
    }
  }

  def move(moveCount: Int, user: User): Unit = {
    val position = moveCount + user.position

    val moveTo = if (position > MaxMapSize) position - MaxMapSize else position

    user.position = moveTo

    map(moveTo).visit(user)
  }

  def getPosition(piece: Piece): Int = {
    map.indexOf(piece)
  }
}
