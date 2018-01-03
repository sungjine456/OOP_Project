package oop.scala.domain.map

import oop.scala.domain.user.User
import org.scalatest.FlatSpec

class StartPieceTest extends FlatSpec {
  "visit()" should "make people receive money" in {
    val user = User("admin")

    assert(user.maxMoney === 0)

    val piece = StartPiece()
    piece.visit(user)

    assert(user.maxMoney === 300000)
  }
}
