package oop.scala.domain.card.event

import oop.scala.domain.money.Money

trait MoneyEvent extends Event {
  protected val range: Money
}
