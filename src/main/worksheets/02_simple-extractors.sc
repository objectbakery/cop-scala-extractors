trait User {
  val name: String
  val epbAddress: String
}

class PkUser(val name: String, val epbAddress: String) extends User
class GkUser(val name: String, val epbAddress: String) extends User

// def unapply(object: S): Option[T]

object PkUser {
  def unapply(user: PkUser): Option[String] = Some(user.name)
}

object GkUser {
  def unapply(user: GkUser): Option[String] = Some(user.name)
}

val user: User = new PkUser("Günther Schwakowiak", "gs@epost.de")

user match {
  case PkUser(name) => s"$name! Upgrade to premium NOW!"
  case GkUser(name) => s"Welcome $name. How may I serve you?"
}


// def unapply(object: S): Option[(T1, ..., Tn)]

class PkUser2(val name: String, val epbAddress: String) extends User
class GkUser2(val name: String, val epbAddress: String) extends User

object PkUser2 {
  def unapply(user: PkUser2): Option[(String, String)] = Some((user.name, user.epbAddress))
}

object GkUser2 {
  def unapply(user: GkUser2): Option[(String, String)] = Some((user.name, user.epbAddress))
}

val user2: User = new GkUser2("James Bond", "james.bond@mi6.epost.de")

user2 match {
  case PkUser2(name, epba) => s"$name! Upgrade to premium NOW!"
  case GkUser2(name, epba) => s"Welcome $name. Your epost addess is $epba"
}

// def unapply(object: S): Boolean

object MissingEpbAddress {
  def unapply(user: PkUser2): Boolean = user.epbAddress.isEmpty
}

val user3: User = new PkUser2("Günther Schwakowiak", "")

user3 match {
  case user @ MissingEpbAddress() => s"Alert. User ${user.name} has no EPB address!"
  case _ => "User data complete"
}
