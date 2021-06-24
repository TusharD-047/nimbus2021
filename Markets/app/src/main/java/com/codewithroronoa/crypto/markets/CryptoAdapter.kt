package com.codewithroronoa.crypto.markets

import android.graphics.Color
import android.provider.CalendarContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.DecimalFormat
import kotlin.math.roundToInt

class CryptoAdapter : RecyclerView.Adapter<CryptoAdapter.MyViewHolder>() {

    var items = ArrayList<marketsAll>()

    fun setUpdatedData(items : ArrayList<marketsAll>){
        this.items = items
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val coin = itemView.findViewById<TextView>(R.id.coin_name)
        val exch = itemView.findViewById<TextView>(R.id.exchange_name)
        val change = itemView.findViewById<TextView>(R.id.change)
        val spread = itemView.findViewById<TextView>(R.id.spread)
        val price = itemView.findViewById<TextView>(R.id.price)
        val pri_un = itemView.findViewById<TextView>(R.id.price_uncoverted)
        val vol = itemView.findViewById<TextView>(R.id.volume)


        fun bind(data : marketsAll){
            val df = DecimalFormat("#.###")
            coin.text = data.symbol
            exch.text = data.exchange_id
            change.text = df.format(data.change_24h).toString()+ "%"
            spread.text = df.format(data.spread).toString()
            price.text = "$ "+df.format(data.price).toString()
            pri_un.text = df.format(data.price_unconverted).toString()
            vol.text = df.format(data.volume_24h).toString()
            if(data.change_24h>0)
                change.setTextColor(Color.parseColor("#006400"))
            else
                change.setTextColor(Color.RED)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items.get(position))
    }

    override fun getItemCount(): Int {
        return items.size
    }
}