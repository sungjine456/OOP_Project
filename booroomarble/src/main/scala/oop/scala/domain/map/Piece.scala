package oop.scala.domain.map

import oop.scala.domain.user.User

trait Piece {
  def visit(user: User): Unit
}
