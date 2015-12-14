// def unappplySeq(object: S): Option[Seq[T]]
class Domain(val value: String)

object Domain {
  def unapplySeq(dom: Domain): Option[Seq[String]] =
    Some(dom.value.split("\\.").reverse)
}


def topLevelDomain(domain: Domain): String = domain match {
  case Domain(p1, rest @ _*) => s"tld: $p1, rest: ${rest.mkString(".")}"
  case _ => ""
}


def subDomain(domain: Domain): String = domain match {
  case Domain(_,_, sub) => sub
  case _ => ""
}

topLevelDomain(new Domain("business.epost.de"))
subDomain(new Domain("business.epost.de"))

// def unapplySeq(object: S): Option[(T1, ..., Tn, Seq[T])]

class WebSite(val url: String)

object WebSite {

  def unapplySeq(ws: WebSite): Option[(String, Seq[String])] = {

    val protocol = ws.url.split("://").head
    val domain: Seq[String] = ws.url.split("://").last.split("\\.")

    Some((protocol, domain))
  }
}

def isSecure(ws: WebSite) = ws match {
  case WebSite(protocol, domain @ _*) if protocol.endsWith("s") => s"${domain.mkString(".")} is secure!"
  case _ => "Please establish secure communication!"
}

println(isSecure(new WebSite("https://portal.epost.de")))