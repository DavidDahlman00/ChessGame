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
        return if (this.itemList != null) this.itemList.size else 0
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

        //holder.name!!.text = this.itemList!![position]
       // holder.icon!!.setImageResource(R.mipmap.ic_launcher)
        //holder.icon!!.setImageResource(R.drawable.piece_pd)

        setBordString(holder, itemList)
        holder.icon!!.setImageResource(itemList[position].getImageId(context))
        if ((itemList[position].xCord + itemList[position].yCord) % 2 == 1){
            holder.box!!.setBackgroundColor(Color.parseColor("#FF2C2A2A"))
        }else{
            holder.box!!.setBackgroundColor(Color.parseColor("#FFA6A5A5"))
        }


        return convertView!!
    }

    fun setBordString(holder: ItemHolder, itemList: List<Position>){
        for (pos in itemList){
            when{
                (pos.yCord == 0 && pos.xCord == 0) || (pos.yCord == 0 && pos.xCord == 7)->{
                    pos.character = "rd"
                    pos.player = "dark"
                }
                (pos.yCord == 7 && pos.xCord == 0) || (pos.yCord == 7 && pos.xCord == 7)->{
                    pos.character = "rl"
                    pos.player = "light"
                }
                (pos.yCord == 0 && pos.xCord == 1) || (pos.yCord == 0 && pos.xCord == 6)->{
                    pos.character = "nd"
                    pos.player = "dark"
                }
                (pos.yCord == 7 && pos.xCord == 1) || (pos.yCord == 7 && pos.xCord == 6)->{
                    pos.character = "nl"
                    pos.player = "light"
                }
                (pos.yCord == 0 && pos.xCord == 2) || (pos.yCord == 0 && pos.xCord == 5)->{
                    pos.character = "bd"
                    pos.player = "dark"
                }
                (pos.yCord == 7 && pos.xCord == 2) || (pos.yCord == 7 && pos.xCord == 5)->{
                    pos.character = "bl"
                    pos.player = "light"
                }
                (pos.yCord == 0 && pos.xCord == 3)->{
                    pos.character = "qd"
                    pos.player = "dark"
                }
                (pos.yCord == 7 && pos.xCord == 3)->{
                    pos.character = "ql"
                    pos.player = "light"
                }
                (pos.yCord == 0 && pos.xCord == 4)->{
                    pos.character = "kd"
                    pos.player = "dark"
                }
                (pos.yCord == 7 && pos.xCord == 4)->{
                    pos.character = "kl"
                    pos.player = "light"
                }
                (pos.yCord == 1)->{
                    pos.character = "pd"
                    pos.player = "dark"
                }
                (pos.yCord == 6)->{
                    pos.character = "pl"
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