package oop.scala.domain.system

import scala.annotation.tailrec

import oop.scala.domain.dice.Dice
import oop.scala.domain.map.Piece
import oop.scala.domain.user.User

class System(userCount: Int) {
  private val map = oop.scala.domain.map.Map
  private var users: Seq[User] = Nil
  private var usersPosition: Map[User, Int] = Map.empty
  private var activeIndex = 0

  initialized()

  private def initialized(): Unit = {
    for (i <- 0 until userCount) users :+ User(s"$i 번 유저")
  }

  @tailrec
  private def activeUser: User = {
    if (users(activeIndex).finishPlaying) {
      dropUser(activeIndex)

      activeUser
    } else users(activeIndex)
  }

  def throwDice: Unit = {
    val cast: Int = Dice.cast
    val user = activeUser

    usersPosition + (user -> (usersPosition(user) + cast))

    map.moveTo(usersPosition(user), user)

    changeActiveIndex
  }

  def move(piece: Piece): Unit = {
    val user = activeUser
    val piecePosition = map.moveTo(piece, user)

    val movedPosition = map.MaxMapSize + piecePosition - usersPosition(user)

    usersPosition + (user -> movedPosition)

    changeActiveIndex
  }

  private def changeActiveIndex: Unit = {
    activeIndex = if (activeIndex > userCount) 0 else activeIndex + 1
  }

  private def dropUser(index: Int) {
    val user: User = users(index)
    usersPosition -= user
    users = users.filter(u => user != u)
  }
}
