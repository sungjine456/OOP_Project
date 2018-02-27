package oop.scala.domain.card.repository

import oop.scala.domain.card.Card

trait Repository[T <: Card] {
  protected val cards: Seq[T]

  def get(index: Int): T = cards(index)

  def getSeq(count: Int): Seq[T] = cards.take(count)
}
