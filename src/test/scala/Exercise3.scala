import org.scalatest.FlatSpec

case class Person(name: String, residence: Seq[City])
case class City(name: String)

object LivesIn {

  // TODO: implement sequencial unapply
  def unapply(person: Person): Option[Seq[String]] =
    Some(
      for(city <- person.residence)
        yield city.name
    )
}

class SequenceContains(value: String) {

  // TODO: implement boolean unapply
  def unapply(strings: Seq[String]): Boolean =
    strings.contains(value)
}

class Exercise3 extends FlatSpec{

  val people =
    List(
      Person("Peter", List(City("Springfield"))),
      Person("Paul" , List(City("Warschau"))),
      Person("Marry", List(City("Berlin"), City("München"))),
      Person("Bob"  , List(City("Berlin")))
    )

  val Berlin = new SequenceContains("Berlin")

  def peopleInBerlin = people collect {
    case person @ LivesIn(Berlin()) => person.name
  }

  "people living in Berlin" should "be 2" in {

    assert(peopleInBerlin.length == 2)
  }

  "people living Berlin" should "be Marry and Bob" in {

    assert(peopleInBerlin.head == "Marry")
    assert(peopleInBerlin.last == "Bob")
  }
}
