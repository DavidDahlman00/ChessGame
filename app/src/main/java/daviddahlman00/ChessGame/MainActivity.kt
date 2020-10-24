package daviddahlman00.ChessGame

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gridview = findViewById<GridView>(R.id.gridview)
        val bord = makeBord()
        val adapter = ImageListAdapter(this, R.layout.item_list, bord)
        gridview.adapter = adapter

        gridview.onItemClickListener = AdapterView.OnItemClickListener { parent, v, position, id ->
            if (bord[position].clicked == false){
                v.setBackgroundColor(Color.parseColor("#FF03DAC5"))
                bord[position].clicked = true
            }else{
                if ((bord[position].xCord + bord[position].yCord) % 2 == 1){
                    v.setBackgroundColor(Color.parseColor("#000000"))
                }else{
                    v.setBackgroundColor(Color.parseColor("#737272"))
                }
                bord[position].clicked = false
            }

            Toast.makeText(this@MainActivity, " Clicked Position: " + bord[position].xCord + ": " + bord[position].yCord,
                    Toast.LENGTH_SHORT).show()
        }

    }


    private fun makeBord() : List<Position>{
        val column = arrayOf("A", "B", "C", "D", "E", "F", "G", "H")
        val rows = arrayOf("8", "7", "6", "5", "4", "3", "2", "1")
        val bord = mutableListOf<Position>()
        var x = 0
        var y = 0
        for(row in rows){
            for (col in column){
                val x = column.indexOf(col)
                val y = rows.indexOf(row)
                bord.add(Position(name = col + rows, character = "", clicked = false, player = "none", xCord = x, yCord = y))
            }
        }
        return bord
    }

}