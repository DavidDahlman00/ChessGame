package daviddahlman00.ChessGame

import android.content.Context

class Position(val name : String, var character : String = "", var player : String = "none", val xCord : Int, val yCord : Int, var enPassant : Boolean = false) {
    fun getImageId(context: Context) : Int {
        return context.resources.getIdentifier("drawable/$character", null, context.packageName)
    }
    fun getPosition() : Int{
        return xCord + (8 * yCord)
    }
}