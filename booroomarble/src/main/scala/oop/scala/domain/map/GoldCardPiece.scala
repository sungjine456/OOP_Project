package oop.scala.domain.map

import oop.scala.domain.card.GoldCard
import oop.scala.domain.user.User

case class GoldCardPiece(card: GoldCard) extends Piece {
  override def visit(user: User): Unit = {
    card.publish(user)
  }
}
