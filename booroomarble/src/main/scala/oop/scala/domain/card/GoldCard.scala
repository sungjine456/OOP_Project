package oop.scala.domain.card

import oop.scala.domain.card.event.Event
import oop.scala.domain.user.User

case class GoldCard(name: String, event: Event) extends Card {
  def publish(user: User): Unit = {
    event.publish(user)
  }
}
