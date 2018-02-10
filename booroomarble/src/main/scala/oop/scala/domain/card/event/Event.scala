package oop.scala.domain.card.event

import oop.scala.domain.user.User

trait Event {
  def publish(user: User): Unit
}
