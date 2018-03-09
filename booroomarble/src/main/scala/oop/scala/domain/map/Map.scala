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
  val MaxMapSize = 12

  initialized()

  private def initialized(): Unit = {
    for (i <- 0 until MaxMapSize) {
      map :+ CountryPiece(CardRepository.getCountryCard(i))
      if (i != 0 && i % 3 == 0) {
        map :+ GoldCardPiece(CardRepository.getGoldCard(i / 3 - 1))
      }
    }
  }

  def moveTo(movePosition: Int, user: User): Unit = {
    val moveTo = if (movePosition > MaxMapSize) movePosition - MaxMapSize else movePosition

    map(moveTo).visit(user)
  }

  def moveTo(piece: Piece, user: User): Int = {
    if(!map.contains(piece)){
      throw new IllegalArgumentException("맵에 없는 곳입니다.")
    }

    piece.visit(user)

    map.indexOf(piece)
  }
}
