package daviddahlman00.ChessGame

import android.content.Context

class Position(val name : String, var character : String = "", var player : String = "none", val xCord : Int, val yCord : Int) {
    fun getImageId(context: Context) : Int {
        return context.resources.getIdentifier("drawable/$character", null, context.packageName)
    }
}