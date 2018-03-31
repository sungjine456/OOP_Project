package oop.scala.domain.card.repository

import oop.scala.domain.card.CountryCard

object CountryCardRepository extends Repository[CountryCard] {
  def apply(index: Int): CountryCard = get(index)

  override protected val cards: Seq[CountryCard] = Seq(CountryCard("서울", 1000),
    CountryCard("대전", 1000), CountryCard("수원", 1000), CountryCard("거창", 1000),
    CountryCard("대구", 1000), CountryCard("광명", 1000), CountryCard("무주", 1000),
    CountryCard("부산", 1000), CountryCard("파주", 1000), CountryCard("화성", 1000),
    CountryCard("울산", 1000), CountryCard("부안", 1000), CountryCard("군산", 1000),
    CountryCard("인천", 1000), CountryCard("나주", 1000), CountryCard("안성", 1000)
  )
}
