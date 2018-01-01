package oop.scala.domain.map
import oop.scala.domain.money.MoneyBundle
import oop.scala.domain.user.User

case class StartPiece() extends Piece {
  val money: MoneyBundle = new MoneyBundle(300000)

  override def visit(user: User): Unit = {
    user.receive(money)
  }
}
