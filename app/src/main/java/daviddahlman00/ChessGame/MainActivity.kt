package daviddahlman00.ChessGame

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import androidx.core.view.get

class MainActivity : AppCompatActivity() {
    private var activPosition = false
    private var whiteToGo = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gridView = findViewById<GridView>(R.id.gridview)
        val bord = Bord()
        val adapter = ImageListAdapter(this, R.layout.item_list, bord.bord)
        gridView.adapter = adapter

        gridView.onItemClickListener = AdapterView.OnItemClickListener { parent, v, position, id ->
            if (!bord.bord[position].clicked){
                if (whiteToGo && bord.bord[position].player =="light"){
                    unacitvatePositions(bord.bord, gridView)
                    v.setBackgroundColor(Color.parseColor("#FF03DAC5"))
                    bord.bord[position].clicked = true
                    activPosition = true
                    messageFun(position, bord.bord)
                }else if(!whiteToGo && bord.bord[position].player =="dark"){
                    unacitvatePositions(bord.bord, gridView)
                    v.setBackgroundColor(Color.parseColor("#FF03DAC5"))
                    bord.bord[position].clicked = true
                    activPosition = true
                    messageFun(position, bord.bord)
                }

            }else{
                if ((bord.bord[position].xCord + bord.bord[position].yCord) % 2 == 1){
                    v.setBackgroundColor(Color.parseColor("#FF2C2A2A"))
                }else{
                    v.setBackgroundColor(Color.parseColor("#FFA6A5A5"))
                }
                bord.bord[position].clicked = false
                activPosition = false
            }
        }

    }
    fun messageFun(i: Int, bord: List<Position>){
        Toast.makeText(this@MainActivity, " Clicked Position: " + bord[i].xCord + ": " + bord[i].yCord,
            Toast.LENGTH_SHORT).show()
    }



    private fun unacitvatePositions(bord :List<Position>, gridview : GridView){
        for(pos in bord){
            pos.clicked = false
        }
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