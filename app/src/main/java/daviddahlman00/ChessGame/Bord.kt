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
        setBordString()
    }
    private fun newBord(){
        bord.clear()
        makeBord()
    }

    fun legalMove(position : Position): List<Int>{
        val legalMoves = mutableListOf<Int>()
        when(position.character){
            "dark_knight"  -> {
                darkKnight(position, legalMoves)
            }
            "light_knight"  -> {
               lightKnight(position, legalMoves)
            }
            "dark_pawn" -> {
                darkPawn(position, legalMoves)
            }
            "light_pawn" -> {
                lightPawn(position, legalMoves)
            }
        }
        return legalMoves
    }

    private fun setBordString(){
        for (pos in bord){
            when{
                (pos.yCord == 0 && pos.xCord == 0) || (pos.yCord == 0 && pos.xCord == 7)->{
                    pos.character = "dark_rook"
                    pos.player = "dark"
                }
                (pos.yCord == 7 && pos.xCord == 0) || (pos.yCord == 7 && pos.xCord == 7)->{
                    pos.character = "light_rook"
                    pos.player = "light"
                }
                (pos.yCord == 0 && pos.xCord == 1) || (pos.yCord == 0 && pos.xCord == 6)->{
                    pos.character = "dark_knight"
                    pos.player = "dark"
                }
                (pos.yCord == 7 && pos.xCord == 1) || (pos.yCord == 7 && pos.xCord == 6)->{
                    pos.character = "light_knight"
                    pos.player = "light"
                }
                (pos.yCord == 0 && pos.xCord == 2) || (pos.yCord == 0 && pos.xCord == 5)->{
                    pos.character = "dark_bishop"
                    pos.player = "dark"
                }
                (pos.yCord == 7 && pos.xCord == 2) || (pos.yCord == 7 && pos.xCord == 5)->{
                    pos.character = "light_bishop"
                    pos.player = "light"
                }
                (pos.yCord == 0 && pos.xCord == 3)->{
                    pos.character = "dark_queen"
                    pos.player = "dark"
                }
                (pos.yCord == 7 && pos.xCord == 3)->{
                    pos.character = "light_queen"
                    pos.player = "light"
                }
                (pos.yCord == 0 && pos.xCord == 4)->{
                    pos.character = "dark_king"
                    pos.player = "dark"
                }
                (pos.yCord == 7 && pos.xCord == 4)->{
                    pos.character = "light_king"
                    pos.player = "light"
                }
                (pos.yCord == 1)->{
                    pos.character = "dark_pawn"
                    pos.player = "dark"
                }
                (pos.yCord == 6)->{
                    pos.character = "light_pawn"
                    pos.player = "light"
                }
            }
        }
    }
    private fun lightKnight(position: Position, legalMoves: MutableList<Int>){
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

    private fun darkKnight(position : Position, legalMoves : MutableList<Int>){
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

    private fun lightPawn(position : Position, legalMoves : MutableList<Int>){
        if ((position.yCord - 1 in 0..7)&& (bord[position.xCord + 8 * (position.yCord - 1)].player == "none")){
            legalMoves.add(position.xCord + 8 * (position.yCord - 1))
            if ((position.yCord == 6) && (bord[position.xCord + 8 * (position.yCord - 2)].player == "none")){
                legalMoves.add(position.xCord + 8 * (position.yCord - 2))
            }
        }
        if ((position.xCord + 1 in 0..7) && (position.yCord - 1 in 0..7)
            && (bord[position.xCord + 1 + 8 * (position.yCord - 1)].player == "dark")){
            legalMoves.add(position.xCord + 1 + 8 * (position.yCord - 1))
        }
        if ((position.xCord - 1 in 0..7) && (position.yCord - 1 in 0..7)
            && (bord[position.xCord - 1 + 8 * (position.yCord - 1)].player == "dark")){
            legalMoves.add(position.xCord - 1 + 8 * (position.yCord - 1))
        }
    }

    private fun darkPawn(position : Position, legalMoves : MutableList<Int>){
        if ((position.yCord + 1 in 0..7)&& (bord[position.xCord + 8 * (position.yCord + 1)].player == "none")){
            legalMoves.add(position.xCord + 8 * (position.yCord + 1))
            if ((position.yCord == 1) && (bord[position.xCord + 8 * (position.yCord + 2)].player == "none")){
                legalMoves.add(position.xCord + 8 * (position.yCord + 2))
            }
        }
        if ((position.xCord + 1 in 0..7) && (position.yCord + 1 in 0..7)
            && (bord[position.xCord + 1 + 8 * (position.yCord + 1)].player == "light")){
            legalMoves.add(position.xCord + 1 + 8 * (position.yCord + 1))
        }
        if ((position.xCord - 1 in 0..7) && (position.yCord + 1 in 0..7)
            && (bord[position.xCord - 1 + 8 * (position.yCord + 1)].player == "light")){
            legalMoves.add(position.xCord - 1 + 8 * (position.yCord + 1))
        }
    }
}