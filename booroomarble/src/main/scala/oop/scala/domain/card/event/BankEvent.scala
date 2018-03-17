package oop.scala.domain.card.event

import oop.scala.domain.bank.Bank
import oop.scala.domain.money.MoneyBundle
import oop.scala.domain.user.User

trait BankEvent extends Event {
  val bank = Bank
}
