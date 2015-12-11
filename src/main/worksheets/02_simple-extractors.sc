trait User {
  val name: String
  val epbAddress: String
}

class PkUser(val name: String, val epbAddress: String) extends User
class GkUser(val name: String, val epbAddress: String) extends User

// def unapply(object: S): Option[T]


// def unapply(object: S): Option[(T1, ..., Tn)]

class PkUser2(val name: String, val epbAddress: String) extends User
class GkUser2(val name: String, val epbAddress: String) extends User


// def unapply(object: S): Boolean

