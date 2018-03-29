package oop.scala.domain.card

import oop.scala.domain.card.repository.{ CountryCardRepository, GoldCardRepository }

object CardRepository {
  def getGoldCard(index: Int): GoldCard = GoldCardRepository(index)

  def getGoldCardSeq(count: Int): Seq[GoldCard] = GoldCardRepository.getSeq(count)

  def getCountryCard(index: Int): CountryCard = CountryCardRepository(index)

  def getCountryCardSeq(count: Int): Seq[CountryCard] = CountryCardRepository.getSeq(count)
}
