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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gridview = findViewById<GridView>(R.id.gridview)
        val bord = makeBord()
        val adapter = ImageListAdapter(this, R.layout.item_list, bord)
        gridview.adapter = adapter

        gridview.onItemClickListener = AdapterView.OnItemClickListener { parent, v, position, id ->
            if (!bord[position].clicked){
                unacitvatePositions(bord)
                for (pos in 0 until gridview.adapter.count){
                    if((bord[pos].xCord + bord[pos].yCord) % 2 == 1){
                        gridview[pos].setBackgroundColor(Color.parseColor("#FF2C2A2A"))
                    }else{
                        gridview[pos].setBackgroundColor(Color.parseColor("#FFA6A5A5"))
                    }
                }
                v.setBackgroundColor(Color.parseColor("#FF03DAC5"))

                bord[position].clicked = true
                activPosition = true
            }else{
                if ((bord[position].xCord + bord[position].yCord) % 2 == 1){
                    v.setBackgroundColor(Color.parseColor("#FF2C2A2A"))
                }else{
                    v.setBackgroundColor(Color.parseColor("#FFA6A5A5"))
                }
                bord[position].clicked = false
                activPosition = false
            }

            Toast.makeText(this@MainActivity, " Clicked Position: " + bord[position].xCord + ": " + bord[position].yCord,
                    Toast.LENGTH_SHORT).show()
        }

    }


    private fun makeBord() : List<Position>{
        val column = arrayOf("A", "B", "C", "D", "E", "F", "G", "H")
        val rows = arrayOf("8", "7", "6", "5", "4", "3", "2", "1")
        val bord = mutableListOf<Position>()
        for(row in rows){
            for (col in column){
                val x = column.indexOf(col)
                val y = rows.indexOf(row)
                bord.add(Position(name = col + rows, character = "", clicked = false, player = "none", xCord = x, yCord = y))
            }
        }
        return bord
    }

    private fun unacitvatePositions(bord :List<Position>){
        for(pos in bord){
            pos.clicked = false
        }
        activPosition = false
    }

}