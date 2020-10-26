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
        holder.icon!!.setImageResource(itemList[position].getImageId(context))
        if ((itemList[position].xCord + itemList[position].yCord) % 2 == 1){
            holder.box!!.setBackgroundColor(Color.parseColor("#FF2C2A2A"))
        }else{
            holder.box!!.setBackgroundColor(Color.parseColor("#FFA6A5A5"))
        }


        return convertView!!
    }

    internal class ItemHolder {
        var box: LinearLayout? = null
        var icon: ImageView? = null
    }

}