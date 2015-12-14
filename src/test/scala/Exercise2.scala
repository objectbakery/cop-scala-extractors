import org.scalatest.FlatSpec

import scala.None

/**
  * MyNotes.txt => MyNotes txt
  */
object FileName {
  def unapply(name: String): Option[(String, String)] = {
    val parts = name.split("\\.")
    if (parts.length == 2) Some(parts(0), parts(1)) else None
  }
}

/**
  * /home/anyuser/development/scala/ => scala development anyuser home
  */
object Path {
  def unapplySeq(path: String): Option[Seq[String]] =
    Some(path.split("/").reverse.dropRight(1))
}

class Exercise2 extends FlatSpec{

  /**
    * /home/anyuser/git/scala-foo/scala-cop-extractors/README.txt => README
    */
  def fileFromAbsolutePath(path: String) = path match {
    case Path(FileName(name, _), _*) => name
    case _ => "No match"
  }


  "file name" should "match correct name and extension" in {
    val matchResult = "README.txt" match {
      case FileName(name, extension) => "File matches " + name + " of filetype " + extension
      case _ => "No match"
    }
    assert(matchResult == "File matches README of filetype txt")
  }

  "file path elements" should "should match correct start and end" in {

    val matchResult = "/home/anyuser/git/scala-foo/scala-cop-extractors" match {
      case Path(first, _, _, _, last) => "Path starts with " + first + " and ends with " + last
      case _ => "No match"
    }
    assert(matchResult == "Path starts with scala-cop-extractors and ends with home")
  }

  "file name in full path" should "match file name" in {
    val matchResult = fileFromAbsolutePath("/home/anyuser/git/scala-foo/scala-cop-extractors/README.txt")
    assert(matchResult == "README")
  }

}
