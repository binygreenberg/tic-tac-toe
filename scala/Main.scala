object Main extends App {
  val b = new Board(3)
  val p1 = new Player('x')
  val p2 = new Player('o')
  var gameOver = false
  while(!gameOver){
    println(b)
    if (p1.moveAndCheckWin(b) ) {
      println(s"player '${p1.piece}' won!!")
      gameOver = true;
    }
    println(b)
    if (!gameOver){
      if (p2.moveAndCheckWin(b)) {
        println(s"player '${p2.piece}' won!!")
        gameOver = true;
      }
    }
  }
}