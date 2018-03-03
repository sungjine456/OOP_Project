package oop.scala.domain.system

import oop.scala.domain.dice.Dice
import oop.scala.domain.map.{ Map, Piece }
import oop.scala.domain.user.User

class System(userCount: Int) {
  private val map = Map
  private val users: Seq[User] = Nil
  private var activeIndex = 0

  initialized()

  def initialized(): Unit = {
    for (i <- 0 until userCount) {
      users :+ User(s"$i 번 유저")
    }
  }

  def throwDice: Unit = {
    val cast: Int = Dice.cast

    val user: User = users(activeIndex)
    val piece: Piece = map.move(cast, user)

    piece.visit(user)

    changeActiveIndex
  }

  private def changeActiveIndex: Unit = {
    activeIndex = if (activeIndex + 1 >= userCount) 0 else activeIndex + 1
  }
}
