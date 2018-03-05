package oop.scala.domain.system

import oop.scala.domain.dice.Dice
import oop.scala.domain.map.{ Map, Piece }
import oop.scala.domain.user.User

class System(userCount: Int) {
  private val map = Map
  private val users: Seq[User] = Nil
  private var activeIndex = 0

  initialized()

  private def initialized(): Unit = {
    for (i <- 0 until userCount) {
      users :+ User(s"$i 번 유저")
    }
  }

  private def activeUser: User = users(activeIndex)

  def throwDice: Unit = {
    val cast: Int = Dice.cast

    map.move(cast, activeUser)

    changeActiveIndex
  }

  //TODO: 나중에 골드 카드나 우주선을 통해 사용자가 원하는 혹은 골드 카드가 지정한 장소로 이동하기 위한 메소드
  def move(piece: Piece): Unit = {
    val piecePosition = map.getPosition(piece)

    val moveTo = piecePosition - activeUser.position

    map.move(moveTo, activeUser)

    changeActiveIndex
  }

  private def changeActiveIndex: Unit = {
    activeIndex = if (activeIndex > userCount) 0 else activeIndex + 1
  }
}
