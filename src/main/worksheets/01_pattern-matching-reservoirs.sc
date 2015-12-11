
//// pattern matching expression  -------------------------------

// very simple
def x = 50

def result = if(x==100) "bulls eye!" else "meh!"
println(result)

x match {
  case 100 => println("bulls eye!")
  case _  => println("meh!")
}

// common
case class Player(name: String, score: Int)

def message(player: Player) = player match {
  case Player(_, score) if score > 1000 => "Get a job, dude!"
  case Player(name, _) => s"Hey $name be my game boy!"
}

println(message(Player("Rookie", 10)))
println(message(Player("Pro", 10000)))

// sequences
val seq = 2 :: 4 :: 6 :: 8 ::  Nil
seq match {
  case List(a, b) => "two elements"
  case List(a, b, c) => "three elements"
  case _ => "more than three elements"
}

//// value definitions ---------------------------------------

// return value
def currentPlayer: Player = Player("Rookie", 10)

val Player(_, score) = currentPlayer

println(s"current player has $score points")

// sequences

def highScores: List[Int] = List(10000, 2000, 1121, 1)
val best :: rest = highScores

println(s"Highest rank got $best points" )

//// "for" comprehension ---------------------------------------

def gameResults() : Seq[(String, Int)] =
  ("Homer", 3500) :: ("Carl", 13000) :: ("Lenny", 7000) :: Nil

def hallOfFame = for {
  (name, score) <- gameResults()
  if score > 5000
} yield name

println(hallOfFame)

//// anonymous functions / partial functions

val players = ("Homer", 3500) :: ("Carl", 13000) :: ("Lenny", 1) :: Nil
val topScorer = players.collect { case (name, points) if points > 1 => name}

println(s"top scorer are ${topScorer.mkString(", ")}")








