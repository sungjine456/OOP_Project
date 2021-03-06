package oop.scala.domain.map

import oop.scala.domain.card.CardRepository
import oop.scala.domain.user.User

object Map {
  // TODO: 나라를 가지고 있는 칸의 경우 순서대로 나라의 땅값이 커지도록 수정할 필요가 있다.
  // TODO: 나라를 가지고 있는 칸의 그룹 기능 추가
  private val map: Seq[Piece] = Seq(StartPiece())
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
