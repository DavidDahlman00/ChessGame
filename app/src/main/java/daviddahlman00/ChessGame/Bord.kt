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
                bord.add(Position(name = "col" + "," + "rows", character = "", clicked = false, player = "none", xCord = x, yCord = y))
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

    fun legaleMove(position : Position): List<Position>{
        val legalMoves = mutableListOf<Position>()
        when(position.character){
            "dark_knight"  ->{

                for (elm in bord){
                    if ((elm.xCord == position.xCord + 2) && (elm.xCord == position.yCord + 1)
                        && elm.player != "dark"
                    ){
                        legalMoves.add(elm)
                    }
                    if ((elm.xCord == position.xCord + 2) && (elm.xCord == position.yCord - 1)
                        && elm.player != "dark"
                    ){
                        legalMoves.add(elm)
                    }
                    if ((elm.xCord == position.xCord - 2) && (elm.xCord == position.yCord + 1)
                        && elm.player != "dark"
                    ){
                        legalMoves.add(elm)
                    }
                    if ((elm.xCord == position.xCord - 2) && (elm.xCord == position.yCord - 1)
                        && elm.player != "dark"
                    ){
                        legalMoves.add(elm)
                    }
                    if ((elm.xCord == position.xCord + 1) && (elm.xCord == position.yCord + 2)
                        && elm.player != "dark"
                    ){
                        legalMoves.add(elm)
                    }
                }
            }
            "light_knight"  ->{

                for (elm in bord){
                    if ((elm.xCord == position.xCord + 2) && (elm.xCord == position.yCord + 1)
                        && elm.player != "light"
                    ){
                        legalMoves.add(elm)
                    }
                    if ((elm.xCord == position.xCord + 2) && (elm.xCord == position.yCord - 1)
                        && elm.player != "light"
                    ){
                        legalMoves.add(elm)
                    }
                    if ((elm.xCord == position.xCord - 2) && (elm.xCord == position.yCord + 1)
                        && elm.player != "light"
                    ){
                        legalMoves.add(elm)
                    }
                    if ((elm.xCord == position.xCord - 2) && (elm.xCord == position.yCord - 1)
                        && elm.player != "light"
                    ){
                        legalMoves.add(elm)
                    }
                    if ((elm.xCord == position.xCord + 1) && (elm.xCord == position.yCord + 2)
                        && elm.player != "light"
                    ){
                        legalMoves.add(elm)
                    }
                }
            }

        }

        return legalMoves
    }

}