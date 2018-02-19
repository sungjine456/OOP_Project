package oop.scala.domain.map

import oop.scala.domain.card.CountryCard
import oop.scala.domain.money.MoneyBundle
import oop.scala.domain.user.User

case class CountryPiece(card: CountryCard) extends Piece {
  var owner: Option[User] = None

  // TODO: 방법1. event와 비슷한 유형을 만들고 event를 반환하도록 하여 시스템에서 처리하도록 한다?
  override def visit(user: User): Unit = {
    owner match {
      case Some(o) if o == user => // TODO: 사용자가 건물 짓기를 원한다면 건물을 지을 수 있도록 해야한다.
        // 산다고 했을 때
        if(o.maxMoney >= card.edificeUpgradePrice){
          card.edificeUpgrade()
        }
      case Some(o) =>
        user.payMoney(MoneyBundle(card.totalTollFee)) match {
          case Some(m) => o.receive(m)
          case None => // TODO: 방문자는 파산했으며 파산에 대한 기능을 만들어야한다.
        }
      case None =>
        user.addCard(card)
        owner = Some(user)
    }
  }
}
