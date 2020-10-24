package daviddahlman00.ChessGame

import android.content.Context

class Position(val name : String, var character : String, var clicked : Boolean, var player : String, val xCord : Int, val yCord : Int) {
    fun getImageId(context: Context) : Int {
        val str = "piece_" + character
        return context.resources.getIdentifier("drawable/$str", null, context.packageName)
    }
}