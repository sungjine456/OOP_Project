package oop.scala.domain.exception

class WrongPriceException(message: String = "잘못된 금액입니다.") extends RuntimeException(message)
