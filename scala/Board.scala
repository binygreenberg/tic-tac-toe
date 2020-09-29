class Board(val size: Int) {
  val board = Array.ofDim[Char](size, size)
  for {
     i <- 0 until size
     j <- 0 until size
    } board(i)(j) = ' '

  def addPiece(x: Int, y: Int, c: Char): Boolean = {
    if (x < 0 || x >= size || y < 0 || y >= size || board(x)(y) != ' ')
      false
    else {
      board(x)(y) = c
      true
    }
  }

  def didWin(x: Int, y:Int, c: Char): Boolean = {
      if (x < 0 || x >= size || y < 0 || y >= size) false
      def checkDidWin(i: Int, f: Int => Boolean): Boolean = {
        if (i == size)
          true
        else if (f(i) == false){
          false
        } else {
          checkDidWin(i + 1, f)
        }
      }
      
      def checkColUpdate(i: Int): Boolean = {
        board(x)(i) == c
      }

      def checkRowUpdate(i: Int): Boolean = {
        board(i)(y) == c
      }

      def checkDiag(i: Int): Boolean = {
        board(i)(i) == c
      }

      def checkAntiDiag(i: Int): Boolean = {
        board(i)((size-1) - i) == c
      }
      
      checkDidWin(0, checkColUpdate) || checkDidWin(0, checkRowUpdate) || checkDidWin(0, checkDiag) || checkDidWin(0, checkAntiDiag)
  }

  override def toString: String = board.map(_.mkString("|")).mkString("\n" + "-" * (size * 2 - 1) + "\n")
}
