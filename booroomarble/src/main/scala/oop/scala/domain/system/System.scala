package oop.scala.domain.system

import scala.annotation.tailrec

import oop.scala.domain.dice.Dice
import oop.scala.domain.map.Piece
import oop.scala.domain.user.User

import scala.collection.mutable.Map

class System(userCount: Int) {
  private val map = oop.scala.domain.map.Map
  private var users: Seq[User] = Nil
  private val usersPosition: Map[User, Int] = Map.empty
  private var activeIndex = 0

  initialized()

  private def initialized(): Unit = {
    for (i <- 0 until userCount) {
      users :+ User(s"$i 번 유저")
    }
  }

  @tailrec
  private def activeUser: User = {
    if(users(activeIndex).finishPlaying) {
      dropUser(activeIndex)

      activeUser
    } else users(activeIndex)
  }

  def throwDice: Unit = {
    val cast: Int = Dice.cast

    usersPosition(activeUser) = usersPosition(activeUser) + cast

    map.moveTo(usersPosition(activeUser), activeUser)

    changeActiveIndex
  }

  //TODO: 나중에 골드 카드나 우주선을 통해 사용자가 원하는 혹은 골드 카드가 지정한 장소로 이동하기 위한 메소드
  def move(piece: Piece): Unit = {
    val piecePosition = map.moveTo(piece, activeUser)

    val movedPosition = map.MaxMapSize + piecePosition - usersPosition(activeUser)

    usersPosition(activeUser) = movedPosition

    changeActiveIndex
  }

  private def changeActiveIndex: Unit = {
    activeIndex = if (activeIndex > userCount) 0 else activeIndex + 1
  }

  private def dropUser(index: Int) {
    val user: User = users(index)
    usersPosition - user
    users = users.filter(u => user != u)
  }
}
