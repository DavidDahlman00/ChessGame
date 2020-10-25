package daviddahlman00.ChessGame

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.LinearLayout

internal class ImageListAdapter internal constructor(context: Context, private val resource: Int, private val itemList: List<Position>) :
    ArrayAdapter<ImageListAdapter.ItemHolder>(context, resource){

    override fun getCount(): Int {
        return this.itemList.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView

        val holder: ItemHolder
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(resource, null)
            holder = ItemHolder()
            holder.box = convertView!!.findViewById(R.id.box)
            holder.icon = convertView.findViewById(R.id.icon)
            convertView.tag = holder
        } else {
            holder = convertView.tag as ItemHolder
        }


        setBordString(itemList)
        //holder.icon!!.setImageResource(R.drawable.dark_bishop)
        holder.icon!!.setImageResource(itemList[position].getImageId(context))
        if ((itemList[position].xCord + itemList[position].yCord) % 2 == 1){
            holder.box!!.setBackgroundColor(Color.parseColor("#FF2C2A2A"))
        }else{
            holder.box!!.setBackgroundColor(Color.parseColor("#FFA6A5A5"))
        }


        return convertView
    }

    private fun setBordString(itemList: List<Position>){
        for (pos in itemList){
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

    internal class ItemHolder {
        var box: LinearLayout? = null
        var icon: ImageView? = null
    }

}