import scala.io.StdIn.readLine

class Player(val piece: Char) {
  def moveAndCheckWin(b: Board): Boolean = {
    var addPiece = true
    var x, y = 0
    while (addPiece) {
      println(s"player '${piece}' place your piece. two comma seperated numbers. for example: 2,1")
      val input = readLine().split(",").map(_.toInt)
      x = input(0)
      y = input(1)
      if (!b.addPiece(x, y, piece))
        println("illegal move please try again")
      else
        addPiece = false
    }
    b.didWin(x, y, piece)
  }
}