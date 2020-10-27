package daviddahlman00.ChessGame

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.get

class MainActivity : AppCompatActivity() {
    private var activPosition = false
    private var whiteToGo = true
    private val moveList = mutableListOf<Int>()
    private var clickedPosision = -1
    private lateinit var toGoText : TextView
    private lateinit var schackText : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gridView = findViewById<GridView>(R.id.gridview)
        val bord = Bord()
        toGoText = findViewById(R.id.player_to_go)
        schackText = findViewById(R.id.schack_text)
        val adapter = ImageListAdapter(this, R.layout.item_list, bord.bord)
        gridView.adapter = adapter
        gridView.onItemClickListener = AdapterView.OnItemClickListener { parent, v, position, id ->
            if (position in moveList){
                move(clickedPosision, position, bord)
                adapter.notifyDataSetChanged()
            }else  if (position != clickedPosision){
                if ((whiteToGo && bord.bord[position].player =="light")
                    && !(bord.legalMove(bord.bord[position]).isNullOrEmpty())){
                    unacitvatePositions(bord.bord, gridView)
                    v.setBackgroundColor(Color.parseColor("#FF03DAC5"))

                    val possibleMoves = bord.legalMove(bord.bord[position])
                    for (elm in possibleMoves){
                        if ((bord.bord[elm].xCord + bord.bord[elm].yCord) % 2 == 1){
                            gridView[elm].setBackgroundColor(Color.parseColor("#016362"))
                        }else{
                            gridView[elm].setBackgroundColor(Color.parseColor("#039897"))
                        }
                        moveList.add(elm)
                    }
                    activPosition = true
                    clickedPosision = position
                    messageFun(position, bord.bord)
                }else if((!whiteToGo && bord.bord[position].player =="dark") && !(bord.legalMove(bord.bord[position]).isNullOrEmpty())){
                    unacitvatePositions(bord.bord, gridView)
                    v.setBackgroundColor(Color.parseColor("#FF03DAC5"))

                    val possibleMoves = bord.legalMove(bord.bord[position])
                    for (elm in possibleMoves){
                        if ((bord.bord[elm].xCord + bord.bord[elm].yCord) % 2 == 1){
                            gridView[elm].setBackgroundColor(Color.parseColor("#016362"))
                        }else{
                            gridView[elm].setBackgroundColor(Color.parseColor("#039897"))
                        }
                        moveList.add(elm)
                    }
                    activPosition = true
                    clickedPosision = position
                    messageFun(position, bord.bord)
                }

            }else{
                moveList.clear()
                clickedPosision = -1
                if ((bord.bord[position].xCord + bord.bord[position].yCord) % 2 == 1){
                    unacitvatePositions(bord.bord, gridView)
                    v.setBackgroundColor(Color.parseColor("#FF2C2A2A"))
                }else{
                    unacitvatePositions(bord.bord, gridView)
                    v.setBackgroundColor(Color.parseColor("#FFA6A5A5"))
                }

                activPosition = false
            }
        }

    }
    private fun messageFun(i: Int, bord: List<Position>){
        Toast.makeText(this@MainActivity, " Clicked Position: " + bord[i].xCord + ": " + bord[i].yCord,
            Toast.LENGTH_SHORT).show()
    }

    private fun enPassant(from : Int, to : Int, bord: Bord){
        if ((bord.bord[from].character == "light_pawn") && (bord.bord[from].yCord == 6) && (bord.bord[to].yCord == 4)){
            bord.bord[from].enPassant = true
        }else bord.bord[from].enPassant = (bord.bord[from].character == "dark_pawn") && (bord.bord[from].yCord == 1) && (bord.bord[to].yCord == 3)
    }

    @SuppressLint("SetTextI18n")
    private fun move(from : Int, to : Int, bord: Bord){
        enPassant(from, to, bord)
        bord.bord[to].character = bord.bord[from].character
        bord.bord[to].player = bord.bord[from].player
        bord.bord[to].enPassant = bord.bord[from].enPassant
        bord.bord[from].character = ""
        bord.bord[from].player = "none"
        bord.bord[from].enPassant = false
        clickedPosision = -1
        moveList.clear()
        whiteToGo = !whiteToGo

        if (whiteToGo){
            toGoText.text = "White to go!"
        }else{
            toGoText.text = "Black to go!"
        }

        when(bord.bord[to].character){
            "dark_king" -> {
                val pos = bord.bord[to].getPosition()
                bord.setDarkKingPosition(pos)
            }
            "light_king" -> {
                val pos = bord.bord[to].getPosition()
                bord.setLightKingPosition(pos)
            }
        }

        if (bord.isSchack(whiteToGo)){
            schackText.text = "Schack"
        }
    }

    private fun unacitvatePositions(bord :List<Position>, gridview : GridView){
        activPosition = false
        for (pos in 0 until gridview.adapter.count){
            if((bord[pos].xCord + bord[pos].yCord) % 2 == 1){
                gridview[pos].setBackgroundColor(Color.parseColor("#FF2C2A2A"))
            }else{
                gridview[pos].setBackgroundColor(Color.parseColor("#FFA6A5A5"))
            }
        }
    }

}

