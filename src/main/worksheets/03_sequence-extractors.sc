// def unappplySeq(object: S): Option[Seq[T]]
class Domain(val value: String)

object Domain {

}

def topLevelDomain1(domain: Domain): String = domain match {

}

def topLevelDomain2(domain: Domain): String = domain match {

}

def subDomain(domain: Domain): String = domain match {

}

topLevelDomain1(new Domain("business.epost.de"))
subDomain(new Domain("business.epost.de"))


// def unapplySeq(object: S): Option[(T1, ..., Tn, Seq[T])]

class WebSite(val url: String)

object WebSite {
}

def isSecure(ws: WebSite) = ws match {
}

println(isSecure(new WebSite("https://portal.epost.de")))