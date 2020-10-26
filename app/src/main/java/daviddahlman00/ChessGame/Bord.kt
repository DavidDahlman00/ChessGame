package daviddahlman00.ChessGame

class Bord() {
    val bord = mutableListOf<Position>()
    init {
        makeBord()
    }
    private fun makeBord(){
        val column = arrayOf("A", "B", "C", "D", "E", "F", "G", "H")
        val rows = arrayOf("8", "7", "6", "5", "4", "3", "2", "1")
        for(row in rows){
            for (col in column){
                val x = column.indexOf(col)
                val y = rows.indexOf(row)
                bord.add(Position(name = "col" + "," + "rows", character = "", player = "none", xCord = x, yCord = y))
            }
        }

    }
    private fun newBord(){
        bord.clear()
        makeBord()
    }
    /*
    private fun getPositionAt(x : Int, y : Int) : Position{

    }*/

    fun legalMove(position : Position): List<Int>{
        val legalMoves = mutableListOf<Int>()
        when(position.character){
            "dark_knight"  ->{
                if ((position.xCord + 2 in 0..7) && (position.yCord + 1 in 0..7)){
                    if (bord[position.xCord + 2 + 8 * (position.yCord + 1)].player!="dark"){
                        legalMoves.add(position.xCord + 2 + 8 * (position.yCord + 1))
                    }
                }
                if ((position.xCord + 2 in 0..7) && (position.yCord - 1 in 0..7)){
                    if (bord[position.xCord + 2 + 8 * (position.yCord - 1)].player!="dark"){
                        legalMoves.add(position.xCord + 2 + 8 * (position.yCord - 1))
                    }
                }
                if ((position.xCord - 2 in 0..7) && (position.yCord + 1 in 0..7)){
                    if (bord[position.xCord - 2 + 8 * (position.yCord + 1)].player!="dark"){
                        legalMoves.add(position.xCord - 2 + 8 * (position.yCord + 1))
                    }
                }
                if ((position.xCord - 2 in 0..7) && (position.yCord - 1 in 0..7)){
                    if (bord[position.xCord - 2 + 8 * (position.yCord - 1)].player!="dark"){
                        legalMoves.add(position.xCord - 2 + 8 * (position.yCord - 1))
                    }
                }
                if ((position.xCord + 1 in 0..7) && (position.yCord + 2 in 0..7)){
                    if (bord[position.xCord + 1 + 8 * (position.yCord + 2)].player!="dark"){
                        legalMoves.add(position.xCord + 1 + 8 * (position.yCord + 2))
                    }
                }
                if ((position.xCord + 1 in 0..7) && (position.yCord - 2 in 0..7)){
                    if (bord[position.xCord + 1 + 8 * (position.yCord - 2)].player!="dark"){
                        legalMoves.add(position.xCord + 1 + 8 * (position.yCord - 2))
                    }
                }
                if ((position.xCord - 1 in 0..7) && (position.yCord + 2 in 0..7)){
                    if (bord[position.xCord - 1 + 8 * (position.yCord + 2)].player!="dark"){
                        legalMoves.add(position.xCord - 1 + 8 * (position.yCord + 2))
                    }
                }
                if ((position.xCord - 1 in 0..7) && (position.yCord - 2 in 0..7)){
                    if (bord[position.xCord - 1 + 8 * (position.yCord - 2)].player!="dark"){
                        legalMoves.add(position.xCord - 1 + 8 * (position.yCord - 2))
                    }
                }

            }
            "light_knight"  ->{
                if ((position.xCord + 2 in 0..7) && (position.yCord + 1 in 0..7)){
                    if (bord[position.xCord + 2 + 8 * (position.yCord + 1)].player!="light"){
                        legalMoves.add(position.xCord + 2 + 8 * (position.yCord + 1))
                    }
                }
                if ((position.xCord + 2 in 0..7) && (position.yCord - 1 in 0..7)){
                    if (bord[position.xCord + 2 + 8 * (position.yCord - 1)].player!="light"){
                        legalMoves.add(position.xCord + 2 + 8 * (position.yCord - 1))
                    }
                }
                if ((position.xCord - 2 in 0..7) && (position.yCord + 1 in 0..7)){
                    if (bord[position.xCord - 2 + 8 * (position.yCord + 1)].player!="light"){
                        legalMoves.add(position.xCord - 2 + 8 * (position.yCord + 1))
                    }
                }
                if ((position.xCord - 2 in 0..7) && (position.yCord - 1 in 0..7)){
                    if (bord[position.xCord - 2 + 8 * (position.yCord - 1)].player!="light"){
                        legalMoves.add(position.xCord - 2 + 8 * (position.yCord - 1))
                    }
                }
                if ((position.xCord + 1 in 0..7) && (position.yCord + 2 in 0..7)){
                    if (bord[position.xCord + 1 + 8 * (position.yCord + 2)].player!="light"){
                        legalMoves.add(position.xCord + 1 + 8 * (position.yCord + 2))
                    }
                }
                if ((position.xCord + 1 in 0..7) && (position.yCord - 2 in 0..7)){
                    if (bord[position.xCord + 1 + 8 * (position.yCord - 2)].player!="light"){
                        legalMoves.add(position.xCord + 1 + 8 * (position.yCord - 2))
                    }
                }
                if ((position.xCord - 1 in 0..7) && (position.yCord + 2 in 0..7)){
                    if (bord[position.xCord - 1 + 8 * (position.yCord + 2)].player!="light"){
                        legalMoves.add(position.xCord - 1 + 8 * (position.yCord + 2))
                    }
                }
                if ((position.xCord - 1 in 0..7) && (position.yCord - 2 in 0..7)){
                    if (bord[position.xCord - 1 + 8 * (position.yCord - 2)].player!="light"){
                        legalMoves.add(position.xCord - 1 + 8 * (position.yCord - 2))
                    }
                }
            }
        }

        return legalMoves
    }

}