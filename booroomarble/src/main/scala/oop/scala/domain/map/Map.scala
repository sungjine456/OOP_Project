package oop.scala.domain.map

object Map {
  // 시작 칸
  // 땅 칸
  // 황금 카드를 뽑을 수 있는 칸
  // 각각의 칸을 담고 있을 하나의 리스트를 가진다.
  // TODO: 원형 연결 리스트로 변경해야한다.
  val map: List[Piece] = Nil

  def piece(index: Int): Piece = {
    map(index)
  }
}
