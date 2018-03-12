package oop.scala.domain.edifice

// 건물은 순차적으로 건설된다는 가정하에 설계
// TODO: 후일 턴에 제한을 두지만 빌라나 호텔을 넘어 빌딩을 바로 건설하 수 있도록 수정할 필요가 있다.
trait Edifice {
  // 가격
  val price: Int
  // 통행료
  val tollFee: Int
  // 인상률
  protected val increaseRate: Int

  def upgrade: Option[Edifice]
}
