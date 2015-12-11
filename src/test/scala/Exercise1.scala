import org.scalatest.FlatSpec

import scala.None

trait User {
  def name: String
  def epbAddress: String
}

case class PkUser(name: String, epbAddress: String) extends User
case class GkUser(name: String, epbAddress: String) extends User

object CompanyAddress {

  /**
    * TODO: Implement User => (name, company domain name, epost domain name)
    */
  def unapply(user: User): Option[(String, String, String)] = ???
}

object PrivateAddress {

  /**
    * TODO: Implement User => (name, epost domain name)
    */
  def unapply(user: User): Option[(String, String)] = ???
}

class Exercise1 extends FlatSpec{

  def epbParts(user: User): (String, String, String) = user match {
    case CompanyAddress(name, domain, epb) => (name, domain, epb)
    case PrivateAddress(name, epb) => (name, "", epb)
  }

  "parts of GK address" should "be name, company sub domain and epost domain  as sum" in {

    val (name, companyDomain, epbDomain) = epbParts(new GkUser("John Doe", "john.doe@company.epost.de"))

    assert(name == "john.doe")
    assert(companyDomain == "company")
    assert(epbDomain == "epost.de")
  }

  "parts of PK address" should "be name and epost domain" in {
    val (name, companyDomain, epbDomain) = epbParts(new PkUser("John Doe", "john.doe@epost.de"))

    assert(name == "john.doe")
    assert(companyDomain.isEmpty)
    assert(epbDomain == "epost.de")
  }

}
